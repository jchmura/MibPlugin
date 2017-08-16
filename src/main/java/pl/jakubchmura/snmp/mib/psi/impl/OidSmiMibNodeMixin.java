package pl.jakubchmura.snmp.mib.psi.impl;

import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.util.oid.SnmpOid;

public class OidSmiMibNodeMixin extends SmiMibNodeImpl {

    public OidSmiMibNodeMixin(SmiMibNodeMixin mibNodeMixin) {
        super(mibNodeMixin.getNode());
    }

    @NotNull
    @Override
    public String getName() {
        SnmpOid oid = super.getOid();
        if (oid != null) {
            return oid.toString();
        } else {
            return super.getName();
        }
    }

    @NotNull
    @Override
    protected String getLocationString() {
        return super.getName();
    }
}
