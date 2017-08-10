package pl.jakubchmura.snmp.mib;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.psi.SmiModuleDefinition;
import pl.jakubchmura.snmp.mib.psi.SmiTypeAssignment;
import pl.jakubchmura.snmp.mib.psi.SmiTypeName;
import pl.jakubchmura.snmp.mib.psi.SmiValueAssignment;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;
import pl.jakubchmura.snmp.mib.util.oid.SnmpOid;

import javax.swing.*;
import java.util.ArrayList;
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
        return "MIB";
    }

    @Nullable
    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }

    @NotNull
    public List<SmiMibNodeMixin> getTopLevelMibNodes() {
        int minDepth = Integer.MAX_VALUE;
        List<SmiMibNodeMixin> topLevelMibNodes = new ArrayList<>();
        List<SmiMibNodeMixin> mibNodes = getMibNodes();
        for (SmiMibNodeMixin mibNode : mibNodes) {
            SnmpOid oid = mibNode.getOid();
            if (oid == null) {
                continue;
            }
            int depth = oid.getDepth();
            if (depth < minDepth) {
                topLevelMibNodes.clear();
                topLevelMibNodes.add(mibNode);
                minDepth = depth;
            } else if (depth == minDepth) {
                topLevelMibNodes.add(mibNode);
            }
        }
        return topLevelMibNodes;
    }

    @NotNull
    public List<SmiMibNodeMixin> getMibNodes() {
        return getModuleDefinitions().stream()
                .flatMap(definition -> definition.getAssignmentList().stream())
                .filter(assignment -> assignment instanceof SmiValueAssignment)
                .map(SmiValueAssignment.class::cast)
                .map(SmiValueAssignment::getMibNode)
                .map(SmiMibNodeMixin.class::cast)
                .collect(Collectors.toList());
    }

    @NotNull
    public List<SmiTypeName> getTextualConventions() {
        return getModuleDefinitions().stream()
                .flatMap(definition -> definition.getAssignmentList().stream())
                .filter(assignment -> assignment instanceof SmiTypeAssignment)
                .map(SmiTypeAssignment.class::cast)
                .map(SmiTypeAssignment::getTypeName)
                .collect(Collectors.toList());
    }

    @NotNull
    public List<SmiModuleDefinition> getModuleDefinitions() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, SmiModuleDefinition.class);
    }


}
