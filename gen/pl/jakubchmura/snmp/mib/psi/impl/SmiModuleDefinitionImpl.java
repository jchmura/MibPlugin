// This is a generated file. Not intended for manual editing.
package pl.jakubchmura.snmp.mib.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static pl.jakubchmura.snmp.mib.psi.SmiTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import pl.jakubchmura.snmp.mib.psi.*;

public class SmiModuleDefinitionImpl extends ASTWrapperPsiElement implements SmiModuleDefinition {

  public SmiModuleDefinitionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmiVisitor visitor) {
    visitor.visitModuleDefinition(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmiVisitor) accept((SmiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SmiAssignment> getAssignmentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmiAssignment.class);
  }

  @Override
  @Nullable
  public SmiExportList getExportList() {
    return PsiTreeUtil.getChildOfType(this, SmiExportList.class);
  }

  @Override
  @Nullable
  public SmiImportList getImportList() {
    return PsiTreeUtil.getChildOfType(this, SmiImportList.class);
  }

  @Override
  @NotNull
  public SmiModuleIdentifierDefinition getModuleIdentifierDefinition() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, SmiModuleIdentifierDefinition.class));
  }

  public List<SmiMibNodeMixin> getMibNodes() {
    return SmiPsiImplUtil.getMibNodes(this);
  }

  public List<SmiTypeName> getTextualConventions() {
    return SmiPsiImplUtil.getTextualConventions(this);
  }

}
