package pl.jakubchmura.snmp.mib.psi.impl;

import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import pl.jakubchmura.snmp.mib.parsing.SmiElementsTypes;
import pl.jakubchmura.snmp.mib.psi.SmiTypeName;
import pl.jakubchmura.snmp.mib.psi.TextualConventionStub;

public class TextualConventionStubImpl extends StubBase<SmiTypeName> implements TextualConventionStub {

    private final String name;

    public TextualConventionStubImpl(StubElement parent, String name) {
        super(parent, SmiElementsTypes.TEXTUAL_CONVENTION);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
