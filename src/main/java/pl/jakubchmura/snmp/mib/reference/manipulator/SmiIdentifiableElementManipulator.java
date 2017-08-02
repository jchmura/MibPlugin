package pl.jakubchmura.snmp.mib.reference.manipulator;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.ElementManipulator;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.psi.SmiIdentifiableElement;

public class SmiIdentifiableElementManipulator implements ElementManipulator<SmiIdentifiableElement> {

    @Override
    public SmiIdentifiableElement handleContentChange(@NotNull SmiIdentifiableElement element, @NotNull TextRange range, String newContent) throws IncorrectOperationException {
        element.setName(newContent);
        return element;
    }

    @Override
    public SmiIdentifiableElement handleContentChange(@NotNull SmiIdentifiableElement element, String newContent) throws IncorrectOperationException {
        element.setName(newContent);
        return element;
    }

    @NotNull
    @Override
    public TextRange getRangeInElement(@NotNull SmiIdentifiableElement element) {
        return new TextRange(0, element.getIdentifierString().getTextLength());
    }
}
