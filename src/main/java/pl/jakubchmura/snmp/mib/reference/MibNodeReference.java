package pl.jakubchmura.snmp.mib.reference;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.PsiFile;
import com.intellij.psi.ResolveResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.psi.SmiElementFactory;
import pl.jakubchmura.snmp.mib.psi.SmiIdentifiableElement;
import pl.jakubchmura.snmp.mib.psi.impl.IsoMibNode;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;

import java.util.List;

import static pl.jakubchmura.snmp.mib.psi.impl.IsoMibNode.ISO;

public class MibNodeReference extends ReferenceableElementReference<SmiMibNodeMixin> {

    public MibNodeReference(@NotNull SmiIdentifiableElement element) {
        super(element, SmiMibNodeMixin.class, (MibFile) element.getContainingFile());
    }

    public MibNodeReference(@NotNull SmiIdentifiableElement element, @Nullable PsiFile psiFile, boolean withImports) {
        super(element, SmiMibNodeMixin.class, (MibFile) psiFile, withImports);
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        String name = myElement.getName();

        if (ISO.equals(name)) {
            PsiElement isoElement = SmiElementFactory.createElement(myElement.getProject(), ISO);
            IsoMibNode mibNode = new IsoMibNode(isoElement.getNode());
            return new ResolveResult[]{new PsiElementResolveResult(mibNode)};
        }

        return super.multiResolve(incompleteCode);
    }

    @Override
    protected List<SmiMibNodeMixin> getDeclaredElementsFromFile(MibFile mibFile) {
        return mibFile.getMibNodes();
    }


}