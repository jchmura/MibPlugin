package pl.jakubchmura.snmp.mib.reference.structure.filter;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.ActionPresentation;
import com.intellij.ide.util.treeView.smartTree.Filter;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.psi.NodeType;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;
import pl.jakubchmura.snmp.mib.reference.structure.MibFileStructureViewElement;
import pl.jakubchmura.snmp.mib.reference.structure.MibNodeStructureViewElement;
import pl.jakubchmura.snmp.mib.reference.structure.ModuleDefinitionStructureViewElement;

import javax.swing.*;
import java.util.Arrays;
import java.util.EnumSet;

public class MibNodeFilter implements Filter {

    private static final EnumSet<NodeType> NODE_TYPES = EnumSet.of(NodeType.NODE, NodeType.TABLE, NodeType.TABLE_ENTRY);

    private final EnumSet<NodeType> nodeTypes;
    private final String text;
    private final Icon icon;
    private final String name;

    MibNodeFilter(EnumSet<NodeType> nodeTypes, String text, Icon icon, String name) {
        this.nodeTypes = nodeTypes;
        this.text = text;
        this.icon = icon;
        this.name = name;
    }

    @Override
    public boolean isVisible(TreeElement treeNode) {
        if (treeNode instanceof MibFileStructureViewElement || treeNode instanceof ModuleDefinitionStructureViewElement) {
            return Arrays.stream(treeNode.getChildren()).anyMatch(this::isVisible);
        }
        if (treeNode instanceof MibNodeStructureViewElement) {
            MibNodeStructureViewElement viewElement = (MibNodeStructureViewElement) treeNode;
            SmiMibNodeMixin mibNodeMixin = viewElement.getValue();
            NodeType nodeType = mibNodeMixin.getNodeType();
            if (NODE_TYPES.contains(nodeType)) {
                return Arrays.stream(viewElement.getChildren()).anyMatch(this::isVisible);
            }
            return nodeTypes.contains(nodeType);
        }
        return false;
    }

    @Override
    public boolean isReverted() {
        return false;
    }

    @NotNull
    @Override
    public ActionPresentation getPresentation() {
        return new ActionPresentation() {
            @NotNull
            @Override
            public String getText() {
                return text;
            }

            @Override
            public String getDescription() {
                return null;
            }

            @Override
            public Icon getIcon() {
                return icon;
            }
        };
    }

    @NotNull
    @Override
    public String getName() {
        return name;
    }
}
