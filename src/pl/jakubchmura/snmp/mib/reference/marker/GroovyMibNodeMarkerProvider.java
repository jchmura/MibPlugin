package pl.jakubchmura.snmp.mib.reference.marker;

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.literals.GrLiteral;

import java.util.Collection;

public class GroovyMibNodeMarkerProvider extends LanguageSmiReferenceMarkerProvider {

    @Override
    protected void collectNavigationMarkers(@NotNull PsiElement element, Collection<? super RelatedItemLineMarkerInfo> result) {
        if (element instanceof GrLiteral) {
            GrLiteral literal = (GrLiteral) element;
            String value = literal.getValue() instanceof String? (String) literal.getValue(): null;
            if (value != null) {
                result.add(collectSmiReferences(element, value));
            }
        }
    }
}
