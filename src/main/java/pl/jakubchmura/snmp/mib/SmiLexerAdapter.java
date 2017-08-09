package pl.jakubchmura.snmp.mib;

import com.intellij.lexer.FlexAdapter;
import pl.jakubchmura.snmp.mib.parser._SmiLexer;

public class SmiLexerAdapter extends FlexAdapter {
    public SmiLexerAdapter() {
        super(new _SmiLexer(null));
    }
}
