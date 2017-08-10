package pl.jakubchmura.snmp.mib.psi.impl;

import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import pl.jakubchmura.snmp.mib.parsing.SmiElementsTypes;
import pl.jakubchmura.snmp.mib.psi.ModuleIdentifierDefinitionStub;
import pl.jakubchmura.snmp.mib.psi.SmiModuleIdentifierDefinition;

public class ModuleIdentifierDefinitionStubImpl extends StubBase<SmiModuleIdentifierDefinition> implements ModuleIdentifierDefinitionStub {

    private final String name;

    public ModuleIdentifierDefinitionStubImpl(StubElement parent, String name) {
        super(parent, SmiElementsTypes.MODULE_IDENTIFIER_DEFINITION);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
