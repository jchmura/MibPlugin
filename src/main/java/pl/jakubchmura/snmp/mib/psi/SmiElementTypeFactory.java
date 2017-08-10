package pl.jakubchmura.snmp.mib.psi;

import com.intellij.psi.tree.IElementType;
import pl.jakubchmura.snmp.mib.parsing.SmiElementsTypes;

public class SmiElementTypeFactory {

    static IElementType createType(String name) {
        switch (name) {
            case "MIB_NODE":
                return SmiElementsTypes.MIB_NODE;
            case "MODULE_IDENTIFIER_DEFINITION":
                return SmiElementsTypes.MODULE_IDENTIFIER_DEFINITION;
            case "TYPE_NAME":
                return SmiElementsTypes.TEXTUAL_CONVENTION;
            default:
                return new SmiElementType(name);
        }
    }

}
