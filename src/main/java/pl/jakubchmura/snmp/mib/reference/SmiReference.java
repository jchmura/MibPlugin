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

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class SmiReference extends PsiReferenceBase<SmiIdentifiableElement> implements PsiPolyVariantReference {

    private final PsiFile psiFile;
    private final SmiStubIndex<? extends SmiIdentifiableElement> index;

    SmiReference(@NotNull SmiIdentifiableElement element, @Nullable PsiFile psiFile, @NotNull SmiStubIndex<? extends SmiIdentifiableElement> index) {
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
            if (!definitions.isEmpty()) {
                return mapToResult(definitions);
            } else if (psiFile == null) {
                return mapToResult(getElements(StandardSnmpMibs.getMibFiles(project))
                        .filter(element -> name.equals(element.getName()))
                        .collect(Collectors.toSet()));
            }

            MibFile mibFile = getMibFile();
            if (mibFile != null) {
                return mapToResult(getElements(Stream.of(mibFile))
                        .filter(element -> name.equals(element.getName()))
                        .collect(Collectors.toSet()));
            }
        }

        return new ResolveResult[0];
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        CommonProcessors.CollectUniquesProcessor<String> processor = new CommonProcessors.CollectUniquesProcessor<>();
        index.processAllKeys(processor, getScope());
        return processor.toArray(new String[0]);
    }

    protected abstract Stream<SmiIdentifiableElement> getElements(Stream<MibFile> mibFileStream);

    private GlobalSearchScope getScope() {
        if (psiFile != null) {
            return GlobalSearchScope.fileScope(psiFile);
        }
        PsiFile containingFile = getElement().getContainingFile();
        if (containingFile == null) {
            return GlobalSearchScope.EMPTY_SCOPE;
        }
        VirtualFile virtualFile = containingFile.getVirtualFile();
        if (virtualFile == null) {
            return GlobalSearchScope.EMPTY_SCOPE;
        }
        Module module = ProjectFileIndex.getInstance(getElement().getProject()).getModuleForFile(virtualFile);
        if (module != null) {
            return module.getModuleWithDependenciesAndLibrariesScope(false);
        } else {
            return GlobalSearchScope.EMPTY_SCOPE;
        }
    }

    private ResolveResult[] mapToResult(Collection<? extends PsiElement> elements) {
        return elements.stream().map(PsiElementResolveResult::new).toArray(ResolveResult[]::new);
    }

    @Nullable
    private MibFile getMibFile() {
        if (psiFile == null) {
            return null;
        }
        List<String> collect = StandardSnmpMibs.MIBS.stream().map(VirtualFile::getName).collect(Collectors.toList());
        boolean contains = collect.contains(psiFile.getVirtualFile().getName());

        if (contains && psiFile instanceof MibFile) {
            return (MibFile) psiFile;
        }
        return null;
    }

}
