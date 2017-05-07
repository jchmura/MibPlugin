package pl.jakubchmura.snmp.mib;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class MibFile extends PsiFileBase {
    public MibFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, SmiLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return MibFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "MIB File";
    }

    @Nullable
    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }


}
