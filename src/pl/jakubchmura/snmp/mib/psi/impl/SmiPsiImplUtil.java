package pl.jakubchmura.snmp.mib.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.psi.ResolveResult;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibIcons;
import pl.jakubchmura.snmp.mib.psi.*;
import pl.jakubchmura.snmp.mib.reference.MibNodeReference;
import pl.jakubchmura.snmp.mib.reference.ReferenceableElementReference;

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

    public static ReferenceableElementReference<SmiTypeName> getReference(SmiDefinedTypeName definedTypeName) {
        return new ReferenceableElementReference<>(definedTypeName, SmiTypeName.class, definedTypeName.getContainingFile());
    }

    public static ReferenceableElementReference<SmiReferenceableElement> getReference(SmiSymbolName symbolName) {
        SmiSymbolsFromModule symbolsFromModule = (SmiSymbolsFromModule) PsiTreeUtil.findFirstParent(symbolName, element -> element instanceof SmiSymbolsFromModule);
        if (symbolsFromModule != null) {
            PsiReference reference = symbolsFromModule.getModuleIdentifier().getReference();
            if (reference != null) {
                PsiElement resolved = reference.resolve();
                if (resolved instanceof SmiModuleIdentifierDefinition) {
                    SmiModuleIdentifierDefinition moduleIdentifierDefinition = (SmiModuleIdentifierDefinition) resolved;
                    PsiFile containingFile = moduleIdentifierDefinition.getContainingFile();
                    return new ReferenceableElementReference<>(symbolName, SmiReferenceableElement.class, containingFile, false);
                }
            }
        }
        return null;
    }

    public static ReferenceableElementReference[] getReferences(SmiSymbolName symbolName) {
        SmiSymbolsFromModule symbolsFromModule = (SmiSymbolsFromModule) PsiTreeUtil.findFirstParent(symbolName, element -> element instanceof SmiSymbolsFromModule);
        SmiExportList exportList = (SmiExportList) PsiTreeUtil.findFirstParent(symbolName, element -> element instanceof SmiExportList);
        if (symbolsFromModule != null) {
            return getImportedReferences(symbolName, symbolsFromModule);
        } else if (exportList != null) {
            return getExportedReferences(symbolName);
        }
        return new ReferenceableElementReference[0];
    }

    private static ReferenceableElementReference[] getImportedReferences(SmiSymbolName symbolName, SmiSymbolsFromModule symbolsFromModule) {
        ReferenceableElementReference<SmiModuleIdentifierDefinition> reference = symbolsFromModule.getModuleIdentifier().getReference();
        if (reference != null) {
            ResolveResult[] resolveResults = reference.multiResolve(false);
            return Stream.of(resolveResults)
                    .filter(ResolveResult::isValidResult)
                    .map(ResolveResult::getElement)
                    .filter(e -> e instanceof SmiModuleIdentifierDefinition)
                    .map(e -> {
                        PsiFile containingFile = e.getContainingFile();
                        return new ReferenceableElementReference<>(symbolName, SmiReferenceableElement.class, containingFile, false);
                    }).toArray(ReferenceableElementReference[]::new);
        }
        return new ReferenceableElementReference[0];
    }

    private static ReferenceableElementReference[] getExportedReferences(SmiSymbolName symbolName) {
        return new ReferenceableElementReference[] {new ReferenceableElementReference<>(symbolName, SmiReferenceableElement.class, symbolName.getContainingFile(), false)};
    }

    public static ReferenceableElementReference<SmiModuleIdentifierDefinition> getReference(SmiModuleIdentifier moduleIdentifier) {
        return new ReferenceableElementReference<>(moduleIdentifier, SmiModuleIdentifierDefinition.class);
    }

    public static boolean shouldHaveReference(SmiElementTypeName elementTypeName) {
        PsiElement firstParent = PsiTreeUtil.findFirstParent(elementTypeName, psiElement -> psiElement instanceof SmiChoiceType);
        return firstParent == null;
    }

    public static ItemPresentation getPresentation(SmiMibNode mibNode) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return mibNode.getName();
            }

            @NotNull
            @Override
            public String getLocationString() {
                return mibNode.getContainingFile().getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                SmiValueAssignment valueAssignment = (SmiValueAssignment) PsiTreeUtil.findFirstParent(mibNode, psiElement -> psiElement instanceof SmiValueAssignment);
                if (valueAssignment == null) {
                    return null;
                }

                SmiType type = valueAssignment.getType();
                if (type instanceof SmiSnmpObjectTypeMacroType) {
                    return MibIcons.LEAF;
                } else {
                    return MibIcons.FOLDER;
                }
            }
        };
    }

    public static ItemPresentation getPresentation(SmiTypeName typeName) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return typeName.getName();
            }

            @NotNull
            @Override
            public String getLocationString() {
                return typeName.getContainingFile().getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return MibIcons.FONT;
            }
        };
    }

}
