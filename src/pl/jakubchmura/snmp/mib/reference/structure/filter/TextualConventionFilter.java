package pl.jakubchmura.snmp.mib.reference.structure.filter;

import com.intellij.ide.util.treeView.smartTree.ActionPresentation;
import com.intellij.ide.util.treeView.smartTree.Filter;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.MibIcons;
import pl.jakubchmura.snmp.mib.reference.structure.TextualConventionNodeViewElement;

import javax.swing.*;

public class TextualConventionFilter implements Filter {

    private static final String ID = "SMI_TC_FILTER";
    @Override
    public boolean isVisible(TreeElement treeNode) {
        return !(treeNode instanceof TextualConventionNodeViewElement);
    }

    @Override
    public boolean isReverted() {
        return true;
    }

    @NotNull
    @Override
    public ActionPresentation getPresentation() {
        return new ActionPresentation() {
            @NotNull
            @Override
            public String getText() {
                return "Show Textual Conventions";
            }

            @Override
            public String getDescription() {
                return null;
            }

            @Override
            public Icon getIcon() {
                return MibIcons.FONT;
            }
        };
    }

    @NotNull
    @Override
    public String getName() {
        return ID;
    }
}
