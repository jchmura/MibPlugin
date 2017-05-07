package pl.jakubchmura.snmp.mib.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import org.jetbrains.annotations.NotNull;

public interface SmiIdentifiableElement extends PsiNamedElement {

    @NotNull
    PsiElement getIdentifierString();

}
