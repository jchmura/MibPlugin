package pl.jakubchmura.snmp.mib.util;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiPolyVariantReference;
import com.intellij.psi.PsiReference;
import com.intellij.psi.ResolveResult;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.psi.SmiIdentifiableElement;

public class PsiSmiUtil {

    public static boolean isReferenceToReferenceableElement(@Nullable PsiReference reference, Class<? extends SmiIdentifiableElement> elementClass) {
        if (reference instanceof PsiPolyVariantReference) {
            PsiPolyVariantReference elementReference = (PsiPolyVariantReference) reference;
            ResolveResult[] resolveResults = elementReference.multiResolve(false);
            for (ResolveResult resolveResult : resolveResults) {
                PsiElement resolvedElement = resolveResult.getElement();
                if (resolvedElement != null && elementClass.isAssignableFrom(resolvedElement.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

}
