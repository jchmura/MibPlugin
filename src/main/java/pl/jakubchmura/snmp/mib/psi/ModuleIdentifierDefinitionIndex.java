package pl.jakubchmura.snmp.mib.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.psi.stubs.StubIndexKey;
import com.intellij.util.Processor;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class ModuleIdentifierDefinitionIndex extends SmiStubIndex<SmiModuleIdentifierDefinition> {

    public static final StubIndexKey<String, SmiModuleIdentifierDefinition> KEY = StubIndexKey.createIndexKey("mib.moduleIdentifierDefinition");

    private static final ModuleIdentifierDefinitionIndex ourInstance = new ModuleIdentifierDefinitionIndex();

    public static ModuleIdentifierDefinitionIndex getInstance() {
        return ourInstance;
    }

    @NotNull
    @Override
    public StubIndexKey<String, SmiModuleIdentifierDefinition> getKey() {
        return KEY;
    }

    @Override
    public Collection<SmiModuleIdentifierDefinition> get(@NotNull String s, @NotNull Project project, @NotNull GlobalSearchScope scope) {
        return StubIndex.getElements(getKey(), s, project, scope, SmiModuleIdentifierDefinition.class);
    }

    public void processAllKeys(@NotNull Processor<String> processor, @NotNull GlobalSearchScope scope) {
        StubIndex.getInstance().processAllKeys(getKey(), processor, scope, null);
    }
}
