package pl.jakubchmura.snmp.mib.parsing;

import com.intellij.psi.stubs.*;
import com.intellij.util.io.StringRef;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.SmiLanguage;
import pl.jakubchmura.snmp.mib.psi.MibNodeNameIndex;
import pl.jakubchmura.snmp.mib.psi.MibNodeStub;
import pl.jakubchmura.snmp.mib.psi.NodeType;
import pl.jakubchmura.snmp.mib.psi.impl.MibNodeStubImpl;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;

import java.io.IOException;

public class MibNodeStubElementType extends IStubElementType<MibNodeStub, SmiMibNodeMixin> {

    MibNodeStubElementType() {
        super("MIB_NODE", SmiLanguage.INSTANCE);
    }

    @Override
    public SmiMibNodeMixin createPsi(@NotNull MibNodeStub stub) {
        return new SmiMibNodeMixin(stub, this);
    }

    @NotNull
    @Override
    public MibNodeStub createStub(@NotNull SmiMibNodeMixin psi, StubElement parentStub) {
        return new MibNodeStubImpl(parentStub, psi.getName(), psi.getNodeType());
    }

    @NotNull
    @Override
    public String getExternalId() {
        return "mib.mibnode";
    }

    @Override
    public void serialize(@NotNull MibNodeStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        String type = stub.getNodeType() != null? stub.getNodeType().name(): null;

        dataStream.writeName(stub.getName());
        dataStream.writeName(type);
    }

    @NotNull
    @Override
    public MibNodeStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        StringRef nameRef = dataStream.readName();
        StringRef typeRef = dataStream.readName();

        String name = nameRef != null? nameRef.getString(): null;
        NodeType type = typeRef != null? NodeType.valueOf(typeRef.getString()): null;

        return new MibNodeStubImpl(parentStub, name, type);
    }

    @Override
    public void indexStub(@NotNull MibNodeStub stub, @NotNull IndexSink sink) {
        sink.occurrence(MibNodeNameIndex.KEY, stub.getName());
    }


}
