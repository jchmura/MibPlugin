// This is a generated file. Not intended for manual editing.
package pl.jakubchmura.snmp.mib.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import pl.jakubchmura.snmp.mib.reference.TextualConventionReference;

public interface SmiDefinedTypeName extends SmiIdentifiableElement {

  @NotNull
  PsiElement getIdentifierString();

  String getName();

  PsiElement setName(String name);

  TextualConventionReference getReference();

}
