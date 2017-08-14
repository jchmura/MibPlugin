// This is a generated file. Not intended for manual editing.
package pl.jakubchmura.snmp.mib.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import pl.jakubchmura.snmp.mib.reference.SmiReference;

public interface SmiModuleIdentifier extends SmiIdentifiableElement {

  @NotNull
  List<SmiNameAndNumber> getNameAndNumberList();

  @NotNull
  List<SmiNameValueIndex> getNameValueIndexList();

  @NotNull
  List<SmiNameValueString> getNameValueStringList();

  @NotNull
  PsiElement getIdentifierString();

  @NotNull
  String getName();

  PsiElement setName(String name);

  SmiReference getReference();

}
