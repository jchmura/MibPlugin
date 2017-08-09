package pl.jakubchmura.snmp.mib.actions;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.ide.util.gotoByName.ContributorsBasedGotoByModel;
import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.GotoClassContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.SystemInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.reference.contributor.MibNodeChooseByNameContributor;

public class GotoOidModel extends ContributorsBasedGotoByModel {

    GotoOidModel(@NotNull Project project) {
        super(project, new ChooseByNameContributor[]{new MibNodeChooseByNameContributor()});
    }

    @Override
    public String getPromptText() {
        return "Enter OID:";
    }

    @Override
    public String getNotInMessage() {
        return "No matches found";
    }

    @Override
    public String getNotFoundMessage() {
        return "No matches found";
    }

    @Nullable
    @Override
    public String getCheckBoxName() {
        return "Include numerical OIDs";
    }

    @Override
    public char getCheckBoxMnemonic() {
        return SystemInfo.isMac?'P':'n';
    }

    @Override
    public boolean loadInitialCheckBoxState() {
        PropertiesComponent propertiesComponent = PropertiesComponent.getInstance(myProject);
        return Boolean.TRUE.toString().equals(propertiesComponent.getValue("GoToClass.toSaveIncludeLibraries")) &&
                Boolean.TRUE.toString().equals(propertiesComponent.getValue("GoToOid.includeProject"));
    }

    @Override
    public void saveInitialCheckBoxState(boolean state) {
        PropertiesComponent propertiesComponent = PropertiesComponent.getInstance(myProject);
        if (Boolean.TRUE.toString().equals(propertiesComponent.getValue("GoToClass.toSaveIncludeLibraries"))){
            propertiesComponent.setValue("GoToOid.includeProject", Boolean.toString(state));
        }
    }

    @NotNull
    @Override
    public String[] getSeparators() {
        return new String[0];
    }

    @Nullable
    @Override
    public String getFullName(Object element) {
        for(ChooseByNameContributor c: getContributors()) {
            if (c instanceof GotoClassContributor) {
                String result = ((GotoClassContributor) c).getQualifiedName((NavigationItem) element);
                if (result != null) {
                    return result;
                }
            }
        }

        String elementName = getElementName(element);
        if (elementName == null) return null;

        return elementName;
    }

    @Override
    public boolean willOpenEditor() {
        return true;
    }
}
