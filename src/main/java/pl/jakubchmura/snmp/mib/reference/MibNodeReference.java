package pl.jakubchmura.snmp.mib.reference;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.ResolveResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.psi.MibNodeNameIndex;
import pl.jakubchmura.snmp.mib.psi.SmiElementFactory;
import pl.jakubchmura.snmp.mib.psi.SmiIdentifiableElement;
import pl.jakubchmura.snmp.mib.psi.impl.IsoMibNode;

import java.util.stream.Stream;

import static pl.jakubchmura.snmp.mib.psi.impl.IsoMibNode.ISO;

public class MibNodeReference extends SmiReference {

    public MibNodeReference(@NotNull SmiIdentifiableElement element) {
        this(element, null);
    }

    public MibNodeReference(@NotNull SmiIdentifiableElement element, @Nullable MibFile psiFile) {
        super(element, psiFile, MibNodeNameIndex.getInstance());
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        String name = getElement().getName();

        if (name != null) {
            if (ISO.equals(name)) {
                PsiElement isoElement = SmiElementFactory.createElement(getElement().getProject(), ISO);
                IsoMibNode mibNode = new IsoMibNode(isoElement.getNode());
                return new ResolveResult[]{new PsiElementResolveResult(mibNode)};
            }
        }

        return super.multiResolve(incompleteCode);
    }

    @Override
    protected Stream<SmiIdentifiableElement> getElements(Stream<MibFile> mibFileStream) {
        return mibFileStream.flatMap(mibFile -> mibFile.getMibNodes().stream());
    }
}
