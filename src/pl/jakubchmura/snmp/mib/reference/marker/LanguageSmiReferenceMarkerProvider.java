package pl.jakubchmura.snmp.mib.reference.marker;

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibIcons;
import pl.jakubchmura.snmp.mib.psi.SmiReferenceableElement;
import pl.jakubchmura.snmp.mib.util.SmiFindUtil;

import javax.swing.*;
import java.util.List;

public abstract class LanguageSmiReferenceMarkerProvider extends RelatedItemLineMarkerProvider {


    RelatedItemLineMarkerInfo<PsiElement> collectSmiReferences(@NotNull PsiElement element, String name) {
        GlobalSearchScope scope = getModuleScope(element);
        if (scope != null) {
            Project project = element.getProject();
            List<SmiReferenceableElement> elements = SmiFindUtil.findElements(project, scope, SmiReferenceableElement.class, name);
            List<SmiReferenceableElement> filtered = SmiFindUtil.filterOutStandardMibs(elements);
            if (!filtered.isEmpty()) {
                Icon icon = filtered.stream().findFirst()
                        .map(NavigationItem::getPresentation)
                        .map(presentation -> presentation.getIcon(false))
                        .orElse(MibIcons.FILE);

                NavigationGutterIconBuilder<PsiElement> builder = NavigationGutterIconBuilder
                        .create(icon)
                        .setTargets(filtered);

                return builder.createLineMarkerInfo(element);
            }
        }
        return null;
    }

    @Nullable
    private GlobalSearchScope getModuleScope(PsiElement element) {
        VirtualFile virtualFile = element.getContainingFile().getVirtualFile();
        if (virtualFile == null) {
            return null;
        }
        Module module = ProjectFileIndex.getInstance(element.getProject()).getModuleForFile(virtualFile);
        if (module != null) {
            return module.getModuleScope(false);
        } else {
            return null;
        }
    }

}
