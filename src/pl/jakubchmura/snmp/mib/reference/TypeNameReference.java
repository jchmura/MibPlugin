package pl.jakubchmura.snmp.mib.reference;

import org.jetbrains.annotations.NotNull;
import pl.jakubchmura.snmp.mib.psi.SmiIdentifiableElement;
import pl.jakubchmura.snmp.mib.psi.SmiTypeName;

public class TypeNameReference extends ReferenceableElementReference<SmiTypeName> {

    public TypeNameReference(@NotNull SmiIdentifiableElement element) {
        super(element, SmiTypeName.class);
    }
}
