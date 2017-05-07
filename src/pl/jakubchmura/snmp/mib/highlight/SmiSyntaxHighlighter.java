package pl.jakubchmura.snmp.mib.highlight;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.SmiLexerAdapter;
import pl.jakubchmura.snmp.mib.psi.SmiTokenSet;
import pl.jakubchmura.snmp.mib.psi.SmiTypes;

import java.util.HashMap;
import java.util.Map;

public class SmiSyntaxHighlighter extends SyntaxHighlighterBase {

    private static final Map<IElementType, TextAttributesKey> highlightMap;

    static {
        highlightMap = new HashMap<>();

        highlightMap.put(SmiTypes.COMMENT, SmiHighlightingColors.COMMENT);
        highlightMap.put(SmiTypes.STRING_LITERAL, SmiHighlightingColors.STRING);
        highlightMap.put(SmiTypes.NUMBER_LITERAL, SmiHighlightingColors.NUMBER);
        highlightMap.put(SmiTypes.HEXADECIMAL_LITERAL, SmiHighlightingColors.NUMBER);
        highlightMap.put(SmiTypes.BINARY_LITERAL, SmiHighlightingColors.NUMBER);
        highlightMap.put(TokenType.BAD_CHARACTER, SmiHighlightingColors.BAD_CHARACTER);
    }


    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new SmiLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        TextAttributesKey key1 = highlightMap.get(tokenType);
        TextAttributesKey key2 = null;
        if (SmiTokenSet.KEYWORDS.contains(tokenType)) {
            key2 = SmiHighlightingColors.KEYWORD;
        } else if (SmiTokenSet.BUILTIN_TYPES.contains(tokenType)) {
            key2 = SmiHighlightingColors.BUILTIN_TYPE;
        }
        return pack(key1, key2);
    }
}
