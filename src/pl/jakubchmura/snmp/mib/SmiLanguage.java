package pl.jakubchmura.snmp.mib;

import com.intellij.lang.Language;

public class SmiLanguage extends Language {
    public static final SmiLanguage INSTANCE = new SmiLanguage();

    private SmiLanguage() {
        super("SMI");
    }
}
