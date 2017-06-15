package pl.jakubchmura.snmp.mib.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.psi.ResolveResult;
import com.intellij.psi.util.PsiTreeUtil;
import pl.jakubchmura.snmp.mib.MibIcons;
import pl.jakubchmura.snmp.mib.psi.*;
import pl.jakubchmura.snmp.mib.reference.CompositeReference;
import pl.jakubchmura.snmp.mib.reference.MibNodeReference;
import pl.jakubchmura.snmp.mib.reference.ModuleIdentifierReference;
import pl.jakubchmura.snmp.mib.reference.TextualConventionReference;

import javax.swing.*;
import java.util.stream.Stream;

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

    public static MibNodeReference getReference(SmiNameValueString nameValueString) {
        return new MibNodeReference(nameValueString);
    }

    public static MibNodeReference getReference(SmiDefinedValueName definedValueName) {
        return new MibNodeReference(definedValueName);
    }

    public static MibNodeReference getReference(SmiElementTypeName elementTypeName) {
        if (elementTypeName.shouldHaveReference()) {
            return new MibNodeReference(elementTypeName);
        }
        return null;
    }

    public static TextualConventionReference getReference(SmiDefinedTypeName definedTypeName) {
        return new TextualConventionReference(definedTypeName, definedTypeName.getContainingFile());
    }

    public static CompositeReference getReference(SmiSymbolName symbolName) {
        SmiSymbolsFromModule symbolsFromModule = (SmiSymbolsFromModule) PsiTreeUtil.findFirstParent(symbolName, element -> element instanceof SmiSymbolsFromModule);
        if (symbolsFromModule != null) {
            PsiReference reference = symbolsFromModule.getModuleIdentifier().getReference();
            if (reference != null) {
                PsiElement resolved = reference.resolve();
                if (resolved instanceof SmiModuleIdentifierDefinition) {
                    SmiModuleIdentifierDefinition moduleIdentifierDefinition = (SmiModuleIdentifierDefinition) resolved;
                    PsiFile containingFile = moduleIdentifierDefinition.getContainingFile();
                    MibNodeReference mibNodeReference = new MibNodeReference(symbolName, containingFile, false);
                    TextualConventionReference tcReference = new TextualConventionReference(symbolName, containingFile, false);
                    return new CompositeReference(mibNodeReference, tcReference);
                }
            }
        }
        return null;
    }

    public static CompositeReference[] getReferences(SmiSymbolName symbolName) {
        SmiSymbolsFromModule symbolsFromModule = (SmiSymbolsFromModule) PsiTreeUtil.findFirstParent(symbolName, element -> element instanceof SmiSymbolsFromModule);
        SmiExportList exportList = (SmiExportList) PsiTreeUtil.findFirstParent(symbolName, element -> element instanceof SmiExportList);
        if (symbolsFromModule != null) {
            return getImportedReferences(symbolName, symbolsFromModule);
        } else if (exportList != null) {
            return getExportedReferences(symbolName);
        }
        return new CompositeReference[0];
    }

    private static CompositeReference[] getImportedReferences(SmiSymbolName symbolName, SmiSymbolsFromModule symbolsFromModule) {
        ModuleIdentifierReference reference = symbolsFromModule.getModuleIdentifier().getReference();
        if (reference != null) {
            ResolveResult[] resolveResults = reference.multiResolve(false);
            return Stream.of(resolveResults)
                    .filter(ResolveResult::isValidResult)
                    .map(ResolveResult::getElement)
                    .filter(e -> e instanceof SmiModuleIdentifierDefinition)
                    .map(e -> {
                        PsiFile containingFile = e.getContainingFile();
                        MibNodeReference mibNodeReference = new MibNodeReference(symbolName, containingFile, false);
                        TextualConventionReference tcReference = new TextualConventionReference(symbolName, containingFile, false);
                        return new CompositeReference(mibNodeReference, tcReference);
                    }).toArray(CompositeReference[]::new);
        }
        return new CompositeReference[0];
    }

    private static CompositeReference[] getExportedReferences(SmiSymbolName symbolName) {
        PsiFile psiFile = symbolName.getContainingFile();
        MibNodeReference mibNodeReference = new MibNodeReference(symbolName, psiFile, false);
        TextualConventionReference tcReference = new TextualConventionReference(symbolName, psiFile, false);
        return new CompositeReference[] {new CompositeReference(mibNodeReference, tcReference)};
    }

    public static ModuleIdentifierReference getReference(SmiModuleIdentifier moduleIdentifier) {
        return new ModuleIdentifierReference(moduleIdentifier);
    }

    public static boolean shouldHaveReference(SmiElementTypeName elementTypeName) {
        PsiElement firstParent = PsiTreeUtil.findFirstParent(elementTypeName, psiElement -> psiElement instanceof SmiChoiceType);
        return firstParent == null;
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

}
