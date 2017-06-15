package pl.jakubchmura.snmp.mib.reference.symbol;

import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.psi.SmiTypeName;

import java.util.List;

public class TypeNameChooseByNameContributor extends AbstractChooseByNameContributor<SmiTypeName> {

    @Override
    protected List<SmiTypeName> getDeclaredElementsFromFile(MibFile mibFile) {
        return mibFile.getTextualConventions();
    }
}
