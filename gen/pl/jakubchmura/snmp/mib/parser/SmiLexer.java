package pl.jakubchmura.snmp.mib.parser;

import com.intellij.lexer.FlexAdapter;

public class SmiLexer extends FlexAdapter {
    public SmiLexer() {
        super(new _SmiLexer());
    }
}
