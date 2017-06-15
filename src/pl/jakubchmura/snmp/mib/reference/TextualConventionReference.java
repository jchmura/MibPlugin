package pl.jakubchmura.snmp.mib.reference;

import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.psi.SmiIdentifiableElement;
import pl.jakubchmura.snmp.mib.psi.SmiTypeName;

import java.util.List;

public class TextualConventionReference extends ReferenceableElementReference<SmiTypeName> {

    public TextualConventionReference(@NotNull SmiIdentifiableElement element) {
        super(element, SmiTypeName.class);
    }

    public TextualConventionReference(@NotNull SmiIdentifiableElement element, @Nullable PsiFile psiFile) {
        super(element, SmiTypeName.class, (MibFile) psiFile);
    }

    public TextualConventionReference(@NotNull SmiIdentifiableElement element, @Nullable PsiFile psiFile, boolean withImports) {
        super(element, SmiTypeName.class, (MibFile) psiFile, withImports);
    }

    @Override
    protected List<SmiTypeName> getDeclaredElementsFromFile(MibFile mibFile) {
        return mibFile.getTextualConventions();
    }
}
