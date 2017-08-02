package pl.jakubchmura.snmp.mib;

import com.intellij.lang.refactoring.NamesValidator;
import com.intellij.openapi.project.Project;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.psi.SmiTokenSet;

import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SmiNamesValidator implements NamesValidator {

    public static final Pattern IDENTIFIER_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

    @Override
    public boolean isKeyword(@NotNull String name, Project project) {
        IElementType[] types = SmiTokenSet.KEYWORDS.getTypes();
        Set<String> typeStrings = Stream.of(types).map(IElementType::toString).collect(Collectors.toSet());
        return typeStrings.contains(name);
    }

    @Override
    public boolean isIdentifier(@NotNull String name, Project project) {
        return IDENTIFIER_PATTERN.matcher(name).matches();
    }
}
