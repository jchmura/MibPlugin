package pl.jakubchmura.snmp.mib.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.psi.stubs.StubIndexKey;
import com.intellij.util.Processor;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class TextualConventionIndex extends SmiStubIndex<SmiTypeName> {

    public static final StubIndexKey<String, SmiTypeName> KEY = StubIndexKey.createIndexKey("mib.textualConvention");

    private static final TextualConventionIndex ourInstance = new TextualConventionIndex();

    public static TextualConventionIndex getInstance() {
        return ourInstance;
    }

    @NotNull
    @Override
    public StubIndexKey<String, SmiTypeName> getKey() {
        return KEY;
    }

    @Override
    public Collection<SmiTypeName> get(@NotNull String s, @NotNull Project project, @NotNull GlobalSearchScope scope) {
        return StubIndex.getElements(getKey(), s, project, scope, SmiTypeName.class);
    }

    public void processAllKeys(@NotNull Processor<String> processor, @NotNull GlobalSearchScope scope) {
        StubIndex.getInstance().processAllKeys(getKey(), processor, scope, null);
    }
}
