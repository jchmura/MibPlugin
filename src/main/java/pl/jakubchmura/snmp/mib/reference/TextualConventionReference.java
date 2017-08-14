package pl.jakubchmura.snmp.mib.reference;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.psi.SmiIdentifiableElement;
import pl.jakubchmura.snmp.mib.psi.TextualConventionIndex;

import java.util.stream.Stream;

public class TextualConventionReference extends SmiReference {

    public TextualConventionReference(@NotNull SmiIdentifiableElement element) {
        this(element, null);
    }

    public TextualConventionReference(@NotNull SmiIdentifiableElement element, @Nullable MibFile psiFile) {
        super(element, psiFile, TextualConventionIndex.getInstance());
    }

    @Override
    protected Stream<SmiIdentifiableElement> getElements(Stream<MibFile> mibFileStream) {
        return mibFileStream.flatMap(mibFile -> mibFile.getTextualConventions().stream());
    }
}
