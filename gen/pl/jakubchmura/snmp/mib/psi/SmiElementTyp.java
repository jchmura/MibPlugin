// This is a generated file. Not intended for manual editing.
package pl.jakubchmura.snmp.mib.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SmiElementTyp extends PsiElement {

  @Nullable
  SmiElementTypeName getElementTypeName();

  @NotNull
  SmiType getType();

  @Nullable
  SmiValue getValue();

  @Nullable
  PsiElement getIdentifierString();

}
