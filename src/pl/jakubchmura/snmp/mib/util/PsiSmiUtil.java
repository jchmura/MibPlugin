package pl.jakubchmura.snmp.mib.util;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import pl.jakubchmura.snmp.mib.psi.SmiIdentifiableElement;
import pl.jakubchmura.snmp.mib.reference.ReferenceableElementReference;

public class PsiSmiUtil {

    public static boolean hasReferenceToReferenceableElement(PsiElement element, Class<? extends SmiIdentifiableElement> elementClass) {
        PsiReference reference = element.getReference();
        if (reference != null && reference instanceof ReferenceableElementReference<?>) {
            ReferenceableElementReference<?> elementReference = (ReferenceableElementReference<?>) reference;
            PsiElement resolve = elementReference.resolve();
            if (resolve != null) {
                return elementClass.isAssignableFrom(resolve.getClass());
            }
        }
        return false;
    }

}
