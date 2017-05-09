package pl.jakubchmura.snmp.mib.util;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiReference;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.MibFileType;
import pl.jakubchmura.snmp.mib.psi.SmiReferenceableElement;
import pl.jakubchmura.snmp.mib.psi.SmiSymbol;
import pl.jakubchmura.snmp.mib.psi.SmiSymbolName;
import pl.jakubchmura.snmp.mib.psi.SmiSymbolsFromModule;

import java.util.*;
import java.util.stream.Collectors;

public class SmiFindUtil {

    public static <T extends SmiReferenceableElement> List<T> findElements(GlobalSearchScope scope, Class<T> elementClass, String name) {
        List<T> identifiableElements = findElements(scope, elementClass);
        return filterMyName(identifiableElements, name);
    }

    public static <T extends SmiReferenceableElement> List<T> findElements(PsiFile file, Class<T> elementClass, String name) {
        List<T> identifiableElements = findElements(file, elementClass);
        return filterMyName(identifiableElements, name);
    }

    public static <T extends SmiReferenceableElement> List<T> findElements(GlobalSearchScope scope, Class<T> elementClass) {
        List<T> result = new ArrayList<>();
        Collection<VirtualFile> files = FileTypeIndex.getFiles(MibFileType.INSTANCE, scope);
        for (VirtualFile file : files) {
            result.addAll(findElements(scope.getProject(), file, elementClass));
        }
        return result;
    }

    public static <T extends SmiReferenceableElement> List<T> findElements(Project project, VirtualFile virtualFile, Class<T> elementClass) {
        PsiFile file = PsiManager.getInstance(project).findFile(virtualFile);
        if (file != null) {
            return findElements(file, elementClass);
        }
        return Collections.emptyList();
    }

    @NotNull
    public static <T extends PsiElement> List<T> findElements(PsiFile file, Class<T> elementClass) {
        return new ArrayList<>(PsiTreeUtil.collectElementsOfType(file, elementClass));
    }

    public static <T extends SmiReferenceableElement> List<T> findImportedElements(PsiFile file, Class<T> identifiableElementClass) {
        return findElements(file, SmiSymbolsFromModule.class)
                .stream()
                .flatMap(e -> e.getSymbolList().stream())
                .map(SmiSymbol::getSymbolName)
                .filter(Objects::nonNull)
                .map(SmiSymbolName::getReference)
                .filter(Objects::nonNull)
                .map(PsiReference::resolve)
                .filter(e -> identifiableElementClass.isAssignableFrom(e.getClass()))
                .map(identifiableElementClass::cast)
                .collect(Collectors.toList());
    }

    public static List<SmiReferenceableElement> findReferenceableElements(PsiFile file) {
        return findElements(file, SmiReferenceableElement.class);
    }

    public static <T extends SmiReferenceableElement> List<T> findImportedElements(PsiFile file, Class<T> identifiableElementClass, String name) {
        return filterMyName(findImportedElements(file, identifiableElementClass), name);
    }


    private static <T extends SmiReferenceableElement> List<T> filterMyName(List<T> identifiableElements, String name) {
        return identifiableElements.stream().filter(e -> name.equals(e.getName())).collect(Collectors.toList());
    }
}
