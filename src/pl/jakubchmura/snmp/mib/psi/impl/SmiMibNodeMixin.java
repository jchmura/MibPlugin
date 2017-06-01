package pl.jakubchmura.snmp.mib.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibIcons;
import pl.jakubchmura.snmp.mib.psi.*;
import pl.jakubchmura.snmp.mib.reference.MibNodeReference;
import pl.jakubchmura.snmp.mib.util.oid.SnmpOid;

import javax.swing.*;
import java.util.List;

public abstract class SmiMibNodeMixin extends ASTWrapperPsiElement implements SmiReferenceableElement {

    private SmiMibNodeMixin parent;
    private long index = -1;

    public SmiMibNodeMixin(@NotNull ASTNode node) {
        super(node);
    }

    public String getName() {
        return getIdentifierString().getText();
    }

    public PsiElement setName(@NotNull String name) {
        PsiElement identifierString = getIdentifierString();
        ASTNode node = identifierString.getNode();

        PsiElement newElement = SmiElementFactory.createElement(getProject(), name);
        ASTNode newNode = newElement.getNode();

        getNode().replaceChild(node, newNode);

        return this;
    }

    public boolean isLeaf() {
        SmiValueAssignment valueAssignment = (SmiValueAssignment) PsiTreeUtil.findFirstParent(this, psiElement -> psiElement instanceof SmiValueAssignment);
        if (valueAssignment == null) {
            return false;
        }

        SmiType type = valueAssignment.getType();
        return type instanceof SmiSnmpObjectTypeMacroType;
    }

    public boolean isNotification() {
        SmiValueAssignment valueAssignment = (SmiValueAssignment) PsiTreeUtil.findFirstParent(this, psiElement -> psiElement instanceof SmiValueAssignment);
        if (valueAssignment == null) {
            return false;
        }
        SmiType type = valueAssignment.getType();
        return type instanceof SmiSnmpNotificationTypeMacroType || type instanceof SmiSnmpTrapTypeMacroType;
    }

    @NotNull
    public ItemPresentation getPresentation() {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return getName();
            }

            @NotNull
            @Override
            public String getLocationString() {
                return getContainingFile().getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                if (isLeaf()) {
                    return MibIcons.LEAF;
                } else if (isNotification()) {
                    return MibIcons.MAIL;
                } else {
                    return MibIcons.FOLDER;
                }
            }
        };
    }

    @Nullable
    public SmiMibNodeMixin getParentMibNode() {
        if (parent == null) {
            SmiValueAssignment valueAssignment = (SmiValueAssignment) PsiTreeUtil.findFirstParent(this, psiElement -> psiElement instanceof SmiValueAssignment);
            if (valueAssignment == null) {
                return null;
//                throw new IllegalStateException("Parent of MIB node " + this + " is null");
            }

            SmiValue value = valueAssignment.getValue();
            if (value instanceof SmiBitOrObjectIdentifierValue) {
                SmiBitOrObjectIdentifierValue oidValue = (SmiBitOrObjectIdentifierValue) value;
                List<SmiNameValueString> nameValueStringList = oidValue.getNameValueStringList();
                if (nameValueStringList.size() == 0) {
                    return null;
//                    throw new IllegalStateException("No parent in OID assignment of MIB node " + this);
                }
                SmiNameValueString nameValueString = nameValueStringList.get(0);
                MibNodeReference reference = nameValueString.getReference();
                if (reference != null) {
                    PsiElement resolved = reference.resolve();
                    if (resolved == null) {
                        return null;
//                        throw new IllegalStateException("Parent of MIB node " + this + " resolved to null");
                    }
                    parent = (SmiMibNodeMixin) resolved;
                }
//                throw new IllegalStateException("Parent of MIB node " + this + " has a null reference");
            }
//            throw new IllegalStateException("MIB node " + this + " is not in a OID assignment");
        }
        return parent;
    }

    public long getIndex() {
        if (index == -1) {
            SmiValueAssignment valueAssignment = (SmiValueAssignment) PsiTreeUtil.findFirstParent(this, psiElement -> psiElement instanceof SmiValueAssignment);
            if (valueAssignment == null) {
                return -1;
//                throw new IllegalStateException("Parent of MIB node " + this + " is null");
            }

            SmiValue value = valueAssignment.getValue();
            if (value instanceof SmiBitOrObjectIdentifierValue) {
                SmiBitOrObjectIdentifierValue oidValue = (SmiBitOrObjectIdentifierValue) value;
                List<SmiNameValueIndex> nameValueIndexList = oidValue.getNameValueIndexList();
                if (nameValueIndexList.size() == 0) {
                    return -1;
//                    throw new IllegalStateException("No parent in OID assignment of MIB node " + this);
                }
                SmiNameValueIndex nameValueIndex = nameValueIndexList.get(0);
                String text = nameValueIndex.getNumberLiteral().getText();
                index = Long.parseLong(text);
            }
//            throw new IllegalStateException("MIB node " + this + " is not in a OID assignment");
        }
        return index;
    }

    @Nullable
    public SnmpOid getOid() {
        SmiMibNodeMixin parent = getParentMibNode();
        if (parent == null) {
            return null;
        }
        SnmpOid parentOid = parent.getOid();
        if (parentOid == null) {
            return null;
        }
        long index = getIndex();
        if (index == -1) {
            return null;
        }
        return parentOid.createChild(index);
    }

    public String toString() {
        return "MibNode(" + getName() + ")";
    }
}
