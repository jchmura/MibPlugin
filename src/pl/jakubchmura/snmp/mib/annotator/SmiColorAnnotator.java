package pl.jakubchmura.snmp.mib.annotator;

import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.highlight.SmiHighlightingColors;
import pl.jakubchmura.snmp.mib.psi.SmiMibNode;
import pl.jakubchmura.snmp.mib.psi.SmiModuleIdentifier;
import pl.jakubchmura.snmp.mib.psi.SmiModuleIdentifierDefinition;
import pl.jakubchmura.snmp.mib.psi.SmiTypeName;
import pl.jakubchmura.snmp.mib.util.PsiSmiUtil;

public class SmiColorAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof SmiMibNode) {
            annotateWithColor(element, holder, SmiHighlightingColors.MIB_NODE);
        } else if (element instanceof SmiTypeName) {
            annotateWithColor(element, holder, SmiHighlightingColors.DEFINED_TYPE);
        } else if (PsiSmiUtil.hasReferenceToReferenceableElement(element, SmiMibNode.class)) {
            annotateWithColor(element, holder, SmiHighlightingColors.MIB_NODE);
        } else if (PsiSmiUtil.hasReferenceToReferenceableElement(element, SmiTypeName.class)) {
            annotateWithColor(element, holder, SmiHighlightingColors.DEFINED_TYPE);
        } else if (element instanceof SmiModuleIdentifier || element instanceof SmiModuleIdentifierDefinition) {
            annotateWithColor(element, holder, SmiHighlightingColors.MODULE_IDENTIFIER);
        }
    }

    public static void annotateWithColor(@NotNull PsiElement element, @NotNull AnnotationHolder holder, TextAttributesKey textAttributesKey) {
        Annotation annotation = holder.createInfoAnnotation(element.getTextRange(), null);
        annotation.setTextAttributes(textAttributesKey);
    }
}
