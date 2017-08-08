package pl.jakubchmura.snmp.mib.doc;

import com.intellij.lang.ASTNode;
import com.intellij.lang.documentation.AbstractDocumentationProvider;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.PsiElement;
import com.intellij.psi.TokenType;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;
import pl.jakubchmura.snmp.mib.util.oid.SnmpOid;

public class SmiDocumentationProvider extends AbstractDocumentationProvider {

    private static final Logger LOG = Logger.getInstance(SmiDocumentationProvider.class);

    @Override
    public String generateDoc(PsiElement element, @Nullable PsiElement originalElement) {
        if (element instanceof SmiMibNodeMixin) {
            try {
                SmiMibNodeMixin mibNode = (SmiMibNodeMixin) element;
                ASTNode node = mibNode.getNode();
                String type = getNextSibling(node).getFirstChildNode().getText();
                SnmpOid oid = mibNode.getOid();
                return formatMibNode(type, mibNode.getName(), oid);
            } catch (RuntimeException e) {
                LOG.warn(e);
            }
        }
        return null;
    }

    private static String formatMibNode(String type, String name, SnmpOid oid) {
        StringBuilder builder = new StringBuilder();
        builder.append(type).append(" <b>").append(name).append("</b>");
        if (oid != null) {
            builder.append("\n<br>").append(oid.toString());
        }
        return builder.toString();
    }

    private static ASTNode getNextSibling(ASTNode node) {
        ASTNode next = node.getTreeNext();
        if (TokenType.WHITE_SPACE.equals(next.getElementType())) {
            return getNextSibling(next);
        } else {
            return next;
        }
    }
}
