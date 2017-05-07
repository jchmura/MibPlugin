package pl.jakubchmura.snmp.mib.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.psi.util.PsiTreeUtil;
import pl.jakubchmura.snmp.mib.psi.*;
import pl.jakubchmura.snmp.mib.reference.MibNodeReference;
import pl.jakubchmura.snmp.mib.reference.ReferenceableElementReference;
import pl.jakubchmura.snmp.mib.reference.TypeNameReference;

public class SmiPsiImplUtil {

    public static String getName(SmiIdentifiableElement element) {
        return element.getIdentifierString().getText();
    }

    public static PsiElement setName(SmiIdentifiableElement element, String name) {
        PsiElement identifierString = element.getIdentifierString();
        ASTNode node = identifierString.getNode();

        PsiElement newElement = SmiElementFactory.createElement(element.getProject(), name);
        ASTNode newNode = newElement.getNode();

        element.getNode().replaceChild(node, newNode);

        return element;
    }

    public static PsiReference getReference(SmiNameValueString nameValueString) {
        return new MibNodeReference(nameValueString);
    }

    public static PsiReference getReference(SmiDefinedValueName definedValueName) {
        return new MibNodeReference(definedValueName);
    }

    public static PsiReference getReference(SmiElementTypeName elementTypeName) {
        if (elementTypeName.shouldHaveReference()) {
            return new MibNodeReference(elementTypeName);
        }
        return null;
    }

    public static PsiReference getReference(SmiDefinedTypeName definedTypeName) {
        return new TypeNameReference(definedTypeName);
    }

    public static PsiReference getReference(SmiSymbolName symbolName) {
        SmiSymbolsFromModule symbolsFromModule = (SmiSymbolsFromModule) PsiTreeUtil.findFirstParent(symbolName, element -> element instanceof SmiSymbolsFromModule);
        if (symbolsFromModule != null) {
            PsiReference reference = symbolsFromModule.getModuleIdentifier().getReference();
            if (reference != null) {
                PsiElement resolved = reference.resolve();
                if (resolved instanceof SmiModuleIdentifierDefinition) {
                    SmiModuleIdentifierDefinition moduleIdentifierDefinition = (SmiModuleIdentifierDefinition) resolved;
                    PsiFile containingFile = moduleIdentifierDefinition.getContainingFile();
                    return new ReferenceableElementReference<>(symbolName, SmiReferenceableElement.class, containingFile);
                }
            }
        }
        return null;
    }

    public static PsiReference getReference(SmiModuleIdentifier moduleIdentifier) {
        return new ReferenceableElementReference<>(moduleIdentifier, SmiModuleIdentifierDefinition.class);
    }

    public static boolean shouldHaveReference(SmiElementTypeName elementTypeName) {
        PsiElement firstParent = PsiTreeUtil.findFirstParent(elementTypeName, psiElement -> psiElement instanceof SmiChoiceType);
        return firstParent == null;
    }

}
