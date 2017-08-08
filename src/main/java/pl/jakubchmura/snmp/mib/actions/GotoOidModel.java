package pl.jakubchmura.snmp.mib.actions;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.ide.util.gotoByName.ContributorsBasedGotoByModel;
import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.GotoClassContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.psi.PsiElement;
import com.intellij.psi.presentation.java.SymbolPresentationUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.reference.symbol.MibNodeChooseByNameContributor;

public class GotoOidModel extends ContributorsBasedGotoByModel {

    private final boolean inFile;

    public GotoOidModel(@NotNull Project project, @Nullable MibFile mibFile) {
        super(project, new ChooseByNameContributor[]{new MibNodeChooseByNameContributor(mibFile)});
        inFile = mibFile != null;
    }

    @Override
    public String getPromptText() {
        String text = "Enter OID";
        if (inFile) {
            text += " (in file)";
        }
        text += ":";
        return text;
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
        return SystemInfo.isMac?'m':'n';
    }

    @Override
    public boolean loadInitialCheckBoxState() {
        PropertiesComponent propertiesComponent = PropertiesComponent.getInstance(myProject);
        return Boolean.TRUE.toString().equals(propertiesComponent.getValue("GoToClass.toSaveIncludeLibraries")) &&
                Boolean.TRUE.toString().equals(propertiesComponent.getValue("GoToOid.includeNumerical"));
    }

    @Override
    public void saveInitialCheckBoxState(boolean state) {
        PropertiesComponent propertiesComponent = PropertiesComponent.getInstance(myProject);
        if (Boolean.TRUE.toString().equals(propertiesComponent.getValue("GoToClass.toSaveIncludeLibraries"))){
            propertiesComponent.setValue("GoToOid.includeNumerical", Boolean.toString(state));
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

        if (element instanceof PsiElement) {
            return SymbolPresentationUtil.getSymbolContainerText((PsiElement)element) + "." + elementName;
        }

        return elementName;
    }

    @Override
    public boolean willOpenEditor() {
        return true;
    }
}
