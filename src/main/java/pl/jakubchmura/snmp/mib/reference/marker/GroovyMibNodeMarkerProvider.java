package pl.jakubchmura.snmp.mib.reference.marker;

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.literals.GrLiteral;

import java.util.Collection;
import java.util.regex.Matcher;

public class GroovyMibNodeMarkerProvider extends LanguageSmiReferenceMarkerProvider {

    @Override
    protected void collectNavigationMarkers(@NotNull PsiElement element, Collection<? super RelatedItemLineMarkerInfo> result) {
        if (element instanceof GrLiteral) {
            GrLiteral literal = (GrLiteral) element;
            String value = literal.getValue() instanceof String? (String) literal.getValue(): null;
            Matcher matcher = getMatcher(value);
            if (value != null && matcher.matches()) {
                RelatedItemLineMarkerInfo<PsiElement> lineMarkerInfo = collectSmiReferences(element, matcher.group(1));
                if (lineMarkerInfo != null) {
                    result.add(lineMarkerInfo);
                }
            }
        }
    }
}
