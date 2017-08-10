package pl.jakubchmura.snmp.mib.parsing;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.stubs.*;
import com.intellij.util.io.StringRef;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.SmiLanguage;
import pl.jakubchmura.snmp.mib.psi.ModuleIdentifierDefinitionIndex;
import pl.jakubchmura.snmp.mib.psi.ModuleIdentifierDefinitionStub;
import pl.jakubchmura.snmp.mib.psi.SmiModuleIdentifierDefinition;
import pl.jakubchmura.snmp.mib.psi.impl.ModuleIdentifierDefinitionStubImpl;
import pl.jakubchmura.snmp.mib.psi.impl.SmiModuleIdentifierDefinitionImpl;

import java.io.IOException;

public class ModuleIdentifierDefinitionStubElementType extends IStubElementType<ModuleIdentifierDefinitionStub, SmiModuleIdentifierDefinition> {

    private static final Logger LOG = Logger.getInstance(ModuleIdentifierDefinitionStubElementType.class);

    ModuleIdentifierDefinitionStubElementType() {
        super("MODULE_IDENTIFIER_DEFINITION", SmiLanguage.INSTANCE);
    }

    @Override
    public SmiModuleIdentifierDefinition createPsi(@NotNull ModuleIdentifierDefinitionStub stub) {
        return new SmiModuleIdentifierDefinitionImpl(stub, this);
    }

    @NotNull
    @Override
    public ModuleIdentifierDefinitionStub createStub(@NotNull SmiModuleIdentifierDefinition psi, StubElement parentStub) {
        return new ModuleIdentifierDefinitionStubImpl(parentStub, psi.getName());
    }

    @NotNull
    @Override
    public String getExternalId() {
        return "mib.moduleIdentifierDefinition";
    }

    @Override
    public void serialize(@NotNull ModuleIdentifierDefinitionStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        if (stub.getName() == null) {
            LOG.warn("{serialize} Name is null!");
        }
        dataStream.writeName(stub.getName());
    }

    @NotNull
    @Override
    public ModuleIdentifierDefinitionStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        StringRef nameRef = dataStream.readName();
        String name = nameRef != null? nameRef.getString(): null;
        if (name == null) {
            LOG.warn("{deserialize} Name is null!");
        }
        return new ModuleIdentifierDefinitionStubImpl(parentStub, name);
    }

    @Override
    public void indexStub(@NotNull ModuleIdentifierDefinitionStub stub, @NotNull IndexSink sink) {
        String name = stub.getName();
        if (name != null) {
            sink.occurrence(ModuleIdentifierDefinitionIndex.KEY, name);
        } else {
            LOG.warn("{indexStub} Name is null!");
        }
    }
}
