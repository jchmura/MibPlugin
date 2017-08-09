package pl.jakubchmura.snmp.mib.reference.contributor;

import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.psi.MibNodeNameIndex;
import pl.jakubchmura.snmp.mib.psi.MibNodeOidIndex;
import pl.jakubchmura.snmp.mib.psi.impl.OidSmiMibNodeMixin;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MibNodeChooseByNameContributor implements ChooseByNameContributor {

    @NotNull
    @Override
    public String[] getNames(Project project, boolean includeNonProjectItems) {
        Collection<String> mibNodeNames = MibNodeNameIndex.getInstance().getAllKeys(project);
        Collection<String> mibNodeOids = MibNodeOidIndex.getInstance().getAllKeys(project);

        List<String> names = new ArrayList<>(mibNodeNames);
        names.addAll(mibNodeOids);

        return names.toArray(new String[0]);
    }

    @NotNull
    @Override
    public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
        Collection<SmiMibNodeMixin> mibNodeNames = MibNodeNameIndex.getInstance().get(name, project, getScope(project, includeNonProjectItems));
        Collection<SmiMibNodeMixin> mibNodeOids = MibNodeOidIndex.getInstance().get(name, project, getScope(project, includeNonProjectItems)).stream().map(OidSmiMibNodeMixin::new).collect(Collectors.toList());

        List<SmiMibNodeMixin> items = new ArrayList<>(mibNodeNames);
        items.addAll(mibNodeOids);

        return items.toArray(new NavigationItem[0]);
    }

    @NotNull
    private GlobalSearchScope getScope(Project project, boolean includeNonProjectItems) {
        GlobalSearchScope scope;
        if (includeNonProjectItems) {
            scope = GlobalSearchScope.allScope(project);
        } else {
            scope = GlobalSearchScope.projectScope(project);
        }
        return scope;
    }
}
