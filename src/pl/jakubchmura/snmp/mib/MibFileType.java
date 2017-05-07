package pl.jakubchmura.snmp.mib;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class MibFileType extends LanguageFileType {
    public static final MibFileType INSTANCE = new MibFileType();

    private MibFileType() {
        super(SmiLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "MIB file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "SMIv2 language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "mib";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return MibIcons.FILE;
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }
}
