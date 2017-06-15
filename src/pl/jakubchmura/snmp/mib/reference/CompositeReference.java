package pl.jakubchmura.snmp.mib.reference;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiPolyVariantReference;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.ResolveResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.psi.SmiIdentifiableElement;
import pl.jakubchmura.snmp.mib.psi.SmiReferenceableElement;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CompositeReference extends PsiReferenceBase<SmiIdentifiableElement> implements PsiPolyVariantReference {

    private final List<ReferenceableElementReference<? extends SmiReferenceableElement>> references;

    @SafeVarargs
    public CompositeReference(ReferenceableElementReference<? extends SmiReferenceableElement>... references) {
        super(references[0].getElement());
        this.references = Arrays.asList(references);
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        return references.stream()
                .flatMap(reference -> Arrays.stream(reference.multiResolve(incompleteCode)))
                .toArray(ResolveResult[]::new);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        return references.stream()
                .map(ReferenceableElementReference::resolve)
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return references.stream()
                .flatMap(reference -> Arrays.stream(reference.getVariants()))
                .toArray(Object[]::new);
    }
}
