package pl.jakubchmura.snmp.mib.reference.structure;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.psi.SmiTypeName;
import pl.jakubchmura.snmp.mib.reference.structure.presentation.TypeNameTreePresentation;

public class TextualConventionStructureViewElement implements StructureViewTreeElement {
    private final SmiTypeName typeName;

    TextualConventionStructureViewElement(SmiTypeName typeName) {
        this.typeName = typeName;
    }

    @Override
    public Object getValue() {
        return typeName;
    }

    @NotNull
    @Override
    public ItemPresentation getPresentation() {
        return new TypeNameTreePresentation(typeName);
    }

    @NotNull
    @Override
    public TreeElement[] getChildren() {
        return new TreeElement[0];
    }

    @Override
    public void navigate(boolean requestFocus) {
        typeName.navigate(requestFocus);
    }

    @Override
    public boolean canNavigate() {
        return typeName.canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return typeName.canNavigateToSource();
    }
}
