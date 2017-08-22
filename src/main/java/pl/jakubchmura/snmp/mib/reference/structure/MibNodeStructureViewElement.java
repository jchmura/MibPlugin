package pl.jakubchmura.snmp.mib.reference.structure;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.psi.SmiModuleDefinition;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;
import pl.jakubchmura.snmp.mib.reference.structure.presentation.MibNodeTreePresentation;

import java.util.Objects;

public class MibNodeStructureViewElement implements StructureViewTreeElement {
    private final SmiMibNodeMixin mibNode;

    MibNodeStructureViewElement(SmiMibNodeMixin mibNode) {
        this.mibNode = mibNode;
    }

    @Override
    public SmiMibNodeMixin getValue() {
        return mibNode;
    }

    @NotNull
    @Override
    public ItemPresentation getPresentation() {
        return new MibNodeTreePresentation(mibNode);
    }

    @NotNull
    @Override
    public TreeElement[] getChildren() {
        SmiModuleDefinition moduleDefinition = (SmiModuleDefinition) PsiTreeUtil.findFirstParent(mibNode, psiElement -> psiElement instanceof SmiModuleDefinition);
        if (moduleDefinition != null) {
            return moduleDefinition.getMibNodes()
                    .stream()
                    .filter(e -> Objects.equals(e.getParentMibNode(), mibNode))
                    .map(MibNodeStructureViewElement::new)
                    .toArray(TreeElement[]::new);
        } else {
            return new TreeElement[0];
        }
    }

    @Override
    public void navigate(boolean requestFocus) {
        mibNode.navigate(requestFocus);
    }

    @Override
    public boolean canNavigate() {
        return mibNode.canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return mibNode.canNavigateToSource();
    }
}
