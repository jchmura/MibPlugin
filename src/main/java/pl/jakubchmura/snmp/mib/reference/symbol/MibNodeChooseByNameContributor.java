package pl.jakubchmura.snmp.mib.reference.symbol;

import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;

import java.util.List;

public class MibNodeChooseByNameContributor extends AbstractChooseByNameContributor<SmiMibNodeMixin> {

    @Override
    protected List<SmiMibNodeMixin> getDeclaredElementsFromFile(MibFile mibFile) {
        return mibFile.getMibNodes();
    }
}
