package pl.jakubchmura.snmp.mib.reference.marker;

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.MibIcons;
import pl.jakubchmura.snmp.mib.psi.MibNodeNameIndex;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;

import javax.swing.*;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class LanguageSmiReferenceMarkerProvider extends RelatedItemLineMarkerProvider {

    private static final Pattern IDENTIFIER_STRING = Pattern.compile("([a-zA-Z][a-zA-Z0-9_-]*)(\\.\\d)?");

    RelatedItemLineMarkerInfo<PsiElement> collectSmiReferences(@NotNull PsiElement element, String name) {
        Collection<SmiMibNodeMixin> mibNodes = MibNodeNameIndex.getInstance().get(name, element.getProject(), getScope(element));

        if (!mibNodes.isEmpty()) {
            Icon icon = mibNodes.stream().findFirst()
                    .map(NavigationItem::getPresentation)
                    .map(presentation -> presentation.getIcon(false))
                    .orElse(MibIcons.FILE);

            NavigationGutterIconBuilder<PsiElement> builder = NavigationGutterIconBuilder
                    .create(icon)
                    .setTooltipText(name)
                    .setTargets(mibNodes);

            return builder.createLineMarkerInfo(element);
        }
        return null;
    }

    Matcher getMatcher(String text) {
        return IDENTIFIER_STRING.matcher(text);
    }

    private GlobalSearchScope getScope(PsiElement element) {
        VirtualFile virtualFile = element.getContainingFile().getVirtualFile();
        if (virtualFile == null) {
            return GlobalSearchScope.EMPTY_SCOPE;
        }
        Module module = ProjectFileIndex.getInstance(element.getProject()).getModuleForFile(virtualFile);
        if (module != null) {
            return module.getModuleScope(false);
        } else {
            return GlobalSearchScope.EMPTY_SCOPE;
        }
    }

}
