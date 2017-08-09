package pl.jakubchmura.snmp.mib.reference.structure.filter;

import pl.jakubchmura.snmp.mib.MibIcons;
import pl.jakubchmura.snmp.mib.psi.NodeType;

import java.util.EnumSet;

public class NotificationFilter extends MibNodeFilter {

    private static final String ID = "SMI_NOTIFICATION_FILTER";

    public NotificationFilter() {
        super(EnumSet.of(NodeType.NOTIFICATION), "Show only notifications", MibIcons.MAIL, ID);
    }
}
