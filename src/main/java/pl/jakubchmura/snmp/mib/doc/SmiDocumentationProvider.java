package pl.jakubchmura.snmp.mib.doc;

import com.intellij.codeInsight.documentation.DocumentationManager;
import com.intellij.lang.documentation.AbstractDocumentationProvider;
import com.intellij.lang.documentation.DocumentationMarkup;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.ResolveResult;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.psi.*;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;
import pl.jakubchmura.snmp.mib.reference.ReferenceUtil;
import pl.jakubchmura.snmp.mib.util.oid.SnmpOid;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SmiDocumentationProvider extends AbstractDocumentationProvider {

    private static final Logger LOG = Logger.getInstance(SmiDocumentationProvider.class);

    @Override
    public String generateDoc(PsiElement element, @Nullable PsiElement originalElement) {
        if (element instanceof SmiMibNodeMixin) {
            return generateDocMibNode((SmiMibNodeMixin) element);
        } else if (element instanceof SmiTypeName) {
            return generateDocTypeName((SmiTypeName) element);
        }
        return null;
    }

    @NotNull
    private String generateDocTypeName(SmiTypeName element) {
        SmiType smiType = element.getParentAssignment().getType();

        String type = smiType.getFirstChild().getText();
        String description = null;
        SmiType syntax = null;

        if (smiType instanceof SmiSnmpTextualConventionMacroType) {
            SmiSnmpTextualConventionMacroType textualConvention = (SmiSnmpTextualConventionMacroType) smiType;
            SmiSnmpDescrPart descrPart = textualConvention.getSnmpDescrPart();
            SmiSnmpSyntaxPart syntaxPart = textualConvention.getSnmpSyntaxPart();

            description = descrPart.getStringLiteral().getText();
            syntax = syntaxPart.getType();
        } else if (smiType instanceof SmiBuiltinType) {
            SmiBuiltinType builtinType = (SmiBuiltinType) smiType;
            type = "Builtin type";
            syntax = builtinType.getTypeList().stream().findFirst()
                    .orElse(builtinType);
        }

        return generateDocumentation(type, element.getName(), null, description, syntax, Collections.emptyList());
    }

    @NotNull
    private String generateDocMibNode(SmiMibNodeMixin element) {
        SmiType smiType = element.getParentAssignment().getType();

        SnmpOid oid = element.getOid();

        String description = null;
        SmiType syntax = null;
        List<SmiValue> objects = Collections.emptyList();
        String type = smiType.getFirstChild().getText();

        if (smiType instanceof SmiDefinedMacroType) {
            SmiDefinedMacroType definedMacroType = (SmiDefinedMacroType) smiType;
            SmiSnmpDescrPart descrPart = definedMacroType.getDescriptionPart();
            SmiSnmpSyntaxPart syntaxPart = definedMacroType.getSyntaxPart();
            if (descrPart != null) {
                description = descrPart.getStringLiteral().getText();
            }
            if (syntaxPart != null) {
                syntax = syntaxPart.getType();
            }
            objects = getObjects(smiType);
        }

        return generateDocumentation(type, element.getName(), oid, description, syntax, objects);
    }

    private List<SmiValue> getObjects(SmiType smiType) {
        if (smiType instanceof SmiSnmpNotificationTypeMacroType) {
            SmiSnmpNotificationTypeMacroType notification = (SmiSnmpNotificationTypeMacroType) smiType;
            SmiSnmpObjectsPart objectsPart = notification.getSnmpObjectsPart();
            if (objectsPart != null) {
                return objectsPart.getValueList().getValueList();
            }
        } else if (smiType instanceof SmiSnmpTrapTypeMacroType) {
            SmiSnmpTrapTypeMacroType trap = (SmiSnmpTrapTypeMacroType) smiType;
            SmiSnmpVarPart varPart = trap.getSnmpVarPart();
            if (varPart != null) {
                return varPart.getValueList().getValueList();
            }
        } else if (smiType instanceof SmiSnmpObjectGroupMacroType) {
            SmiSnmpObjectGroupMacroType objectGroup = (SmiSnmpObjectGroupMacroType) smiType;
            SmiSnmpObjectsPart objectsPart = objectGroup.getSnmpObjectsPart();
            return objectsPart.getValueList().getValueList();
        }
        return Collections.emptyList();
    }

    @Override
    public PsiElement getDocumentationElementForLink(PsiManager psiManager, String link, PsiElement context) {
        if (!(context instanceof SmiIdentifiableElement)) {
            return null;
        }
        String[] split = link.split("#", 2);
        LinkType linkType = LinkType.valueOf(split[0]);
        String ref = split[1];
        Project project = context.getProject();
        GlobalSearchScope scope = ReferenceUtil.getScope(context);
        switch (linkType) {
            case SYNTAX:
                Collection<SmiTypeName> typeNames = TextualConventionIndex.getInstance().get(ref, project, scope);
                return Arrays.stream(ReferenceUtil.mapToResult(typeNames, context))
                        .map(ResolveResult::getElement)
                        .findFirst().orElse(null);
            case OBJECT:
                Collection<SmiMibNodeMixin> smiMibNodeMixins = MibNodeNameIndex.getInstance().get(ref, project, scope);
                return Arrays.stream(ReferenceUtil.mapToResult(smiMibNodeMixins, context))
                        .map(ResolveResult::getElement)
                        .findFirst().orElse(null);
        }
        return null;
    }

    private String generateDocumentation(String type, String name, SnmpOid oid, String description, SmiType syntax, List<SmiValue> objects) {
        StringBuilder builder = new StringBuilder();

        builder.append(DocumentationMarkup.DEFINITION_START);
        if (type != null) {
            builder.append(type);
            builder.append(" ");
        }
        builder.append("<b>").append(name).append("</b>");
        builder.append(DocumentationMarkup.DEFINITION_END);

        if (oid != null) {
            builder.append(DocumentationMarkup.DEFINITION_START);
            builder.append(oid);
            builder.append(DocumentationMarkup.DEFINITION_END);
        }

        if (description != null) {
            if (description.startsWith("\"") && description.endsWith("\"")) {
                description = description.substring(1, description.length() - 1);
            }
            builder.append(DocumentationMarkup.CONTENT_START);
            builder.append(description);
            builder.append(DocumentationMarkup.CONTENT_END);
        }

        if (syntax != null || !objects.isEmpty()) {
            builder.append(DocumentationMarkup.SECTIONS_START);
            if (syntax != null) {
                String syntaxText = trimComments(syntax.getText());
                builder.append(DocumentationMarkup.SECTION_HEADER_START).append("Syntax");
                builder.append(DocumentationMarkup.SECTION_SEPARATOR);
                builder.append("<p style=\"font-family: monospace;\">");
                if (syntax instanceof SmiDefinedType) {
                    SmiDefinedType definedType = (SmiDefinedType) syntax;
                    String definedTypeName = definedType.getDefinedTypeName().getName();
                    builder.append(buildHyperlink(definedTypeName, syntaxText, LinkType.SYNTAX));
                } else {
                    builder.append(syntaxText);
                }
                builder.append(DocumentationMarkup.SECTION_END);
            }
            if (!objects.isEmpty()) {
                builder.append(DocumentationMarkup.SECTION_HEADER_START).append("Objects");
                builder.append(DocumentationMarkup.SECTION_SEPARATOR);
                builder.append("<p style=\"font-family: monospace;\">");
                String objectsString = objects.stream().filter(smiValue -> smiValue instanceof SmiDefinedValueName)
                        .map(smiValue -> (SmiDefinedValueName) smiValue)
                        .map(valueName -> buildHyperlink(valueName.getName(), valueName.getName(), LinkType.OBJECT))
                        .collect(Collectors.joining(", "));
                builder.append(objectsString);
                builder.append(DocumentationMarkup.SECTION_END);
            }
            builder.append(DocumentationMarkup.SECTIONS_END);
        }

        return builder.toString();
    }

    private String trimComments(String syntax) {
        String[] split = syntax.split("\n");
        return Arrays.stream(split).map(line -> {
            int index = line.indexOf("--");
            if (index != -1) {
                line = line.substring(0, index - 1);
            }
            return line;
        }).collect(Collectors.joining("\n"));
    }

    private String buildHyperlink(String definedTypeName, String text, LinkType linkType) {
        StringBuilder builder = new StringBuilder();
        DocumentationManager.createHyperlink(builder, linkType + "#" + definedTypeName, definedTypeName, false);
        String link = builder.toString();

        return text.replace(definedTypeName, link);
    }

    private enum LinkType {
        SYNTAX, OBJECT
    }
}
