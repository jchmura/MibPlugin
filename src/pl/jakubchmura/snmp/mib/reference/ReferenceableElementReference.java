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
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.MibIcons;
import pl.jakubchmura.snmp.mib.psi.SmiIdentifiableElement;
import pl.jakubchmura.snmp.mib.psi.SmiReferenceableElement;
import pl.jakubchmura.snmp.mib.util.SmiFindUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class ReferenceableElementReference<T extends SmiReferenceableElement> extends PsiReferenceBase<SmiIdentifiableElement> implements PsiPolyVariantReference {

    private final Class<T> identifiableElementClass;
    @Nullable
    private final MibFile mibFile;
    private final boolean withImports;

    ReferenceableElementReference(@NotNull SmiIdentifiableElement element, @NotNull Class<T> identifiableElementClass) {
        this(element, identifiableElementClass, null);
    }

    ReferenceableElementReference(@NotNull SmiIdentifiableElement element, @NotNull Class<T> identifiableElementClass, @Nullable MibFile mibFile) {
        this(element, identifiableElementClass, mibFile, true);
    }

    ReferenceableElementReference(@NotNull SmiIdentifiableElement element, @NotNull Class<T> identifiableElementClass, @Nullable MibFile mibFile, boolean withImports) {
        super(element);
        this.identifiableElementClass = identifiableElementClass;
        this.mibFile = mibFile;
        this.withImports = withImports;
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        List<T> elements = SmiFindUtil.filterOutStandardMibs(getElementsWithName());
        return elements.stream().map(PsiElementResolveResult::new).toArray(ResolveResult[]::new);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length > 0 ? resolveResults[0].getElement() : null;
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
        if (mibFile != null) {
            if (withImports) {
                elements = getDeclaredAndImportedElementsFromFile(mibFile);
            } else {
                elements = getDeclaredElementsFromFile(mibFile);
            }
        } else {
            elements = getElementsFromEverywhere();
        }
        return elements;
    }

    private List<T> getElementsWithName() {
        return getElements()
                .stream()
                .filter(t -> Objects.equals(t.getName(), myElement.getName()))
                .collect(Collectors.toList());
    }

    private List<T> getImportedElementsFromFile(MibFile mibFile) {
        return SmiFindUtil.findImportedElements(mibFile, identifiableElementClass);
    }

    private List<T> getElementsFromEverywhere() {
        GlobalSearchScope scope = getScope(myElement);
        return SmiFindUtil.getMibFiles(myElement.getProject(), scope).stream()
                .flatMap(mibFile -> getDeclaredElementsFromFile(mibFile).stream())
                .collect(Collectors.toList());
    }

    protected abstract List<T> getDeclaredElementsFromFile(MibFile mibFile);

    private List<T> getDeclaredAndImportedElementsFromFile(MibFile mibFile) {
        List<T> imported = getImportedElementsFromFile(mibFile);
        List<T> declared = getDeclaredElementsFromFile(mibFile);
        List<T> elements = new ArrayList<>(imported);
        elements.addAll(declared);
        return elements;
    }

    @Nullable
    private GlobalSearchScope getScope(PsiElement element) {
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
