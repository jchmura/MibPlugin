package pl.jakubchmura.snmp.mib.highlight;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.psi.SmiTypes;

public class SmiBraceMatcher implements PairedBraceMatcher {

    private static final BracePair[] PAIRS = {
            new BracePair(SmiTypes.LEFT_BRACE, SmiTypes.RIGHT_BRACE, false),
            new BracePair(SmiTypes.LEFT_BRACKET, SmiTypes.RIGHT_BRACKET, false),
            new BracePair(SmiTypes.LEFT_PAREN, SmiTypes.RIGHT_PAREN, false)
    };

    @NotNull
    @Override
    public BracePair[] getPairs() {
        return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}
