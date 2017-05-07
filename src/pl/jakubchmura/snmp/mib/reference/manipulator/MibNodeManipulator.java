package pl.jakubchmura.snmp.mib.reference.manipulator;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.AbstractElementManipulator;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.psi.SmiMibNode;

public class MibNodeManipulator extends AbstractElementManipulator<SmiMibNode> {

    @Override
    public SmiMibNode handleContentChange(@NotNull SmiMibNode element, @NotNull TextRange range, String newContent) throws IncorrectOperationException {
        element.setName(newContent);
        return element;
    }
}
