package pl.jakubchmura.snmp.mib.reference.contributor;

import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.psi.MibNodeNameIndex;

public class MibNodeChooseByNameContributor implements ChooseByNameContributor {

    @Nullable
    private final MibFile mibFile;

    public MibNodeChooseByNameContributor(@Nullable MibFile mibFile) {
        this.mibFile = mibFile;
    }

    @NotNull
    @Override
    public String[] getNames(Project project, boolean includeNonProjectItems) {
        return MibNodeNameIndex.getInstance().getAllKeys(project).toArray(new String[0]);
    }

    @NotNull
    @Override
    public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
        return  MibNodeNameIndex.getInstance().get(name, project, getScope(project, includeNonProjectItems)).toArray(new NavigationItem[0]);
    }

    @NotNull
    private GlobalSearchScope getScope(Project project, boolean includeNonProjectItems) {
        GlobalSearchScope scope;
        if (mibFile != null) {
            scope = GlobalSearchScope.fileScope(mibFile);
        } else if (includeNonProjectItems) {
            scope = GlobalSearchScope.allScope(project);
        } else {
            scope = GlobalSearchScope.projectScope(project);
        }
        return scope;
    }
}
