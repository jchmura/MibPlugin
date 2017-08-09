package pl.jakubchmura.snmp.mib.psi;

import com.intellij.psi.tree.IElementType;
import pl.jakubchmura.snmp.mib.parsing.SmiElementsTypes;

public class SmiElementTypeFactory {

    static IElementType createType(String name) {
        if (name.equals("MIB_NODE")) {
            return SmiElementsTypes.MIB_NODE;
        }
        return new SmiElementType(name);
    }

}
