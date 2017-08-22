package pl.jakubchmura.snmp.mib.reference.structure.sorter;

import com.intellij.ide.util.treeView.smartTree.ActionPresentation;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;
import pl.jakubchmura.snmp.mib.reference.structure.MibNodeStructureViewElement;
import pl.jakubchmura.snmp.mib.util.oid.SnmpOid;

import java.util.Comparator;

public class SnmpOidSorter implements Sorter {

    private static final String ID = "SMI_SNMP_OID";

    private static final Comparator COMPARATOR = (o1, o2) -> {
        if (!(o1 instanceof MibNodeStructureViewElement) || !(o2 instanceof MibNodeStructureViewElement)) {
            return 0;
        }
        SmiMibNodeMixin value1 = ((MibNodeStructureViewElement) o1).getValue();
        SmiMibNodeMixin value2 = ((MibNodeStructureViewElement) o2).getValue();
        SnmpOid oid1 = value1.getOid();
        SnmpOid oid2 = value2.getOid();
        if (oid1 != null && oid2 != null) {
            return oid1.compareTo(oid2);
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
