package pl.jakubchmura.snmp.mib.parsing;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.stubs.*;
import com.intellij.util.io.StringRef;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.SmiLanguage;
import pl.jakubchmura.snmp.mib.psi.SmiTypeName;
import pl.jakubchmura.snmp.mib.psi.TextualConventionIndex;
import pl.jakubchmura.snmp.mib.psi.TextualConventionStub;
import pl.jakubchmura.snmp.mib.psi.impl.SmiTypeNameImpl;
import pl.jakubchmura.snmp.mib.psi.impl.TextualConventionStubImpl;

import java.io.IOException;

public class TextualConventionStubElementType extends IStubElementType<TextualConventionStub, SmiTypeName> {

    private static final Logger LOG = Logger.getInstance(TextualConventionStubElementType.class);

    TextualConventionStubElementType() {
        super("MODULE_IDENTIFIER_DEFINITION", SmiLanguage.INSTANCE);
    }

    @Override
    public SmiTypeName createPsi(@NotNull TextualConventionStub stub) {
        return new SmiTypeNameImpl(stub, this);
    }

    @NotNull
    @Override
    public TextualConventionStub createStub(@NotNull SmiTypeName psi, StubElement parentStub) {
        return new TextualConventionStubImpl(parentStub, psi.getName());
    }

    @NotNull
    @Override
    public String getExternalId() {
        return "mib.textualConvention";
    }

    @Override
    public void serialize(@NotNull TextualConventionStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        if (stub.getName() == null) {
            LOG.warn("{serialize} Name is null!");
        }
        dataStream.writeName(stub.getName());
    }

    @NotNull
    @Override
    public TextualConventionStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        StringRef nameRef = dataStream.readName();
        String name = nameRef != null? nameRef.getString(): null;
        if (name == null) {
            LOG.warn("{deserialize} Name is null!");
        }
        return new TextualConventionStubImpl(parentStub, name);
    }

    @Override
    public void indexStub(@NotNull TextualConventionStub stub, @NotNull IndexSink sink) {
        String name = stub.getName();
        if (name != null) {
            sink.occurrence(TextualConventionIndex.KEY, name);
        } else {
            LOG.warn("{indexStub} Name is null!");
        }
    }
}
