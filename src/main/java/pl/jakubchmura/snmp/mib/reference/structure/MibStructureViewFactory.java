package pl.jakubchmura.snmp.mib.reference.structure;

import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.TreeBasedStructureViewBuilder;
import com.intellij.lang.PsiStructureViewFactory;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibFile;

public class MibStructureViewFactory implements PsiStructureViewFactory {
    @Nullable
    @Override
    public StructureViewBuilder getStructureViewBuilder(@NotNull PsiFile psiFile) {
        if (psiFile instanceof MibFile) {
            MibFile mibFile = (MibFile) psiFile;
            return new TreeBasedStructureViewBuilder() {

                @NotNull
                @Override
                public StructureViewModel createStructureViewModel(@Nullable Editor editor) {
                    return new MibStructureViewModel(mibFile, editor);
                }
            };
        } else {
            return null;
        }
    }
}
