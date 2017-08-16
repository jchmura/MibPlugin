package pl.jakubchmura.snmp.mib.actions;

import com.intellij.ide.actions.GotoActionBase;
import com.intellij.ide.util.EditSourceUtil;
import com.intellij.ide.util.gotoByName.ChooseByNamePopup;
import com.intellij.lang.Language;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.MibFileType;

public class GotoOidInFileAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        MibFile mibFile = getMibFile(e);
        if (mibFile != null) {
            new GotoOidInFile(mibFile).actionPerformed(e);
        }
    }

    @Override
    public void update(AnActionEvent e) {
        PsiFile psiFile = getMibFile(e);
        e.getPresentation().setEnabledAndVisible(psiFile != null);
    }

    @Nullable
    private MibFile getMibFile(AnActionEvent e) {
        PsiFile psiFile = e.getData(LangDataKeys.PSI_FILE);
        if (psiFile != null) {
            FileType fileType = psiFile.getFileType();
            if (fileType.equals(MibFileType.INSTANCE) && psiFile instanceof MibFile) {
                return (MibFile) psiFile;
            }
        }
        return null;
    }

    private static class GotoOidInFile extends GotoActionBase {

        @NotNull
        private final MibFile mibFile;

        GotoOidInFile(@NotNull MibFile mibFile) {
            this.mibFile = mibFile;
        }

        @Override
        protected void gotoActionPerformed(AnActionEvent e) {
            Project project = e.getProject();
            if (project == null) return;

            GotoOidInFileModel model = new GotoOidInFileModel(mibFile);
            PsiDocumentManager.getInstance(project).commitAllDocuments();
            showNavigationPopup(e, model, new GotoActionCallback<Language>() {
                @Override
                public void elementChosen(ChooseByNamePopup popup, Object element) {
                    EditSourceUtil.navigate((NavigationItem)element, true, popup.isOpenInCurrentWindowRequested());
                }
            }, "OIDs in file matching patterns", true);
        }
    }
}
