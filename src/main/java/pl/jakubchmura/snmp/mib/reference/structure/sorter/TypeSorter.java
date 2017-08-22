package pl.jakubchmura.snmp.mib.reference.structure.sorter;

import com.intellij.ide.util.treeView.smartTree.ActionPresentation;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.psi.SmiMibNode;
import pl.jakubchmura.snmp.mib.psi.SmiTypeName;
import pl.jakubchmura.snmp.mib.reference.structure.MibNodeStructureViewElement;

import java.util.Comparator;

public class TypeSorter implements Sorter {

    private static final String ID = "SMI_TYPE";

    private static final Comparator COMPARATOR = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            if (!(o1 instanceof MibNodeStructureViewElement) || !(o2 instanceof MibNodeStructureViewElement)) {
                return 0;
            }
            Object value1 = ((MibNodeStructureViewElement) o1).getValue();
            Object value2 = ((MibNodeStructureViewElement) o2).getValue();
            return getWeight(value1) - getWeight(value2);
        }

        private int getWeight(Object value) {
            if (value instanceof SmiMibNode) {
                return 20;
            }
            if (value instanceof SmiTypeName) {
                return 80;
            }
            return 50;
        }
    };


    @Override
    public Comparator getComparator() {
        return COMPARATOR;
    }

    @Override
    public boolean isVisible() {
        return false;
    }

    @NotNull
    @Override
    public ActionPresentation getPresentation() {
        throw new IllegalStateException();
    }

    @NotNull
    @Override
    public String getName() {
        return ID;
    }
}
