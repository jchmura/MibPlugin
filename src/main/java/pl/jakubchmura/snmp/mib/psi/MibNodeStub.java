package pl.jakubchmura.snmp.mib.psi;

import com.intellij.psi.stubs.StubElement;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;
import pl.jakubchmura.snmp.mib.util.oid.SnmpOid;

public interface MibNodeStub extends StubElement<SmiMibNodeMixin> {

    String getName();

    SnmpOid getOid();

    NodeType getNodeType();

}
