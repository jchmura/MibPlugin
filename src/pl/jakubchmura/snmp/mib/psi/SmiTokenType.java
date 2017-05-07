package pl.jakubchmura.snmp.mib.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.SmiLanguage;

public class SmiTokenType extends IElementType {

    public SmiTokenType(@NotNull String debugName) {
        super(debugName, SmiLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "SmiTokenType." + super.toString();
    }
}
