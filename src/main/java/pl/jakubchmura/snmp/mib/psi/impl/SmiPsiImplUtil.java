package pl.jakubchmura.snmp.mib.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.MibIcons;
import pl.jakubchmura.snmp.mib.psi.*;
import pl.jakubchmura.snmp.mib.reference.*;

import javax.swing.*;

public class SmiPsiImplUtil {

    @NotNull
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

    public static SmiReference getReference(SmiNameValueString nameValueString) {
        return new MibNodeReference(nameValueString);
    }

    public static SmiReference getReference(SmiDefinedValueName definedValueName) {
        return new MibNodeReference(definedValueName);
    }

    public static SmiReference getReference(SmiElementTypeName elementTypeName) {
        if (elementTypeName.shouldHaveReference()) {
            return new MibNodeReference(elementTypeName);
        }
        return null;
    }

    public static SmiReference getReference(SmiDefinedTypeName definedTypeName) {
        return new TextualConventionReference(definedTypeName);
    }

    public static CompositeReference getReference(SmiSymbolName symbolName) {
        PsiFile containingFile = null;
        SmiSymbolsFromModule symbolsFromModule = (SmiSymbolsFromModule) PsiTreeUtil.findFirstParent(symbolName, element -> element instanceof SmiSymbolsFromModule);
        if (symbolsFromModule != null) {
            PsiReference reference = symbolsFromModule.getModuleIdentifier().getReference();
            if (reference != null) {
                PsiElement resolved = reference.resolve();
                if (resolved instanceof SmiModuleIdentifierDefinition) {
                    SmiModuleIdentifierDefinition moduleIdentifierDefinition = (SmiModuleIdentifierDefinition) resolved;
                    containingFile = moduleIdentifierDefinition.getContainingFile();
                }
            }
        } else {
            PsiElement exportList = PsiTreeUtil.findFirstParent(symbolName, element -> element instanceof SmiExportList);
            if (exportList != null) {
                containingFile = symbolName.getContainingFile();
            }
        }

        if (containingFile != null) {
            SmiReference mibNodeReference = new MibNodeReference(symbolName, containingFile);
            SmiReference tcReference = new TextualConventionReference(symbolName, containingFile);
            return new CompositeReference(mibNodeReference, tcReference);
        }
        return null;
    }

    public static SmiReference getReference(SmiModuleIdentifier moduleIdentifier) {
        return new ModuleIdentifierReference(moduleIdentifier);
    }

    public static boolean shouldHaveReference(SmiElementTypeName elementTypeName) {
        PsiElement firstParent = PsiTreeUtil.findFirstParent(elementTypeName, psiElement -> psiElement instanceof SmiChoiceType);
        return firstParent == null;
    }

    public static boolean shouldHaveReference(SmiDefinedValueName definedValueName) {
        return !(definedValueName.getParent() instanceof SmiSnmpDefValPart);
    }

    public static ItemPresentation getPresentation(SmiTypeName typeName) {
        return new ItemPresentation() {
            @Override
            public String getPresentableText() {
                return typeName.getName();
            }

            @Override
            public String getLocationString() {
                return typeName.getContainingFile().getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return MibIcons.FONT;
            }
        };
    }

    public static ItemPresentation getPresentation(SmiModuleIdentifierDefinition moduleIdentifierDefinition) {
        return new ItemPresentation() {
            @Override
            public String getPresentableText() {
                return moduleIdentifierDefinition.getName();
            }

            @Override
            public String getLocationString() {
                return moduleIdentifierDefinition.getContainingFile().getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return MibIcons.FILE;
            }
        };
    }

}
