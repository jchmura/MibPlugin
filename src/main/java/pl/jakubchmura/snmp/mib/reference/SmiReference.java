package pl.jakubchmura.snmp.mib.reference;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.CommonProcessors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.StandardSnmpMibs;
import pl.jakubchmura.snmp.mib.psi.SmiIdentifiableElement;
import pl.jakubchmura.snmp.mib.psi.SmiStubIndex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public abstract class SmiReference extends PsiReferenceBase<SmiIdentifiableElement> implements PsiPolyVariantReference {

    private final MibFile psiFile;
    private final SmiStubIndex<? extends SmiIdentifiableElement> index;

    SmiReference(@NotNull SmiIdentifiableElement element, @Nullable MibFile psiFile, @NotNull SmiStubIndex<? extends SmiIdentifiableElement> index) {
        super(element);
        this.psiFile = psiFile;
        this.index = index;
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length > 0 ? resolveResults[0].getElement() : null;
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        String name = getElement().getName();

        if (name != null) {
            Project project = getElement().getProject();
            Collection<? extends SmiIdentifiableElement> definitions = index.get(name, project, getScope());
            return mapToResult(definitions);
        }

        return new ResolveResult[0];
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        if (psiFile == null) {
            CommonProcessors.CollectUniquesProcessor<String> processor = new CommonProcessors.CollectUniquesProcessor<>();
            index.processAllKeys(processor, getScope());
            return processor.toArray(new String[0]);
        } else {
            return getElements(Stream.of((psiFile)))
                    .map(PsiNamedElement::getName)
                    .toArray();
        }
    }

    protected abstract Stream<SmiIdentifiableElement> getElements(Stream<MibFile> mibFileStream);

    private GlobalSearchScope getScope() {
        if (psiFile != null) {
            return GlobalSearchScope.fileScope(psiFile);
        }

        Project project = getElement().getProject();
        GlobalSearchScope standardMibs = StandardSnmpMibs.getScope(project);

        PsiFile containingFile = getElement().getContainingFile();
        if (containingFile == null) {
            return standardMibs;
        }
        VirtualFile virtualFile = containingFile.getVirtualFile();
        if (virtualFile == null) {
            return standardMibs;
        }

        Module module = ProjectFileIndex.getInstance(project).getModuleForFile(virtualFile);
        if (module != null) {
            GlobalSearchScope moduleScope = module.getModuleWithDependenciesAndLibrariesScope(false);
            return moduleScope.uniteWith(standardMibs);
        } else {
            return standardMibs;
        }
    }

    private ResolveResult[] mapToResult(Collection<? extends PsiElement> elements) {
        Collection<? extends PsiElement> filtered;
        Collection<? extends PsiElement> sameFile = referencesInSameFile(elements);
        if (!sameFile.isEmpty()) {
            filtered = sameFile;
        } else {
            filtered = StandardSnmpMibs.filterOutStandardMibs(elements);
        }
        return filtered.stream().map(PsiElementResolveResult::new).toArray(ResolveResult[]::new);
    }

    private Collection<? extends PsiElement> referencesInSameFile(Collection<? extends PsiElement> elements) {
        Collection<PsiElement> collection = new ArrayList<>();
        PsiFile containingFile = getElement().getContainingFile();
        for (PsiElement element : elements) {
            if (element.getContainingFile().equals(containingFile)) {
                collection.add(element);
            }
        }
        return collection;
    }

}
