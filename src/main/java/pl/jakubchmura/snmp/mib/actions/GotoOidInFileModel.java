package pl.jakubchmura.snmp.mib.actions;

import com.intellij.ide.util.gotoByName.ContributorsBasedGotoByModel;
import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.GotoClassContributor;
import com.intellij.navigation.NavigationItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.reference.contributor.MibNodeChooseByNameContributor;
import pl.jakubchmura.snmp.mib.reference.contributor.MibNodeOidChooseByNameContributor;

public class GotoOidInFileModel extends ContributorsBasedGotoByModel {

    GotoOidInFileModel(@NotNull MibFile mibFile) {
        super(mibFile.getProject(), new ChooseByNameContributor[]{
                new MibNodeOidChooseByNameContributor(mibFile),
                new MibNodeChooseByNameContributor(mibFile)});
    }

    @Override
    public String getPromptText() {
        return "Enter OID:";
    }

    @Override
    public String getNotInMessage() {
        return "No matches found in file";
    }

    @Override
    public String getNotFoundMessage() {
        return null;
    }

    @Nullable
    @Override
    public String getCheckBoxName() {
        return null;
    }

    @Override
    public boolean loadInitialCheckBoxState() {
        return false;
    }

    @Override
    public void saveInitialCheckBoxState(boolean state) {

    }

    @NotNull
    @Override
    public String[] getSeparators() {
        return new String[0];
    }

    @Nullable
    @Override
    public String getFullName(Object element) {
        for (ChooseByNameContributor c : getContributors()) {
            if (c instanceof GotoClassContributor) {
                String result = ((GotoClassContributor) c).getQualifiedName((NavigationItem) element);
                if (result != null) {
                    return result;
                }
            }
        }

        String elementName = getElementName(element);

        return elementName;
    }

    @Override
    public boolean willOpenEditor() {
        return true;
    }
}
