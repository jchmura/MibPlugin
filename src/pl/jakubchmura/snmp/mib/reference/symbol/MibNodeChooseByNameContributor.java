package pl.jakubchmura.snmp.mib.reference.symbol;

import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;

public class MibNodeChooseByNameContributor extends AbstractChooseByNameContributor {

    public MibNodeChooseByNameContributor() {
        super(SmiMibNodeMixin.class);
    }

}
