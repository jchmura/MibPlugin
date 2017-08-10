package pl.jakubchmura.snmp.mib.psi.impl;

import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import pl.jakubchmura.snmp.mib.parsing.SmiElementsTypes;
import pl.jakubchmura.snmp.mib.psi.MibNodeStub;

public class MibNodeStubImpl extends StubBase<SmiMibNodeMixin> implements MibNodeStub {

    private final String name;

    public MibNodeStubImpl(StubElement parent, String name) {
        super(parent, SmiElementsTypes.MIB_NODE);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
