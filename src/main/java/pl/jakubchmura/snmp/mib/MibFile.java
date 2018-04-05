package pl.jakubchmura.snmp.mib;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.psi.SmiModuleDefinition;
import pl.jakubchmura.snmp.mib.psi.SmiSymbolsFromModule;
import pl.jakubchmura.snmp.mib.psi.SmiTypeName;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;
import pl.jakubchmura.snmp.mib.reference.ReferenceUtil;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

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
        return "MIB:" + getName();
    }

    @Nullable
    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }

    @NotNull
    public List<SmiMibNodeMixin> getMibNodes() {
        return getModuleDefinitions().stream()
                .flatMap(definition -> definition.getMibNodes().stream())
                .collect(Collectors.toList());
    }

    @NotNull
    public List<SmiTypeName> getTextualConventions() {
        return getModuleDefinitions().stream()
                .flatMap(definition -> definition.getTextualConventions().stream())
                .collect(Collectors.toList());
    }

    @NotNull
    public List<SmiModuleDefinition> getModuleDefinitions() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, SmiModuleDefinition.class);
    }

    @NotNull
    public List<SmiSymbolsFromModule> getImportedSymbols() {
        return ReferenceUtil.getImportedSymbols(getModuleDefinitions().stream());
    }

}
