package pl.jakubchmura.snmp.mib.parsing;

import com.intellij.psi.stubs.IStubElementType;

public interface SmiElementsTypes {

    IStubElementType MIB_NODE = new MibNodeStubElementType();

    IStubElementType MODULE_IDENTIFIER_DEFINITION = new ModuleIdentifierDefinitionStubElementType();

    IStubElementType TEXTUAL_CONVENTION = new TextualConventionStubElementType();

}
