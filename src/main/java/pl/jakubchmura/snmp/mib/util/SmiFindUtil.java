package pl.jakubchmura.snmp.mib.util;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.MibFileType;
import pl.jakubchmura.snmp.mib.StandardSnmpMibs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SmiFindUtil {

    public static List<MibFile> getMibFiles(@NotNull Project project, @Nullable GlobalSearchScope scope) {
        List<VirtualFile> files = new ArrayList<>(StandardSnmpMibs.MIBS);
        if (scope != null) {
            files.addAll(FileTypeIndex.getFiles(MibFileType.INSTANCE, scope));
        }
        return files.stream()
                .map(virtualFile -> PsiManager.getInstance(project).findFile(virtualFile))
                .filter(psiFile -> psiFile instanceof MibFile)
                .map(MibFile.class::cast)
                .collect(Collectors.toList());
    }

    public static <T extends PsiElement> List<T> filterOutStandardMibs(List<T> elements) {
        List<VirtualFile> standardMibs = StandardSnmpMibs.MIBS;
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
