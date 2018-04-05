package pl.jakubchmura.snmp.mib.reference;

import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.CommonProcessors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.psi.SmiIdentifiableElement;
import pl.jakubchmura.snmp.mib.psi.SmiStubIndex;

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
            return ReferenceUtil.mapToResult(definitions, getElement());
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

        return ReferenceUtil.getScope(getElement());
    }

}
