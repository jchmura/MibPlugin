package pl.jakubchmura.snmp.mib;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.psi.SmiModuleDefinition;
import pl.jakubchmura.snmp.mib.psi.SmiSymbolsFromModule;
import pl.jakubchmura.snmp.mib.psi.SmiTypeName;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;

import javax.swing.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        return getImportedSymbols(getModuleDefinitions().stream());
    }

    @NotNull
    public List<SmiSymbolsFromModule> getImportedSymbols(PsiElement psiElement) {
        SmiModuleDefinition parentOfType = PsiTreeUtil.getParentOfType(psiElement, SmiModuleDefinition.class);
        return getImportedSymbols(Stream.of(parentOfType));
    }

    @NotNull
    private List<SmiSymbolsFromModule> getImportedSymbols(Stream<SmiModuleDefinition> moduleDefinitions) {
        return moduleDefinitions
                .map(SmiModuleDefinition::getImportList)
                .filter(Objects::nonNull)
                .flatMap(list -> list.getSymbolsFromModuleList().stream())
                .collect(Collectors.toList());
    }

}
