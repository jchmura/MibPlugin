package pl.jakubchmura.snmp.mib.annotator;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.StandardSnmpMibs;
import pl.jakubchmura.snmp.mib.psi.*;
import pl.jakubchmura.snmp.mib.psi.impl.IsoMibNode;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;
import pl.jakubchmura.snmp.mib.reference.ReferenceUtil;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static pl.jakubchmura.snmp.mib.util.PsiSmiUtil.isReferenceToReferenceableElement;

public class SmiUnresolvedReferenceAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof PsiNamedElement && shouldHaveReference(element)) {
            PsiReference reference = element.getReference();
            if (reference != null) {
                if (!isReferenceToReferenceableElement(reference, SmiReferenceableElement.class)) {
                    holder.createErrorAnnotation(element.getTextRange(), "Unresolved reference");
                } else if (!hasReferenceInsideFile(element, reference) && shouldBeImported(element) && !isImported((PsiNamedElement) element)) {
                    if (hasReferenceToStandardMib(element, reference)) {
                        holder.createWarningAnnotation(element.getTextRange(), "Not imported reference to standard " +
                                "MIB");
                    } else {
                        holder.createErrorAnnotation(element.getTextRange(), "Not imported reference");
                    }
                }
            }
        }
    }

    private boolean shouldHaveReference(PsiElement element) {
        return isIdentifiableButNotReferenceable(element) && isResolverAgree(element);
    }

    private boolean isIdentifiableButNotReferenceable(PsiElement element) {
        return (element instanceof SmiIdentifiableElement) && !(element instanceof SmiReferenceableElement);
    }

    private boolean hasReferenceInsideFile(PsiElement element, PsiReference reference) {
        PsiFile file = element.getContainingFile();
        Project project = element.getProject();
        GlobalSearchScope fileScope = GlobalSearchScope.fileScope(file);
        PsiElement resolved = reference.resolve();
        return verifyReference(project, fileScope, resolved);
    }

    private boolean verifyReference(Project project, GlobalSearchScope scope, PsiElement resolved) {
        if (resolved instanceof SmiTypeName) {
            String name = ((SmiTypeName) resolved).getName();
            Collection<SmiTypeName> typeNames = TextualConventionIndex.getInstance().get(name, project, scope);
            return !typeNames.isEmpty();
        } else if (resolved instanceof SmiMibNodeMixin) {
            String name = ((SmiMibNodeMixin) resolved).getName();
            Collection<SmiMibNodeMixin> mibNodes = MibNodeNameIndex.getInstance().get(name, project, scope);
            return !mibNodes.isEmpty();
        }
        return true;
    }

    private boolean hasReferenceToStandardMib(PsiElement element, PsiReference reference) {
        Project project = element.getProject();
        GlobalSearchScope scope = StandardSnmpMibs.getScope(project);
        PsiElement resolved = reference.resolve();
        return verifyReference(project, scope, resolved);
    }

    private boolean shouldBeImported(PsiElement element) {
        return !(element instanceof SmiSymbolName) && !element.getText().equals(IsoMibNode.ISO);
    }

    private boolean isImported(PsiNamedElement element) {
        List<SmiSymbolsFromModule> importedSymbols = ReferenceUtil.getImportedSymbols(element);
        return importedSymbols.stream()
                .flatMap(smiSymbolsFromModule -> smiSymbolsFromModule.getSymbolList().stream())
                .filter(smiSymbol -> smiSymbol.getSymbolName() != null)
                .anyMatch(smiSymbol -> Objects.equals(smiSymbol.getSymbolName().getName(), element.getName()));
    }

    private boolean isResolverAgree(PsiElement element) {
        if (element instanceof SmiReferenceResolver) {
            SmiReferenceResolver resolver = (SmiReferenceResolver) element;
            return resolver.shouldHaveReference();
        }
        return true;
    }

}
