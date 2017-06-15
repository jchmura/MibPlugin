package pl.jakubchmura.snmp.mib.util;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.ResolveResult;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.MibFileType;
import pl.jakubchmura.snmp.mib.StandardSnmpv2Mibs;
import pl.jakubchmura.snmp.mib.psi.SmiReferenceableElement;
import pl.jakubchmura.snmp.mib.psi.SmiSymbol;
import pl.jakubchmura.snmp.mib.psi.SmiSymbolName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SmiFindUtil {

    public static List<MibFile> getMibFiles(@NotNull Project project, @Nullable GlobalSearchScope scope) {
        List<VirtualFile> files = new ArrayList<>(StandardSnmpv2Mibs.MIBS);
        if (scope != null) {
            files.addAll(FileTypeIndex.getFiles(MibFileType.INSTANCE, scope));
        }
        return files.stream()
                .map(virtualFile -> PsiManager.getInstance(project).findFile(virtualFile))
                .filter(Objects::nonNull)
                .map(MibFile.class::cast)
                .collect(Collectors.toList());
    }

    public static <T extends SmiReferenceableElement> List<T> findImportedElements(MibFile file, Class<T> identifiableElementClass) {
        return file.getImportedSymbols()
                .stream()
                .flatMap(e -> e.getSymbolList().stream())
                .map(SmiSymbol::getSymbolName)
                .filter(Objects::nonNull)
                .map(SmiSymbolName::getReferences)
                .flatMap(Stream::of)
                .map(r -> r.multiResolve(false))
                .flatMap(Stream::of)
                .map(ResolveResult::getElement)
                .filter(Objects::nonNull)
                .filter(e -> identifiableElementClass.isAssignableFrom(e.getClass()))
                .map(identifiableElementClass::cast)
                .collect(Collectors.toList());
    }

    public static <T extends PsiElement> List<T> filterOutStandardMibs(List<T> elements) {
        List<VirtualFile> standardMibs = StandardSnmpv2Mibs.MIBS;
        List<T> standardElements = new ArrayList<>();
        List<T> customElements = new ArrayList<>();

        for (T element : elements) {
            VirtualFile virtualFile = element.getContainingFile().getVirtualFile();
            if (standardMibs.contains(virtualFile)) {
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
}
