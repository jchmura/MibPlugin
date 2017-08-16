package pl.jakubchmura.snmp.mib.reference.contributor;

import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.psi.impl.OidSmiMibNodeMixin;

public class MibNodeOidChooseByNameContributor implements ChooseByNameContributor {

    private final MibFile mibFile;

    public MibNodeOidChooseByNameContributor(@NotNull MibFile mibFile) {
        this.mibFile = mibFile;
    }

    @NotNull
    @Override
    public String[] getNames(Project project, boolean includeNonProjectItems) {
        return mibFile.getMibNodes().stream()
                .map(OidSmiMibNodeMixin::new)
                .map(OidSmiMibNodeMixin::getName)
                .toArray(String[]::new);
    }

    @NotNull
    @Override
    public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
        return mibFile.getMibNodes().stream()
                .map(OidSmiMibNodeMixin::new)
                .filter(oid -> oid.getName().equals(name))
                .toArray(NavigationItem[]::new);
    }
}
