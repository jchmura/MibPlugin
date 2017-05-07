package pl.jakubchmura.snmp.mib.reference;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibIcons;
import pl.jakubchmura.snmp.mib.psi.SmiIdentifiableElement;
import pl.jakubchmura.snmp.mib.util.SmiFindUtil;

import java.util.ArrayList;
import java.util.List;

public class ReferenceableElementReference<T extends SmiIdentifiableElement> extends PsiReferenceBase<SmiIdentifiableElement> implements PsiPolyVariantReference {

    private final Class<T> identifiableElementClass;
    @Nullable
    private final PsiFile psiFile;

    public ReferenceableElementReference(@NotNull SmiIdentifiableElement element, @NotNull Class<T> identifiableElementClass) {
        this(element, identifiableElementClass, null);
    }

    public ReferenceableElementReference(@NotNull SmiIdentifiableElement element, @NotNull Class<T> identifiableElementClass, @Nullable PsiFile psiFile) {
        super(element);
        this.identifiableElementClass = identifiableElementClass;
        this.psiFile = psiFile;
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        List<T> elements;
        if (psiFile != null) {
            elements = SmiFindUtil.findIdentifiableElements(psiFile, identifiableElementClass, myElement.getName());
        } else {
            elements = SmiFindUtil.findIdentifiableElements(project, identifiableElementClass, myElement.getName());
        }
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
        Project project = myElement.getProject();
        List<T> elements;
        if (psiFile != null) {
            elements = SmiFindUtil.findElements(psiFile, identifiableElementClass);
        } else {
            elements = SmiFindUtil.findElements(project, identifiableElementClass);
        }
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
}
