package pl.jakubchmura.snmp.mib.reference.structure.filter;

import pl.jakubchmura.snmp.mib.MibIcons;
import pl.jakubchmura.snmp.mib.psi.NodeType;

import java.util.EnumSet;

public class LeafFilter extends MibNodeFilter {

    private static final String ID = "SMI_LEAF_FILTER";

    public LeafFilter() {
        super(EnumSet.of(NodeType.LEAF, NodeType.INDEX), "Show only leafs", MibIcons.LEAF, ID);
    }
}
