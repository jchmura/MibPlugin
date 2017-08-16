package pl.jakubchmura.snmp.mib.actions;

import com.intellij.ide.actions.GotoActionBase;
import com.intellij.ide.util.EditSourceUtil;
import com.intellij.ide.util.gotoByName.ChooseByNamePopup;
import com.intellij.lang.Language;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDocumentManager;

public class GotoOidNameAction extends GotoActionBase {

    @Override
    protected void gotoActionPerformed(AnActionEvent e) {
        Project project = e.getProject();
        if (project == null) return;

        GotoOidNameModel model = new GotoOidNameModel(project);
        PsiDocumentManager.getInstance(project).commitAllDocuments();
        showNavigationPopup(e, model, new GotoActionCallback<Language>() {
            @Override
            public void elementChosen(ChooseByNamePopup popup, Object element) {
                EditSourceUtil.navigate((NavigationItem)element, true, popup.isOpenInCurrentWindowRequested());
            }
        }, "OIDs matching patterns", true);
    }


}
