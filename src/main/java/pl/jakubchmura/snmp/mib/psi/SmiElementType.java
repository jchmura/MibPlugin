package pl.jakubchmura.snmp.mib.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.SmiLanguage;

public class SmiElementType extends IElementType {
    public SmiElementType(@NotNull String debugName) {
        super(debugName, SmiLanguage.INSTANCE);
    }
}
