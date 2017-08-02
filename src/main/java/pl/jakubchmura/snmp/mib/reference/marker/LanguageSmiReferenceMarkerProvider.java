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
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.MibIcons;
import pl.jakubchmura.snmp.mib.psi.SmiReferenceableElement;
import pl.jakubchmura.snmp.mib.util.SmiFindUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

abstract class LanguageSmiReferenceMarkerProvider extends RelatedItemLineMarkerProvider {

    private static final Pattern IDENTIFIER_STRING = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

    RelatedItemLineMarkerInfo<PsiElement> collectSmiReferences(@NotNull PsiElement element, String name) {
        GlobalSearchScope scope = getScope(element);
        Project project = element.getProject();
        List<SmiReferenceableElement> elements = SmiFindUtil.getMibFiles(project, scope).stream()
                .flatMap(mibFile -> getDeclaredElementsFromFile(mibFile).stream())
                .filter(e -> name.equals(e.getName()))
                .collect(Collectors.toList());
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
        return null;
    }

    boolean isIdentifier(String text) {
        return IDENTIFIER_STRING.matcher(text).matches();
    }

    private List<SmiReferenceableElement> getDeclaredElementsFromFile(MibFile mibFile) {
        List<SmiReferenceableElement> elements = new ArrayList<>();
        elements.addAll(mibFile.getMibNodes());
        elements.addAll(mibFile.getTextualConventions());
        return elements;
    }

    @Nullable
    private GlobalSearchScope getScope(PsiElement element) {
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
