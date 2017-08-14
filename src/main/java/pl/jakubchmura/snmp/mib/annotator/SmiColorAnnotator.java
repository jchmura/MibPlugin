package pl.jakubchmura.snmp.mib.annotator;

import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.highlight.SmiHighlightingColors;
import pl.jakubchmura.snmp.mib.psi.*;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;
import pl.jakubchmura.snmp.mib.util.PsiSmiUtil;

public class SmiColorAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof SmiMibNode) {
            annotateWithColor(element, holder, SmiHighlightingColors.MIB_NODE);
        } else if (element instanceof SmiTypeName) {
            annotateWithColor(element, holder, SmiHighlightingColors.DEFINED_TYPE);
        } else if (element instanceof SmiDefinedTypeName) {
            annotateWithColor(element, holder, SmiHighlightingColors.DEFINED_TYPE);
        } else if (element instanceof SmiElementTypeName) {
            annotateWithColor(element, holder, SmiHighlightingColors.MIB_NODE);
        } else if (element instanceof SmiNameValueString) {
            annotateWithColor(element, holder, SmiHighlightingColors.MIB_NODE);
        } else if (element instanceof SmiDefinedValueName) {
            SmiDefinedValueName definedValueName = (SmiDefinedValueName) element;
            if (definedValueName.shouldHaveReference()) {
                annotateWithColor(element, holder, SmiHighlightingColors.MIB_NODE);
            }
        } else if (element instanceof SmiSymbolName) {
            PsiReference reference = element.getReference();
            if (PsiSmiUtil.isReferenceToReferenceableElement(reference, SmiMibNodeMixin.class)) {
                annotateWithColor(element, holder, SmiHighlightingColors.MIB_NODE);
            } else if (PsiSmiUtil.isReferenceToReferenceableElement(reference, SmiTypeName.class)) {
                annotateWithColor(element, holder, SmiHighlightingColors.DEFINED_TYPE);
            }
        } else if (element instanceof SmiModuleIdentifier || element instanceof SmiModuleIdentifierDefinition) {
            annotateWithColor(element, holder, SmiHighlightingColors.MODULE_IDENTIFIER);
        } else if (element.getNode().getElementType().equals(SmiTypes.IDENTIFIER_STRING) && element.getParent() instanceof SmiNameAndNumber) {
            annotateWithColor(element, holder, SmiHighlightingColors.MIB_NODE);
        }
    }

    private static void annotateWithColor(@NotNull PsiElement element, @NotNull AnnotationHolder holder, TextAttributesKey textAttributesKey) {
        Annotation annotation = holder.createInfoAnnotation(element.getTextRange(), null);
        annotation.setTextAttributes(textAttributesKey);
    }
}
