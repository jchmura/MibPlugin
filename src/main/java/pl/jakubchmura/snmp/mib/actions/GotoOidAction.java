package pl.jakubchmura.snmp.mib.actions;

import com.intellij.ide.actions.GotoActionBase;
import com.intellij.ide.util.EditSourceUtil;
import com.intellij.ide.util.gotoByName.ChooseByNamePopup;
import com.intellij.lang.Language;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDocumentManager;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibFile;

public class GotoOidAction extends GotoActionBase {

    @Nullable
    private final MibFile mibFile;

    public GotoOidAction() {
        this(null);
    }

    public GotoOidAction(@Nullable MibFile mibFile) {
        this.mibFile = mibFile;
    }

    @Override
    protected void gotoActionPerformed(AnActionEvent e) {
        Project project = e.getProject();
        if (project == null) return;

        GotoOidModel model = new GotoOidModel(project, mibFile);
        PsiDocumentManager.getInstance(project).commitAllDocuments();
        showNavigationPopup(e, model, new GotoActionCallback<Language>() {
            @Override
            public void elementChosen(ChooseByNamePopup popup, Object element) {
                EditSourceUtil.navigate((NavigationItem)element, true, popup.isOpenInCurrentWindowRequested());
            }
        }, "OIDs matching patterns", true);
    }


}
