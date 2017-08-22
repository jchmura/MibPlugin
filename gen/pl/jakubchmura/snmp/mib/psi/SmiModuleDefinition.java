// This is a generated file. Not intended for manual editing.
package pl.jakubchmura.snmp.mib.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;

public interface SmiModuleDefinition extends PsiElement {

  @NotNull
  List<SmiAssignment> getAssignmentList();

  @Nullable
  SmiExportList getExportList();

  @Nullable
  SmiImportList getImportList();

  @NotNull
  SmiModuleIdentifierDefinition getModuleIdentifierDefinition();

  List<SmiMibNodeMixin> getMibNodes();

  List<SmiTypeName> getTextualConventions();

}
