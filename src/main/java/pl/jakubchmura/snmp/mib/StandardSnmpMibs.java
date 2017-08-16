package pl.jakubchmura.snmp.mib;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.indexing.IndexableSetContributor;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class StandardSnmpMibs extends IndexableSetContributor {

    private static final String DIRECTORY = "/pl/jakubchmura/snmp/mib/mibs/";
    private static final List<String> FILE_NAMES = Arrays.asList("SNMPv2-SMI", "SNMPv2-TC", "SNMPv2-CONF", "RFC1155-SMI");

    private static final Set<VirtualFile> MIBS = FILE_NAMES.stream()
            .map(s -> DIRECTORY + s)
            .map(StandardSnmpMibs.class::getResource)
            .map(VfsUtil::findFileByURL)
            .collect(Collectors.toSet());

    public static GlobalSearchScope getScope(@NotNull Project project) {
        return GlobalSearchScope.filesScope(project, MIBS);
    }

    public static <T extends PsiElement> List<T> filterOutStandardMibs(Collection<T> elements) {
        List<T> standardElements = new ArrayList<>();
        List<T> customElements = new ArrayList<>();

        for (T element : elements) {
            VirtualFile virtualFile = element.getContainingFile().getVirtualFile();
            if (MIBS.contains(virtualFile)) {
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

    @NotNull
    @Override
    public Set<VirtualFile> getAdditionalRootsToIndex() {
        return MIBS;
    }
}
