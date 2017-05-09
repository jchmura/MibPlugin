package pl.jakubchmura.snmp.mib.util;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.ResolveResult;
import pl.jakubchmura.snmp.mib.psi.SmiIdentifiableElement;
import pl.jakubchmura.snmp.mib.reference.ReferenceableElementReference;

public class PsiSmiUtil {

    public static boolean hasReferenceToReferenceableElement(PsiElement element, Class<? extends SmiIdentifiableElement> elementClass) {
        PsiReference[] references = element.getReferences();
        for (PsiReference reference : references) {
            if (reference != null && reference instanceof ReferenceableElementReference<?>) {
                ReferenceableElementReference<?> elementReference = (ReferenceableElementReference<?>) reference;
                ResolveResult[] resolveResults = elementReference.multiResolve(false);
                for (ResolveResult resolveResult : resolveResults) {
                    PsiElement resolvedElement = resolveResult.getElement();
                    if (resolvedElement != null && elementClass.isAssignableFrom(resolvedElement.getClass())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
