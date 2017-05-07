package pl.jakubchmura.snmp.mib.util;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.indexing.FileBasedIndex;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.MibFileType;
import pl.jakubchmura.snmp.mib.psi.SmiIdentifiableElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SmiFindUtil {

    public static <T extends SmiIdentifiableElement> List<T> findIdentifiableElements(Project project, Class<T> elementClass, String name) {
        List<T> identifiableElements = findElements(project, elementClass);
        return identifiableElements.stream().filter(e -> name.equals(e.getName())).collect(Collectors.toList());
    }

    public static <T extends SmiIdentifiableElement> List<T> findIdentifiableElements(PsiFile file, Class<T> elementClass, String name) {
        List<T> identifiableElements = findElements(file, elementClass);
        return identifiableElements.stream().filter(e -> name.equals(e.getName())).collect(Collectors.toList());
    }

    public static <T extends SmiIdentifiableElement> List<T> findElements(Project project, Class<T> elementClass) {
        List<T> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, MibFileType.INSTANCE,
                        GlobalSearchScope.projectScope(project));

        for (VirtualFile virtualFile : virtualFiles) {
            result.addAll(findElements(project, virtualFile, elementClass));
        }
        return result;
    }

    public static <T extends SmiIdentifiableElement> List<T> findElements(Project project, VirtualFile virtualFile, Class<T> elementClass) {
        PsiFile file = PsiManager.getInstance(project).findFile(virtualFile);
        if (file != null) {
            return findElements(file, elementClass);
        }
        return Collections.emptyList();
    }

    @NotNull
    public static <T extends SmiIdentifiableElement> List<T> findElements(PsiFile file, Class<T> elementClass) {
        return new ArrayList<>(PsiTreeUtil.collectElementsOfType(file, elementClass));
    }


}
