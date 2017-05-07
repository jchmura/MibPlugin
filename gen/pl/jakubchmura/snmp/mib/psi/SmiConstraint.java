// This is a generated file. Not intended for manual editing.
package pl.jakubchmura.snmp.mib.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SmiConstraint extends PsiElement {

  @Nullable
  SmiAlphabetConstraint getAlphabetConstraint();

  @Nullable
  SmiContainedTypeConstraint getContainedTypeConstraint();

  @Nullable
  SmiInnerTypeConstraint getInnerTypeConstraint();

  @Nullable
  SmiSizeConstraint getSizeConstraint();

  @Nullable
  SmiValueConstraint getValueConstraint();

}
