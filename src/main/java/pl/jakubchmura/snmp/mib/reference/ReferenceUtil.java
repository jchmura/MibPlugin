package pl.jakubchmura.snmp.mib.reference;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.PsiFile;
import com.intellij.psi.ResolveResult;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.GlobalSearchScopesCore;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.StandardSnmpMibs;
import pl.jakubchmura.snmp.mib.psi.SmiModuleDefinition;
import pl.jakubchmura.snmp.mib.psi.SmiSymbol;
import pl.jakubchmura.snmp.mib.psi.SmiSymbolName;
import pl.jakubchmura.snmp.mib.psi.SmiSymbolsFromModule;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ReferenceUtil {

    private ReferenceUtil() {
    }

    public static GlobalSearchScope getScope(PsiElement psiElement) {
        Project project = psiElement.getProject();
        GlobalSearchScope standardMibs = StandardSnmpMibs.getScope(project);

        PsiFile containingFile = psiElement.getContainingFile();
        if (containingFile == null) {
            return standardMibs;
        }
        VirtualFile virtualFile = containingFile.getVirtualFile();
        if (virtualFile == null) {
            return standardMibs;
        }

        VirtualFile directory = virtualFile.getParent();
        if (directory != null) {
            GlobalSearchScope directoryScope = GlobalSearchScopesCore.directoryScope(project, directory, false);
            return directoryScope.uniteWith(standardMibs);
        } else {
            return standardMibs;
        }
    }

    public static ResolveResult[] mapToResult(Collection<? extends PsiElement> elements, PsiElement originalElement) {
        Collection<? extends PsiElement> filtered;
        Collection<? extends PsiElement> sameFile = referencesInSameFile(elements, originalElement);
        Collection<? extends PsiElement> imported = referencesImported(elements, originalElement);
        if (!sameFile.isEmpty()) {
            filtered = sameFile;
        } else if (!imported.isEmpty()) {
            filtered = imported;
        } else {
            filtered = StandardSnmpMibs.filterOutStandardMibs(elements);
        }
        return filtered.stream().map(PsiElementResolveResult::new).toArray(ResolveResult[]::new);
    }

    private static Collection<? extends PsiElement> referencesInSameFile(Collection<? extends PsiElement> elements, PsiElement originalElement) {
        Collection<PsiElement> collection = new ArrayList<>();
        PsiFile containingFile = originalElement.getContainingFile();
        for (PsiElement element : elements) {
            if (element.getContainingFile().equals(containingFile)) {
                collection.add(element);
            }
        }
        return collection;
    }

    private static Collection<? extends PsiElement> referencesImported(Collection<? extends PsiElement> elements, PsiElement originalElement) {
        List<SmiSymbolsFromModule> importedSymbols = getImportedSymbols(originalElement);
        Set<String> importedNames = importedSymbols.stream()
                .flatMap(smiSymbolsFromModule -> smiSymbolsFromModule.getSymbolList().stream())
                .map(SmiSymbol::getSymbolName)
                .filter(Objects::nonNull)
                .map(SmiSymbolName::getName)
                .collect(Collectors.toSet());

        return elements.stream().filter(element -> importedNames.contains(element.getText())).collect(Collectors
                .toList());
    }

    @NotNull
    public static List<SmiSymbolsFromModule> getImportedSymbols(PsiElement psiElement) {
        SmiModuleDefinition parentOfType = PsiTreeUtil.getParentOfType(psiElement, SmiModuleDefinition.class);
        return getImportedSymbols(Stream.of(parentOfType));
    }

    @NotNull
    public static List<SmiSymbolsFromModule> getImportedSymbols(Stream<SmiModuleDefinition> moduleDefinitions) {
        return moduleDefinitions
                .map(SmiModuleDefinition::getImportList)
                .filter(Objects::nonNull)
                .flatMap(list -> list.getSymbolsFromModuleList().stream())
                .collect(Collectors.toList());
    }
}
