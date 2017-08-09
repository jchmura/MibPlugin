package pl.jakubchmura.snmp.mib.psi;

import pl.jakubchmura.snmp.mib.MibIcons;

import javax.swing.*;

public enum NodeType {
    TABLE(MibIcons.TABLE),
    TABLE_ENTRY(MibIcons.TABLE_ROW),
    LEAF(MibIcons.LEAF),
    INDEX(MibIcons.KEY),
    NOTIFICATION(MibIcons.MAIL),
    NODE(MibIcons.FOLDER);

    private final Icon icon;

    NodeType(Icon icon) {
        this.icon = icon;
    }

    public Icon getIcon() {
        return icon;
    }
}
