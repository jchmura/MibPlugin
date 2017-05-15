package pl.jakubchmura.snmp.mib.reference.manipulator;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.AbstractElementManipulator;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;

public class MibNodeManipulator extends AbstractElementManipulator<SmiMibNodeMixin> {

    @Override
    public SmiMibNodeMixin handleContentChange(@NotNull SmiMibNodeMixin element, @NotNull TextRange range, String newContent) throws IncorrectOperationException {
        element.setName(newContent);
        return element;
    }
}
