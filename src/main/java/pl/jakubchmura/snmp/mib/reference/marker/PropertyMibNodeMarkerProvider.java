package pl.jakubchmura.snmp.mib.reference.marker;

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.lang.properties.psi.impl.PropertyValueImpl;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.regex.Matcher;

public class PropertyMibNodeMarkerProvider extends LanguageSmiReferenceMarkerProvider {

    @Override
    protected void collectNavigationMarkers(@NotNull PsiElement element, Collection<? super RelatedItemLineMarkerInfo> result) {
        if (element instanceof PropertyValueImpl) {
            PropertyValueImpl value = (PropertyValueImpl) element;
            String text = value.getText();
            Matcher matcher = getMatcher(text);
            if (matcher.matches()) {
                RelatedItemLineMarkerInfo<PsiElement> lineMarkerInfo = collectSmiReferences(element, matcher.group(1));
                if (lineMarkerInfo != null) {
                    result.add(lineMarkerInfo);
                }
            }
        }
    }
}
