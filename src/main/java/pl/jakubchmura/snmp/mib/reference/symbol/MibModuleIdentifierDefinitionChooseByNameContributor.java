package pl.jakubchmura.snmp.mib.reference.symbol;

import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.psi.SmiModuleDefinition;
import pl.jakubchmura.snmp.mib.psi.SmiModuleIdentifierDefinition;

import java.util.List;
import java.util.stream.Collectors;

public class MibModuleIdentifierDefinitionChooseByNameContributor extends AbstractChooseByNameContributor<SmiModuleIdentifierDefinition> {

    @Override
    protected List<SmiModuleIdentifierDefinition> getDeclaredElementsFromFile(MibFile mibFile) {
        return mibFile.getModuleDefinitions().stream()
                .map(SmiModuleDefinition::getModuleIdentifierDefinition)
                .collect(Collectors.toList());
    }
}
