package pl.jakubchmura.snmp.mib.reference.structure;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.MibFile;

public class MibFileStructureViewElement implements StructureViewTreeElement {

    private final MibFile mibFile;

    MibFileStructureViewElement(MibFile mibFile) {
        this.mibFile = mibFile;
    }

    @Override
    public Object getValue() {
        return mibFile;
    }

    @NotNull
    @Override
    public ItemPresentation getPresentation() {
        ItemPresentation presentation = mibFile.getPresentation();
        if (presentation != null) {
            return presentation;
        } else {
            throw new IllegalStateException("Presentation of MIB file " + mibFile + " is null");
        }
    }

    @NotNull
    @Override
    public TreeElement[] getChildren() {
        return mibFile.getModuleDefinitions().stream()
                .map(ModuleDefinitionStructureViewElement::new)
                .toArray(TreeElement[]::new);
    }

    @Override
    public void navigate(boolean requestFocus) {
        mibFile.navigate(requestFocus);
    }

    @Override
    public boolean canNavigate() {
        return mibFile.canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return mibFile.canNavigateToSource();
    }


}
