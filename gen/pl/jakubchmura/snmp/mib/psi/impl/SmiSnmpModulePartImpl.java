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

public class SmiSnmpModulePartImpl extends ASTWrapperPsiElement implements SmiSnmpModulePart {

  public SmiSnmpModulePartImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmiVisitor visitor) {
    visitor.visitSnmpModulePart(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmiVisitor) accept((SmiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SmiSnmpCompliancePart> getSnmpCompliancePartList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmiSnmpCompliancePart.class);
  }

  @Override
  @Nullable
  public SmiSnmpMandatoryPart getSnmpMandatoryPart() {
    return findChildByClass(SmiSnmpMandatoryPart.class);
  }

  @Override
  @Nullable
  public SmiSnmpModuleImport getSnmpModuleImport() {
    return findChildByClass(SmiSnmpModuleImport.class);
  }

}
