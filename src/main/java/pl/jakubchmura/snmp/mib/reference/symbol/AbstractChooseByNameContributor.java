package pl.jakubchmura.snmp.mib.reference.symbol;

import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.util.SmiFindUtil;

import java.util.List;
import java.util.stream.Stream;

public abstract class AbstractChooseByNameContributor<T extends PsiNamedElement> implements ChooseByNameContributor {

    private final MibFile mibFile;

    AbstractChooseByNameContributor() {
        this(null);
    }

    AbstractChooseByNameContributor(@Nullable MibFile mibFile) {
        this.mibFile = mibFile;
    }

    @NotNull
    @Override
    public String[] getNames(Project project, boolean includeNonProjectItems) {
        return getMibFiles(project)
                .flatMap(mibFile -> getDeclaredElementsFromFile(mibFile, includeNonProjectItems).stream())
                .map(PsiNamedElement::getName)
                .toArray(String[]::new);
    }

    @NotNull
    @Override
    public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
        return getMibFiles(project)
                .flatMap(mibFile -> getDeclaredElementsFromFile(mibFile, includeNonProjectItems).stream())
                .filter(t -> name.equals(t.getName()))
                .toArray(NavigationItem[]::new);
    }

    private Stream<MibFile> getMibFiles(Project project) {
        if (mibFile == null) {
            return SmiFindUtil.getMibFiles(project, getScope(project)).stream();
        } else {
            return Stream.of(mibFile);
        }
    }

    protected abstract List<T> getDeclaredElementsFromFile(MibFile mibFile, boolean includeNumericalOids);

    @NotNull
    private GlobalSearchScope getScope(Project project) {
        return GlobalSearchScope.projectScope(project);
    }
}
