package pl.jakubchmura.snmp.mib.folding;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilder;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.util.TextRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.psi.SmiModuleDefinition;
import pl.jakubchmura.snmp.mib.psi.SmiTypeName;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;

import java.util.LinkedList;
import java.util.List;

public class SmiFoldingBuilder implements FoldingBuilder {
    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(@NotNull ASTNode node, @NotNull Document document) {
        MibFile mibFile = node.getPsi(MibFile.class);

        List<SmiModuleDefinition> moduleDefinitions = mibFile.getModuleDefinitions();
        List<FoldingDescriptor> modules = getModules(moduleDefinitions);
        List<FoldingDescriptor> mibNodes = getMibNodes(moduleDefinitions);
        List<FoldingDescriptor> textualConventions = getTextualConventions(moduleDefinitions);

        List<FoldingDescriptor> foldingDescriptors = new LinkedList<>();
        foldingDescriptors.addAll(modules);
        foldingDescriptors.addAll(mibNodes);
        foldingDescriptors.addAll(textualConventions);

        return foldingDescriptors.toArray(new FoldingDescriptor[0]);
    }

    private List<FoldingDescriptor> getModules(List<SmiModuleDefinition> moduleDefinitions) {
        List<FoldingDescriptor> foldingDescriptors = new LinkedList<>();
        for (SmiModuleDefinition moduleDefinition : moduleDefinitions) {
            foldingDescriptors.add(new FoldingDescriptor(moduleDefinition.getNode(), moduleDefinition.getTextRange(),
                    null, moduleDefinition.getModuleIdentifierDefinition().getName()));
        }
        return foldingDescriptors;
    }

    private List<FoldingDescriptor> getMibNodes(List<SmiModuleDefinition> moduleDefinitions) {
        List<FoldingDescriptor> foldingDescriptors = new LinkedList<>();
        for (SmiModuleDefinition moduleDefinition : moduleDefinitions) {
            for (SmiMibNodeMixin mibNode : moduleDefinition.getMibNodes()) {
                ASTNode node = mibNode.getParentAssignment().getNode();
                foldingDescriptors.add(getFoldingDescriptor(node));
            }
        }
        return foldingDescriptors;
    }

    private List<FoldingDescriptor> getTextualConventions(List<SmiModuleDefinition> moduleDefinitions) {
        List<FoldingDescriptor> foldingDescriptors = new LinkedList<>();
        for (SmiModuleDefinition moduleDefinition : moduleDefinitions) {
            for (SmiTypeName typeName : moduleDefinition.getTextualConventions()) {
                ASTNode node = typeName.getParentAssignment().getNode();
                foldingDescriptors.add(getFoldingDescriptor(node));
            }
        }
        return foldingDescriptors;
    }

    private FoldingDescriptor getFoldingDescriptor(ASTNode node) {
        ASTNode firstChild = node.getFirstChildNode();
        ASTNode lastChild = node.getLastChildNode();
        TextRange textRange = new TextRange(firstChild.getTextRange().getStartOffset(), lastChild.getTextRange()
                .getEndOffset());
        return new FoldingDescriptor(node, textRange, null, firstChild.getText());
    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode node) {
        return null;
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }
}
