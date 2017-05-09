package pl.jakubchmura.snmp.mib.reference;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibIcons;
import pl.jakubchmura.snmp.mib.psi.SmiIdentifiableElement;
import pl.jakubchmura.snmp.mib.psi.SmiReferenceableElement;
import pl.jakubchmura.snmp.mib.util.SmiFindUtil;

import java.util.ArrayList;
import java.util.List;

public class ReferenceableElementReference<T extends SmiReferenceableElement> extends PsiReferenceBase<SmiIdentifiableElement> implements PsiPolyVariantReference {

    private final Class<T> identifiableElementClass;
    @Nullable
    private final PsiFile psiFile;
    private final boolean withImports;

    public ReferenceableElementReference(@NotNull SmiIdentifiableElement element, @NotNull Class<T> identifiableElementClass) {
        this(element, identifiableElementClass, null);
    }

    public ReferenceableElementReference(@NotNull SmiIdentifiableElement element, @NotNull Class<T> identifiableElementClass, @Nullable PsiFile psiFile) {
        this(element, identifiableElementClass, psiFile, true);
    }

    public ReferenceableElementReference(@NotNull SmiIdentifiableElement element, @NotNull Class<T> identifiableElementClass, @Nullable PsiFile psiFile, boolean withImports) {
        super(element);
        this.identifiableElementClass = identifiableElementClass;
        this.psiFile = psiFile;
        this.withImports = withImports;
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        List<T> elements;
        elements = getElements();
        List<ResolveResult> results = new ArrayList<>();
        for (T element : elements) {
            results.add(new PsiElementResolveResult(element));
        }

        return results.toArray(new ResolveResult[results.size()]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        List<T> elements;
        elements = getElements();
        List<LookupElement> variants = new ArrayList<>();
        for (final T element : elements) {
            if (element.getName() != null && element.getName().length() > 0) {
                variants.add(LookupElementBuilder.create(element.getName())
                        .withIcon(MibIcons.FILE)
                        .withTypeText(element.getContainingFile().getName())
                );
            }
        }
        return variants.toArray();
    }

    private List<T> getElements() {
        List<T> elements;
        if (psiFile != null) {
            if (withImports) {
                elements = getDeclaredAndImportedElementsFromFile(psiFile);
            } else {
                elements = getDeclaredElementsFromFile(psiFile);
            }
        } else {
            elements = SmiFindUtil.findElements(getModuleScope(myElement), identifiableElementClass, myElement.getName());
        }
        return elements;
    }

    private List<T> getImportedElementsFromFile(PsiFile file) {
        return SmiFindUtil.findImportedElements(file, identifiableElementClass, myElement.getName());
    }

    private List<T> getDeclaredElementsFromFile(PsiFile psiFile) {
        return SmiFindUtil.findElements(psiFile, identifiableElementClass, myElement.getName());
    }

    private List<T> getDeclaredAndImportedElementsFromFile(PsiFile psiFile) {
        List<T> imported = getImportedElementsFromFile(psiFile);
        List<T> declared = getDeclaredElementsFromFile(psiFile);
        List<T> elements = new ArrayList<>(imported);
        elements.addAll(declared);
        return elements;
    }

    @Nullable
    private GlobalSearchScope getModuleScope(PsiElement element) {
        VirtualFile virtualFile = element.getContainingFile().getVirtualFile();
        if (virtualFile == null) {
            return null;
        }
        Module module = ProjectFileIndex.getInstance(element.getProject()).getModuleForFile(virtualFile);
        if (module != null) {
            return module.getModuleWithDependenciesAndLibrariesScope(false);
        } else {
            return null;
        }
    }
}
