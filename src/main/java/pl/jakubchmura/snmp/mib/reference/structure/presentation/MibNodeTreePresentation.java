package pl.jakubchmura.snmp.mib.reference.structure.presentation;

import com.intellij.navigation.ItemPresentation;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;

import javax.swing.*;

public class MibNodeTreePresentation implements ItemPresentation {

    private final SmiMibNodeMixin mibNode;

    public MibNodeTreePresentation(SmiMibNodeMixin mibNode) {
        this.mibNode = mibNode;
    }

    @Nullable
    @Override
    public String getPresentableText() {
        return mibNode.getPresentation().getPresentableText();
    }

    @Nullable
    @Override
    public String getLocationString() {
        return null;
    }

    @Nullable
    @Override
    public Icon getIcon(boolean unused) {
        return mibNode.getPresentation().getIcon(unused);
    }
}
