package pl.jakubchmura.snmp.mib.reference;

import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.psi.ModuleIdentifierDefinitionIndex;
import pl.jakubchmura.snmp.mib.psi.SmiIdentifiableElement;
import pl.jakubchmura.snmp.mib.psi.SmiModuleDefinition;

import java.util.stream.Stream;

public class ModuleIdentifierReference extends SmiReference {

    public ModuleIdentifierReference(@NotNull SmiIdentifiableElement element) {
        this(element, null);
    }

    private ModuleIdentifierReference(@NotNull SmiIdentifiableElement element, @Nullable PsiFile psiFile) {
        super(element, psiFile, ModuleIdentifierDefinitionIndex.getInstance());
    }

    @Override
    protected Stream<SmiIdentifiableElement> getElements(Stream<MibFile> mibFileStream) {
        return mibFileStream.flatMap(mibFile -> mibFile.getModuleDefinitions().stream())
                .map(SmiModuleDefinition::getModuleIdentifierDefinition);
    }
}
