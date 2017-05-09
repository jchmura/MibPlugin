package pl.jakubchmura.snmp.mib.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class IsoMibNode extends SmiMibNodeImpl {

    public static final String ISO = "iso";

    public IsoMibNode(ASTNode node) {
        super(node);
    }

    @NotNull
    @Override
    public PsiElement getIdentifierString() {
        return this;
    }

    @Override
    public String getName() {
        return ISO;
    }

    @Override
    public PsiElement setName(String name) {
        throw new UnsupportedOperationException("Can't change top-level MIB node");
    }
}
