package pl.jakubchmura.snmp.mib.psi;

import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.util.Processor;
import org.jetbrains.annotations.NotNull;

public abstract class SmiStubIndex<T extends SmiIdentifiableElement> extends StringStubIndexExtension<T> {

    public abstract void processAllKeys(@NotNull Processor<String> processor, @NotNull GlobalSearchScope scope);

}
