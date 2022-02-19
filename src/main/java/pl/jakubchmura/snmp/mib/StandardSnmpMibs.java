package pl.jakubchmura.snmp.mib;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.GlobalSearchScopesCore;
import com.intellij.util.indexing.IndexableSetContributor;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.settings.AdditionalMibPath;
import pl.jakubchmura.snmp.mib.settings.ProjectSettingsState;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StandardSnmpMibs extends IndexableSetContributor {

    private static final String DIRECTORY = "/pl/jakubchmura/snmp/mib/mibs/";
    private static final List<String> FILE_NAMES = Arrays.asList("SNMPv2-SMI", "SNMPv2-TC", "SNMPv2-CONF", "RFC1155-SMI", "RFC1212-MIB", "RFC1213-MIB", "RFC1215-MIB");

    private static final Set<VirtualFile> MIBS = FILE_NAMES.stream()
            .map(s -> DIRECTORY + s)
            .map(StandardSnmpMibs.class::getResource)
            .filter(Objects::nonNull)
            .map(VfsUtil::findFileByURL)
            .collect(Collectors.toSet());

    public static GlobalSearchScope getScope(@NotNull Project project) {
        Stream<GlobalSearchScope> additionalMibs = Arrays.stream(ProjectSettingsState.getInstance(project).getAdditionalMibPaths())
                .map(mibPath -> getGlobalSearchScope(mibPath, project));
        Stream<GlobalSearchScope> rfcMibs = Stream.of(GlobalSearchScope.filesScope(project, MIBS));
        return GlobalSearchScope.union(Stream.concat(additionalMibs, rfcMibs).collect(Collectors.toList()));
    }

    public static <T extends PsiElement> List<T> filterOutStandardMibs(Collection<T> elements) {
        List<T> standardElements = new ArrayList<>();
        List<T> customElements = new ArrayList<>();

        Set<VirtualFile> additionalMibs;
        if (elements.isEmpty()) {
            additionalMibs = Collections.emptySet();
        } else {
            additionalMibs = getAdditionalMibs(elements.iterator().next().getProject());
        }

        for (T element : elements) {
            VirtualFile virtualFile = element.getContainingFile().getVirtualFile();
            if (MIBS.contains(virtualFile)) {
                standardElements.add(element);
            } else if (rootsContain(additionalMibs, virtualFile)) {
                standardElements.add(element);
            } else {
                customElements.add(element);
            }
        }

        if (!customElements.isEmpty()) {
            return customElements;
        } else {
            return standardElements;
        }
    }

    private static boolean rootsContain(Set<VirtualFile> roots, VirtualFile virtualFile) {
        Path child = virtualFile.toNioPath().normalize();
        for (VirtualFile root : roots) {
            if (root.isDirectory()) {
                Path rootPath = root.toNioPath().normalize();
                if (child.startsWith(rootPath)) {
                    return true;
                }
            } else {
                if (root.equals(virtualFile)) {
                    return true;
                }
            }
        }
        return false;
    }

    @NotNull
    @Override
    public Set<VirtualFile> getAdditionalRootsToIndex() {
        return MIBS;
    }

    @NotNull
    private static Set<VirtualFile> getAdditionalMibs(@NotNull Project project) {
        return Arrays.stream(ProjectSettingsState.getInstance(project).getAdditionalMibPaths())
                .map(AdditionalMibPath::getVirtualFile)
                .collect(Collectors.toSet());
    }

    private static GlobalSearchScope getGlobalSearchScope(AdditionalMibPath mibPath, @NotNull Project project) {
        if (!mibPath.isValid()) {
            return GlobalSearchScope.EMPTY_SCOPE;
        }
        if (mibPath.isFile()) {
            return GlobalSearchScope.fileScope(project, mibPath.getVirtualFile());
        } else {
            return GlobalSearchScopesCore.directoriesScope(project, mibPath.isIncludeSubdirectories(),
                    mibPath.getVirtualFile());
        }
    }

    @Override
    public @NotNull Set<VirtualFile> getAdditionalProjectRootsToIndex(@NotNull Project project) {
        return getAdditionalMibs(project);
    }
}
