package pl.jakubchmura.snmp.mib.reference.symbol;

import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.psi.SmiReferenceableElement;
import pl.jakubchmura.snmp.mib.util.SmiFindUtil;

import java.util.List;

public class AbstractChooseByNameContributor implements ChooseByNameContributor {

    private Class<? extends SmiReferenceableElement> elementClass;

    AbstractChooseByNameContributor(Class<? extends SmiReferenceableElement> elementClass) {
        this.elementClass = elementClass;
    }

    @NotNull
    @Override
    public String[] getNames(Project project, boolean includeNonProjectItems) {
        return SmiFindUtil.findElements(project, getScope(project, includeNonProjectItems), elementClass)
                .stream()
                .map(PsiNamedElement::getName)
                .toArray(String[]::new);
    }

    @NotNull
    @Override
    public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
        List<? extends SmiReferenceableElement> elements = SmiFindUtil.findElements(project, getScope(project, includeNonProjectItems), elementClass, name);
        return elements.toArray(new NavigationItem[elements.size()]);
    }

    @NotNull
    private GlobalSearchScope getScope(Project project, boolean includeNonProjectItems) {
        GlobalSearchScope scope;
        if (includeNonProjectItems) {
            scope = GlobalSearchScope.everythingScope(project);
        } else {
            scope = GlobalSearchScope.allScope(project);
        }
        return scope;
    }
}
