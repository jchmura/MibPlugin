package pl.jakubchmura.snmp.mib.psi;

import com.intellij.psi.stubs.StubElement;

public interface ModuleIdentifierDefinitionStub extends StubElement<SmiModuleIdentifierDefinition> {

    String getName();

}
