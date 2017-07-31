package pl.jakubchmura.snmp.mib.reference.structure;

import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.Filter;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;
import pl.jakubchmura.snmp.mib.reference.structure.filter.LeafFilter;
import pl.jakubchmura.snmp.mib.reference.structure.filter.NotificationFilter;
import pl.jakubchmura.snmp.mib.reference.structure.filter.TextualConventionFilter;
import pl.jakubchmura.snmp.mib.reference.structure.sorter.SnmpOidSorter;
import pl.jakubchmura.snmp.mib.reference.structure.sorter.TypeSorter;

public class MibStructureViewModel extends StructureViewModelBase implements StructureViewModel.ElementInfoProvider {

    MibStructureViewModel(PsiFile psiFile) {
        super(psiFile, new MibStructureViewElement(psiFile));
    }

    @NotNull
    @Override
    public Sorter[] getSorters() {
        return new Sorter[]{new TypeSorter(), new SnmpOidSorter()};
    }

    @NotNull
    @Override
    public Filter[] getFilters() {
        return new Filter[]{new NotificationFilter(), new LeafFilter(), new TextualConventionFilter()};
    }

    @Override
    public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
        if (element instanceof SmiMibNodeMixin) {
            SmiMibNodeMixin mibNode = (SmiMibNodeMixin) element;
            return !mibNode.isLeaf();
        }
        return element instanceof MibFile;
    }

    @Override
    public boolean isAlwaysLeaf(StructureViewTreeElement element) {
        if (element instanceof SmiMibNodeMixin) {
            SmiMibNodeMixin mibNode = (SmiMibNodeMixin) element;
            return !mibNode.isLeaf();
        }
        return element instanceof MibFile;
    }
}
