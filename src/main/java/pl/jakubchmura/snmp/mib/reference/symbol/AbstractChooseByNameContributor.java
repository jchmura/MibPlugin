package pl.jakubchmura.snmp.mib.reference.symbol;

import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.util.SmiFindUtil;

import java.util.List;

public abstract class AbstractChooseByNameContributor<T extends PsiNamedElement> implements ChooseByNameContributor {

    @NotNull
    @Override
    public String[] getNames(Project project, boolean includeNonProjectItems) {
        return SmiFindUtil.getMibFiles(project, getScope(project, includeNonProjectItems)).stream()
                .flatMap(mibFile -> getDeclaredElementsFromFile(mibFile).stream())
                .map(PsiNamedElement::getName)
                .toArray(String[]::new);
    }

    @NotNull
    @Override
    public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
        return SmiFindUtil.getMibFiles(project, getScope(project, includeNonProjectItems)).stream()
                .flatMap(mibFile -> getDeclaredElementsFromFile(mibFile).stream())
                .filter(t -> name.equals(t.getName()))
                .toArray(NavigationItem[]::new);
    }

    protected abstract List<T> getDeclaredElementsFromFile(MibFile mibFile);

    @NotNull
    private GlobalSearchScope getScope(Project project, boolean includeNonProjectItems) {
        GlobalSearchScope scope;
        if (includeNonProjectItems) {
            scope = GlobalSearchScope.projectScope(project);
        } else {
            scope = GlobalSearchScope.allScope(project);
        }
        return scope;
    }
}
