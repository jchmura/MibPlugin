package pl.jakubchmura.snmp.mib.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.util.oid.SnmpOid;

public class IsoMibNode extends SmiMibNodeImpl {

    public static final String ISO = "iso";
    public static final SnmpOid ISO_OID = new SnmpOid(new long[]{1});

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
    public PsiElement setName(@NotNull String name) {
        throw new UnsupportedOperationException("Can't change top-level MIB node");
    }

    @NotNull
    @Override
    public SnmpOid getOid() {
        return ISO_OID;
    }
}
