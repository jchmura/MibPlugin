package pl.jakubchmura.snmp.mib.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.psi.stubs.StubIndexKey;
import com.intellij.util.Processor;
import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;

import java.util.Collection;

public class MibNodeNameIndex extends SmiStubIndex<SmiMibNodeMixin> {

    public static final StubIndexKey<String, SmiMibNodeMixin> KEY = StubIndexKey.createIndexKey("mib.mibnode.name");

    private static final MibNodeNameIndex ourInstance = new MibNodeNameIndex();

    public static MibNodeNameIndex getInstance() {
        return ourInstance;
    }

    @NotNull
    @Override
    public StubIndexKey<String, SmiMibNodeMixin> getKey() {
        return KEY;
    }

    @Override
    public Collection<SmiMibNodeMixin> get(@NotNull String s, @NotNull Project project, @NotNull GlobalSearchScope scope) {
        return StubIndex.getElements(getKey(), s, project, scope, SmiMibNodeMixin.class);
    }

    public void processAllKeys(@NotNull Processor<String> processor, @NotNull GlobalSearchScope scope) {
        StubIndex.getInstance().processAllKeys(getKey(), processor, scope, null);
    }
}
