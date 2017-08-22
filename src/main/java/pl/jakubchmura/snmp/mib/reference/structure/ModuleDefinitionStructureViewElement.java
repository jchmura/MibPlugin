package pl.jakubchmura.snmp.mib.reference.structure;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.NavigationItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.psi.SmiModuleDefinition;
import pl.jakubchmura.snmp.mib.psi.SmiTypeName;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;
import pl.jakubchmura.snmp.mib.util.oid.SnmpOid;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModuleDefinitionStructureViewElement implements StructureViewTreeElement {

    private final SmiModuleDefinition moduleDefinition;

    ModuleDefinitionStructureViewElement(SmiModuleDefinition moduleDefinition) {
        this.moduleDefinition = moduleDefinition;
    }

    @Override
    public Object getValue() {
        return moduleDefinition;
    }

    @NotNull
    @Override
    public ItemPresentation getPresentation() {
        return new ItemPresentation() {
            @Override
            public String getPresentableText() {
                return moduleDefinition.getModuleIdentifierDefinition().getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                return null;
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return null;
            }
        };
    }

    @NotNull
    @Override
    public TreeElement[] getChildren() {
        List<TreeElement> rootElements = getTopLevelMibNodes().stream()
                .map(MibNodeStructureViewElement::new)
                .collect(Collectors.toList());

        List<SmiTypeName> textualConventions = moduleDefinition.getTextualConventions();
        if (textualConventions.size() > 0) {
            rootElements.add(new TextualConventionNodeViewElement(textualConventions));
        }

        return rootElements.toArray(new TreeElement[rootElements.size()]);
    }

    @Override
    public void navigate(boolean requestFocus) {
        if (moduleDefinition instanceof NavigationItem) {
            ((NavigationItem) moduleDefinition).navigate(requestFocus);
        }
    }

    @Override
    public boolean canNavigate() {
        return moduleDefinition instanceof NavigationItem && ((NavigationItem) moduleDefinition).canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return moduleDefinition instanceof NavigationItem && ((NavigationItem) moduleDefinition).canNavigateToSource();
    }

    private List<SmiMibNodeMixin> getTopLevelMibNodes() {
        int minDepth = Integer.MAX_VALUE;
        List<SmiMibNodeMixin> topLevelMibNodes = new ArrayList<>();
        List<SmiMibNodeMixin> mibNodes = moduleDefinition.getMibNodes();
        for (SmiMibNodeMixin mibNode : mibNodes) {
            SnmpOid oid = mibNode.getOid();
            if (oid == null) {
                continue;
            }
            int depth = oid.getDepth();
            if (depth < minDepth) {
                topLevelMibNodes.clear();
                topLevelMibNodes.add(mibNode);
                minDepth = depth;
            } else if (depth == minDepth) {
                topLevelMibNodes.add(mibNode);
            }
        }
        return topLevelMibNodes;
    }

}
