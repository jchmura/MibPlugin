package pl.jakubchmura.snmp.mib.reference.structure.sorter;

import com.intellij.ide.util.treeView.smartTree.ActionPresentation;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;
import pl.jakubchmura.snmp.mib.reference.structure.MibStructureViewElement;
import pl.jakubchmura.snmp.mib.util.oid.SnmpOid;

import java.util.Comparator;

public class SnmpOidSorter implements Sorter {

    private static final String ID = "SMI_SNMP_OID";

    private static final Comparator COMPARATOR = (o1, o2) -> {
        if (!(o1 instanceof MibStructureViewElement) || !(o2 instanceof MibStructureViewElement)) {
            return 0;
        }
        Object value1 = ((MibStructureViewElement) o1).getValue();
        Object value2 = ((MibStructureViewElement) o2).getValue();
        if (value1 instanceof SmiMibNodeMixin && value2 instanceof SmiMibNodeMixin) {
            SmiMibNodeMixin node1 = (SmiMibNodeMixin) value1;
            SmiMibNodeMixin node2 = (SmiMibNodeMixin) value2;
            SnmpOid oid1 = node1.getOid();
            SnmpOid oid2 = node2.getOid();
            if (oid1 != null && oid2 != null) {
                return oid1.compareTo(oid2);
            }

        }
        return 0;
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
