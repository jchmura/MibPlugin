// This is a generated file. Not intended for manual editing.
package pl.jakubchmura.snmp.mib.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SmiSnmpModuleSupportPart extends PsiElement {

  @NotNull
  SmiSnmpModuleImport getSnmpModuleImport();

  @NotNull
  List<SmiSnmpVariationPart> getSnmpVariationPartList();

  @NotNull
  List<SmiValue> getValueList();

}
