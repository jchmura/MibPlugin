package pl.jakubchmura.snmp.mib.highlight;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class SmiHighlightingColors {

    public static final TextAttributesKey COMMENT = createTextAttributesKey("COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey STRING = createTextAttributesKey("STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER = createTextAttributesKey("NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("SMI_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    public static final TextAttributesKey KEYWORD = createTextAttributesKey("SMI_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey BRACKETS = createTextAttributesKey("BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey BRACES = createTextAttributesKey("BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey PARENTHESES = createTextAttributesKey("PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES);

    public static final TextAttributesKey MIB_NODE = createTextAttributesKey("MIB_NODE", DefaultLanguageHighlighterColors.INSTANCE_FIELD);
    public static final TextAttributesKey BUILTIN_TYPE = createTextAttributesKey("BUILTIN_TYPE", DefaultLanguageHighlighterColors.STATIC_METHOD);
    public static final TextAttributesKey DEFINED_TYPE = createTextAttributesKey("DEFINED_TYPE", DefaultLanguageHighlighterColors.STATIC_FIELD);
    public static final TextAttributesKey MODULE_IDENTIFIER = createTextAttributesKey("MODULE_IDENTIFIER", DefaultLanguageHighlighterColors.CLASS_NAME);

}
