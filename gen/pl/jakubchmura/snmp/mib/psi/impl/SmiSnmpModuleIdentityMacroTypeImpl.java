// This is a generated file. Not intended for manual editing.
package pl.jakubchmura.snmp.mib.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static pl.jakubchmura.snmp.mib.psi.SmiTypes.*;
import pl.jakubchmura.snmp.mib.psi.*;

public class SmiSnmpModuleIdentityMacroTypeImpl extends SmiDefinedMacroTypeImpl implements SmiSnmpModuleIdentityMacroType {

  public SmiSnmpModuleIdentityMacroTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmiVisitor visitor) {
    visitor.visitSnmpModuleIdentityMacroType(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmiVisitor) accept((SmiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SmiSnmpContactPart getSnmpContactPart() {
    return findNotNullChildByClass(SmiSnmpContactPart.class);
  }

  @Override
  @NotNull
  public SmiSnmpDescrPart getSnmpDescrPart() {
    return findNotNullChildByClass(SmiSnmpDescrPart.class);
  }

  @Override
  @NotNull
  public SmiSnmpOrganizationPart getSnmpOrganizationPart() {
    return findNotNullChildByClass(SmiSnmpOrganizationPart.class);
  }

  @Override
  @NotNull
  public List<SmiSnmpRevisionPart> getSnmpRevisionPartList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmiSnmpRevisionPart.class);
  }

  @Override
  @NotNull
  public SmiSnmpUpdatePart getSnmpUpdatePart() {
    return findNotNullChildByClass(SmiSnmpUpdatePart.class);
  }

}
