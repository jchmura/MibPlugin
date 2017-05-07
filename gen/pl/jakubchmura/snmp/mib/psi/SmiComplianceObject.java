// This is a generated file. Not intended for manual editing.
package pl.jakubchmura.snmp.mib.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SmiComplianceObject extends PsiElement {

  @Nullable
  SmiSnmpAccessPart getSnmpAccessPart();

  @NotNull
  SmiSnmpDescrPart getSnmpDescrPart();

  @Nullable
  SmiSnmpSyntaxPart getSnmpSyntaxPart();

  @Nullable
  SmiSnmpWriteSyntaxPart getSnmpWriteSyntaxPart();

  @NotNull
  SmiValue getValue();

}
