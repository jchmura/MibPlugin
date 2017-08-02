package pl.jakubchmura.snmp.mib.reference.structure;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibIcons;
import pl.jakubchmura.snmp.mib.psi.SmiTypeName;

import javax.swing.*;
import java.util.List;

public class TextualConventionNodeViewElement implements StructureViewTreeElement {

    private static final String TEXTUAL_CONVENTIONS = "Textual Conventions";
    private final List<SmiTypeName> textualConventions;


    public TextualConventionNodeViewElement(List<SmiTypeName> textualConventions) {
        this.textualConventions = textualConventions;
    }

    @Override
    public Object getValue() {
        return TEXTUAL_CONVENTIONS;
    }

    @NotNull
    @Override
    public ItemPresentation getPresentation() {
        return new ItemPresentation() {
            @Override
            public String getPresentableText() {
                return TEXTUAL_CONVENTIONS;
            }

            @Nullable
            @Override
            public String getLocationString() {
                return null;
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return MibIcons.FIND_TEXT;
            }
        };
    }

    @NotNull
    @Override
    public TreeElement[] getChildren() {
        return textualConventions.stream()
                .map(MibStructureViewElement::new)
                .toArray(TreeElement[]::new);
    }

    @Override
    public void navigate(boolean requestFocus) {

    }

    @Override
    public boolean canNavigate() {
        return false;
    }

    @Override
    public boolean canNavigateToSource() {
        return false;
    }
}
