package pl.jakubchmura.snmp.mib.psi.impl;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiWhiteSpace;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.psi.SmiNameAndNumber;
import pl.jakubchmura.snmp.mib.psi.SmiNameValueString;

public class SmiV1MibNodeMixin extends SmiMibNodeImpl {

    @NotNull
    private final SmiNameAndNumber smiNameAndNumber;

    SmiV1MibNodeMixin(@NotNull SmiNameAndNumber smiNameAndNumber) {
        super(smiNameAndNumber.getNode());
        this.smiNameAndNumber = smiNameAndNumber;
    }

    @Override
    protected long getIndex() {
        PsiElement numberLiteral = smiNameAndNumber.getNumberLiteral();
        if (numberLiteral == null) {
            throw new IllegalStateException("No number literal in SMIv1 mib node " + this);
        }
        String text = numberLiteral.getText();
        return Long.parseLong(text);
    }

    @Nullable
    @Override
    public SmiMibNodeMixin getParentMibNode() {
        PsiElement prevSibling = getPreviousSibling(this);
        if (prevSibling instanceof SmiNameAndNumber) {
            return new SmiV1MibNodeMixin((SmiNameAndNumber) prevSibling);
        } else if (prevSibling instanceof SmiNameValueString) {
            SmiNameValueString smiNameValueString = (SmiNameValueString) prevSibling;
            String name = smiNameValueString.getName();
            if (IsoMibNode.ISO.equals(name)) {
                return new IsoMibNode(smiNameValueString.getNode());
            }
        }
        return null;
    }

    private static PsiElement getPreviousSibling(PsiElement psiElement) {
        PsiElement prevSibling = psiElement.getPrevSibling();
        if (prevSibling instanceof PsiWhiteSpace) {
            return getPreviousSibling(prevSibling);
        } else {
            return prevSibling;
        }
    }
}
