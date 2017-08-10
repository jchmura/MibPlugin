package pl.jakubchmura.snmp.mib.psi;

import com.intellij.psi.stubs.StubElement;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;

public interface MibNodeStub extends StubElement<SmiMibNodeMixin> {

    String getName();

}
