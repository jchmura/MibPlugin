package pl.jakubchmura.snmp.mib;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.IStubFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.parser.SmiLexer;
import pl.jakubchmura.snmp.mib.parser.SmiParser;
import pl.jakubchmura.snmp.mib.psi.SmiTypes;

public class SmiParserDefinition implements ParserDefinition {
    private static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    private static final TokenSet COMMENTS = TokenSet.create(SmiTypes.COMMENT);

    private static final IFileElementType FILE = new IStubFileElementType("MIB FILE", SmiLanguage.INSTANCE);


    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new SmiLexer();
    }

    @Override
    public PsiParser createParser(Project project) {
        return new SmiParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return SmiTypes.Factory.createElement(node);
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new MibFile(viewProvider);
    }
}
