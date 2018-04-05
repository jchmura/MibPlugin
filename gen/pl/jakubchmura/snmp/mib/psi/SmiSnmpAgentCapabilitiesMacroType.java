// This is a generated file. Not intended for manual editing.
package pl.jakubchmura.snmp.mib.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SmiSnmpAgentCapabilitiesMacroType extends SmiDefinedMacroType {

  @NotNull
  List<SmiModuleIdentifier> getModuleIdentifierList();

  @NotNull
  List<SmiSnmpDefValPart> getSnmpDefValPartList();

  @NotNull
  List<SmiSnmpDescrPart> getSnmpDescrPartList();

  @NotNull
  List<SmiSnmpSyntaxPart> getSnmpSyntaxPartList();

  @NotNull
  List<SmiType> getTypeList();

  @NotNull
  List<SmiValue> getValueList();

  @NotNull
  List<SmiValueList> getValueListList();

}
