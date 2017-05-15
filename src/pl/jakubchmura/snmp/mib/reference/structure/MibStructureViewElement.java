package pl.jakubchmura.snmp.mib.reference.structure;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.psi.SmiMibNode;
import pl.jakubchmura.snmp.mib.psi.SmiTypeName;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;
import pl.jakubchmura.snmp.mib.util.SmiFindUtil;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MibStructureViewElement implements StructureViewTreeElement {
    private final PsiElement element;

    MibStructureViewElement(PsiElement element) {
        this.element = element;
    }

    @Override
    public Object getValue() {
        return element;
    }

    @NotNull
    @Override
    public ItemPresentation getPresentation() {
        if (element instanceof NavigationItem) {
            return ((NavigationItem) element).getPresentation();
        }
        return null;
    }

    @NotNull
    @Override
    public TreeElement[] getChildren() {
        if (element instanceof MibFile) {
            MibFile mibFile = (MibFile) element;

            List<TreeElement> rootElements = mibFile.getTopLevelMibNodes().stream()
                    .map(MibStructureViewElement::new)
                    .collect(Collectors.toList());

            List<SmiTypeName> textualConventions = mibFile.getTextualConventions();
            if (textualConventions.size() > 0) {
                rootElements.add(new TextualConventionNodeViewElement(textualConventions));
            }

            return rootElements.toArray(new TreeElement[rootElements.size()]);
        }
        if (element instanceof SmiMibNode) {
            return SmiFindUtil.findElements(element.getContainingFile(), SmiMibNodeMixin.class)
                    .stream()
                    .filter(e -> Objects.equals(e.getParentMibNode(), element))
                    .map(MibStructureViewElement::new)
                    .toArray(TreeElement[]::new);
        }
        return new TreeElement[0];
    }

    @Override
    public void navigate(boolean requestFocus) {
        if (element instanceof NavigationItem) {
            ((NavigationItem) element).navigate(requestFocus);
        }
    }

    @Override
    public boolean canNavigate() {
        return element instanceof NavigationItem && ((NavigationItem) element).canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return element instanceof NavigationItem && ((NavigationItem) element).canNavigateToSource();
    }
}
