// This is a generated file. Not intended for manual editing.
package pl.jakubchmura.snmp.mib.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface SmiModuleIdentifierDefinition extends SmiReferenceableElement {

  @NotNull
  List<SmiNameAndNumber> getNameAndNumberList();

  @NotNull
  List<SmiNameValueIndex> getNameValueIndexList();

  @NotNull
  List<SmiNameValueString> getNameValueStringList();

  @NotNull
  PsiElement getIdentifierString();

  String getName();

  PsiElement setName(String name);

  ItemPresentation getPresentation();

}
