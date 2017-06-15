package pl.jakubchmura.snmp.mib.reference;

import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.psi.SmiIdentifiableElement;
import pl.jakubchmura.snmp.mib.psi.SmiModuleDefinition;
import pl.jakubchmura.snmp.mib.psi.SmiModuleIdentifierDefinition;

import java.util.List;
import java.util.stream.Collectors;

public class ModuleIdentifierReference extends ReferenceableElementReference<SmiModuleIdentifierDefinition> {

    public ModuleIdentifierReference(@NotNull SmiIdentifiableElement element) {
        super(element, SmiModuleIdentifierDefinition.class);
    }

    @Override
    protected List<SmiModuleIdentifierDefinition> getDeclaredElementsFromFile(MibFile mibFile) {
        return mibFile.getModuleDefinitions().stream()
                .map(SmiModuleDefinition::getModuleIdentifierDefinition)
                .collect(Collectors.toList());
    }
}
