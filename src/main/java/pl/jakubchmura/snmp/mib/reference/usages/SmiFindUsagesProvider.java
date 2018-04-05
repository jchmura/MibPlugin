package pl.jakubchmura.snmp.mib.reference.usages;

import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.parser.SmiLexer;
import pl.jakubchmura.snmp.mib.psi.SmiIdentifiableElement;
import pl.jakubchmura.snmp.mib.psi.SmiMibNode;
import pl.jakubchmura.snmp.mib.psi.SmiTypeName;
import pl.jakubchmura.snmp.mib.psi.SmiTypes;

public class SmiFindUsagesProvider implements FindUsagesProvider {
    @Nullable
    @Override
    public WordsScanner getWordsScanner() {
        return new DefaultWordsScanner(new SmiLexer(),
                TokenSet.create(SmiTypes.IDENTIFIER_STRING),
                TokenSet.create(SmiTypes.COMMENT),
                TokenSet.create(SmiTypes.STRING_LITERAL, SmiTypes.NUMBER_LITERAL, SmiTypes.HEXADECIMAL_LITERAL, SmiTypes.BINARY_LITERAL));
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return psiElement instanceof SmiMibNode
                || psiElement instanceof SmiTypeName;
    }

    @Nullable
    @Override
    public String getHelpId(@NotNull PsiElement psiElement) {
        return null;
    }

    @NotNull
    @Override
    public String getType(@NotNull PsiElement element) {
        if (element instanceof SmiMibNode) {
            return "MIB node";
        } else if (element instanceof SmiTypeName) {
            return "Textual Convention";
        } else {
            return "";
        }
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement element) {
        if (element instanceof SmiIdentifiableElement) {
            SmiIdentifiableElement identifiableElement = (SmiIdentifiableElement) element;
            return identifiableElement.getIdentifierString().getText();
        } else {
            return "";
        }
    }

    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        return getDescriptiveName(element);
    }
}
