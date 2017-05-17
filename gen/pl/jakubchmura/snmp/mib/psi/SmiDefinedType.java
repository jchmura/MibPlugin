// This is a generated file. Not intended for manual editing.
package pl.jakubchmura.snmp.mib.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SmiDefinedType extends PsiElement {

  @NotNull
  SmiDefinedTypeName getDefinedTypeName();

  @NotNull
  List<SmiNamedNumber> getNamedNumberList();

  @NotNull
  List<SmiType> getTypeList();

  @NotNull
  List<SmiValue> getValueList();

}
