package pl.jakubchmura.snmp.mib.annotator;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.psi.SmiIdentifiableElement;
import pl.jakubchmura.snmp.mib.psi.SmiReferenceResolver;
import pl.jakubchmura.snmp.mib.psi.SmiReferenceableElement;

import static pl.jakubchmura.snmp.mib.util.PsiSmiUtil.hasReferenceToReferenceableElement;

public class SmiUnresolvedReferenceAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (shouldHaveReference(element) && !hasReferenceToReferenceableElement(element, SmiReferenceableElement.class)) {
            holder.createErrorAnnotation(element.getTextRange(), "Unresolved MIB reference");
        }
    }

    private boolean shouldHaveReference(PsiElement element) {
        return isIdentifiableButNotReferenceable(element) && isResolverAgree(element);
    }

    private boolean isIdentifiableButNotReferenceable(PsiElement element) {
        return (element instanceof SmiIdentifiableElement) && !(element instanceof SmiReferenceableElement);
    }

    private boolean isResolverAgree(PsiElement element) {
        if (element instanceof SmiReferenceResolver) {
            SmiReferenceResolver resolver = (SmiReferenceResolver) element;
            return resolver.shouldHaveReference();
        }
        return true;
    }

}
