package pl.jakubchmura.snmp.mib.psi.impl;

import com.intellij.extapi.psi.StubBasedPsiElementBase;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.StubBasedPsiElement;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.parsing.MibNodeStubElementType;
import pl.jakubchmura.snmp.mib.psi.*;
import pl.jakubchmura.snmp.mib.reference.MibNodeReference;
import pl.jakubchmura.snmp.mib.util.oid.SnmpOid;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

import static pl.jakubchmura.snmp.mib.psi.SmiTypes.IDENTIFIER_STRING;

public class SmiMibNodeMixin extends StubBasedPsiElementBase<MibNodeStub> implements SmiReferenceableElement, StubBasedPsiElement<MibNodeStub> {

    private static final Long[] INDEX_NOT_FOUND = new Long[]{-1L};

    private SmiMibNodeMixin parent;
    private Long[] index = INDEX_NOT_FOUND;

    public SmiMibNodeMixin(@NotNull ASTNode node) {
        super(node);
    }

    public SmiMibNodeMixin(@NotNull MibNodeStub stub, @NotNull IStubElementType nodeType) {
        super(stub, nodeType);
    }

    @NotNull
    @Override
    public PsiElement getIdentifierString() {
        return findNotNullChildByType(IDENTIFIER_STRING);
    }

    public String getName() {
        MibNodeStub stub = getStub();
        if (stub != null) {
            return stub.getName();
        }
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
        NodeType nodeType = getNodeType();
        return nodeType == NodeType.LEAF || nodeType == NodeType.INDEX;
    }

    public NodeType getNodeType() {
        MibNodeStub stub = getStub();
        if (stub != null) {
            return stub.getNodeType();
        }

        SmiValueAssignment valueAssignment = getParentAssignment();
        if (valueAssignment == null) {
            return NodeType.NODE;
        }

        SmiType assignment = valueAssignment.getType();
        if (assignment instanceof SmiSnmpNotificationTypeMacroType || assignment instanceof SmiSnmpTrapTypeMacroType) {
            return NodeType.NOTIFICATION;
        }

        if (assignment instanceof SmiSnmpObjectTypeMacroType) {
            SmiSnmpObjectTypeMacroType macro = (SmiSnmpObjectTypeMacroType) assignment;
            SmiType innerType = macro.getType();
            if (innerType instanceof SmiSequenceOfType) {
                return NodeType.TABLE;
            } else if (isSequence(innerType)) {
                return NodeType.TABLE_ENTRY;
            } else if (isIndex()) {
                return NodeType.INDEX;
            } else {
                return NodeType.LEAF;
            }
        }

        return NodeType.NODE;
    }

    private boolean isSequence(SmiType type) {
        if (type instanceof SmiBuiltinType) {
            return type instanceof SmiSequenceType;
        }
        if (type instanceof SmiDefinedType) {
            SmiDefinedType definedType = (SmiDefinedType) type;
            PsiReference reference = definedType.getDefinedTypeName().getReference();
            if (reference != null) {
                PsiElement resolved = reference.resolve();
                if (resolved != null) {
                    PsiElement parent = resolved.getParent();
                    if (parent instanceof SmiTypeAssignment) {
                        SmiTypeAssignment typeAssignment = (SmiTypeAssignment) parent;
                        return isSequence(typeAssignment.getType());
                    }
                }
            }
        }
        return false;
    }

    private boolean isIndex() {
        SmiMibNodeMixin parentMibNode = getParentMibNode();
        if (parentMibNode == null) {
            return false;
        }

        SmiValueAssignment parentAssignment = parentMibNode.getParentAssignment();
        if (parentAssignment == null) {
            return false;
        }

        SmiType assignment = parentAssignment.getType();
        if (assignment instanceof SmiSnmpObjectTypeMacroType) {
            SmiSnmpObjectTypeMacroType macro = (SmiSnmpObjectTypeMacroType) assignment;
            SmiSnmpIndexPart indexPart = macro.getSnmpIndexPart();
            if (indexPart != null) {
                List<SmiIndexValue> indexValueList = indexPart.getIndexValueList();
                for (SmiIndexValue indexValue : indexValueList) {
                    SmiValue value = indexValue.getValue();
                    if (value instanceof SmiDefinedValueName) {
                        PsiReference reference = value.getReference();
                        if (reference != null) {
                            PsiElement resolved = reference.resolve();
                            if (this.equals(resolved)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;

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
                return SmiMibNodeMixin.this.getLocationString();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return getNodeType().getIcon();
            }
        };
    }

    @NotNull
    protected String getLocationString() {
        return getContainingFile().getName();
    }

    @Nullable
    public SmiMibNodeMixin getParentMibNode() {
        if (parent == null) {
            SmiValueAssignment valueAssignment = getParentAssignment();
            if (valueAssignment == null) {
                return null;
//                throw new IllegalStateException("Parent of MIB node " + this + " is null");
            }

            SmiValue value = valueAssignment.getValue();
            if (value instanceof SmiBitOrObjectIdentifierValue) {
                SmiBitOrObjectIdentifierValue oidValue = (SmiBitOrObjectIdentifierValue) value;

                List<SmiNameAndNumber> nameAndNumberList = oidValue.getNameAndNumberList();
                if (!nameAndNumberList.isEmpty()) {
                    SmiNameAndNumber last = nameAndNumberList.get(nameAndNumberList.size() - 1);
                    parent = new SmiV1MibNodeMixin(last);
                    return parent;
                }

                List<SmiNameValueString> nameValueStringList = oidValue.getNameValueStringList();
                if (nameValueStringList.isEmpty()) {
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

    protected Long[] getIndex() {
        if (Arrays.equals(index, INDEX_NOT_FOUND)) {
            SmiValueAssignment valueAssignment = getParentAssignment();
            if (valueAssignment == null) {
                return INDEX_NOT_FOUND;
//                throw new IllegalStateException("Parent of MIB node " + this + " is null");
            }

            SmiValue value = valueAssignment.getValue();
            if (value instanceof SmiBitOrObjectIdentifierValue) {
                SmiBitOrObjectIdentifierValue oidValue = (SmiBitOrObjectIdentifierValue) value;
                List<SmiNameValueIndex> nameValueIndexList = oidValue.getNameValueIndexList();
                if (nameValueIndexList.size() == 0) {
                    return INDEX_NOT_FOUND;
//                    throw new IllegalStateException("No parent in OID assignment of MIB node " + this);
                }
                index = nameValueIndexList.stream()
                        .map(smiNameValueIndex -> smiNameValueIndex.getNumberLiteral().getText())
                        .map(Long::parseLong)
                        .toArray(Long[]::new);
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
        Long[] indices = getIndex();
        if (Arrays.equals(indices, INDEX_NOT_FOUND)) {
            return null;
        }
        return parentOid.createChild(indices);
    }

    private SmiValueAssignment getParentAssignment() {
        return (SmiValueAssignment) PsiTreeUtil.findFirstParent(this, psiElement -> psiElement instanceof SmiValueAssignment);
    }

    public String toString() {
        return "MibNode(" + getName() + ")";
    }
}
