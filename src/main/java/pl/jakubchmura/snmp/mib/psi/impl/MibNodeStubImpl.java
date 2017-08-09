package pl.jakubchmura.snmp.mib.psi.impl;

import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import pl.jakubchmura.snmp.mib.parsing.SmiElementsTypes;
import pl.jakubchmura.snmp.mib.psi.MibNodeStub;
import pl.jakubchmura.snmp.mib.psi.NodeType;
import pl.jakubchmura.snmp.mib.util.oid.SnmpOid;

public class MibNodeStubImpl extends StubBase<SmiMibNodeMixin> implements MibNodeStub {

    private final String name;
    private final SnmpOid oid;
    private final NodeType nodeType;

    public MibNodeStubImpl(StubElement parent, String name, SnmpOid oid, NodeType nodeType) {
        super(parent, SmiElementsTypes.MIB_NODE);
        this.name = name;
        this.oid = oid;
        this.nodeType = nodeType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public SnmpOid getOid() {
        return oid;
    }

    @Override
    public NodeType getNodeType() {
        return nodeType;
    }
}
