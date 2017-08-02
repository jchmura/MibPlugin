package pl.jakubchmura.snmp.mib;

import com.intellij.lexer.FlexAdapter;

public class SmiLexerAdapter extends FlexAdapter {
    public SmiLexerAdapter() {
        super(new _SmiLexer(null));
    }
}
