package pl.jakubchmura.snmp.mib.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CustomShortcutSet;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.ui.popup.ComponentPopupBuilder;
import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.psi.PsiFile;
import com.intellij.ui.SearchTextField;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.MibFileType;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;
import pl.jakubchmura.snmp.mib.util.oid.SnmpOid;

import java.util.Optional;

public class GotoOidInFileAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        MibFile mibFile = getMibFile(e);
        if (mibFile != null) {
            new GotoOidAction(mibFile).actionPerformed(e);
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
            if (fileType.equals(MibFileType.INSTANCE)) {
                return (MibFile) psiFile;
            }
        }
        return null;
    }
}
