// This is a generated file. Not intended for manual editing.
package pl.jakubchmura.snmp.mib.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SmiSnmpAgentCapabilitiesMacroType extends SmiDefinedMacroType {

  @NotNull
  SmiSnmpDescrPart getSnmpDescrPart();

  @NotNull
  List<SmiSnmpModuleSupportPart> getSnmpModuleSupportPartList();

  @NotNull
  SmiSnmpProductReleasePart getSnmpProductReleasePart();

  @Nullable
  SmiSnmpReferPart getSnmpReferPart();

  @NotNull
  SmiSnmpStatusPart getSnmpStatusPart();

}
