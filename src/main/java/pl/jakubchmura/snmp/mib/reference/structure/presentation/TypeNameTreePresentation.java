package pl.jakubchmura.snmp.mib.reference.structure.presentation;

import com.intellij.navigation.ItemPresentation;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.psi.SmiTypeName;

import javax.swing.*;

public class TypeNameTreePresentation implements ItemPresentation {

    private final SmiTypeName typeName;

    public TypeNameTreePresentation(SmiTypeName typeName) {
        this.typeName = typeName;
    }

    @Nullable
    @Override
    public String getPresentableText() {
        ItemPresentation presentation = typeName.getPresentation();
        if (presentation != null) {
            return presentation.getPresentableText();
        }
        return null;
    }

    @Nullable
    @Override
    public String getLocationString() {
        return null;
    }

    @Nullable
    @Override
    public Icon getIcon(boolean unused) {
        ItemPresentation presentation = typeName.getPresentation();
        if (presentation != null) {
            return presentation.getIcon(unused);
        }
        return null;
    }
}
