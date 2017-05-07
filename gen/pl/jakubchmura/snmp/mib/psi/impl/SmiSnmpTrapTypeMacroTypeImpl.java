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

public class SmiSnmpTrapTypeMacroTypeImpl extends SmiDefinedMacroTypeImpl implements SmiSnmpTrapTypeMacroType {

  public SmiSnmpTrapTypeMacroTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmiVisitor visitor) {
    visitor.visitSnmpTrapTypeMacroType(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmiVisitor) accept((SmiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SmiSnmpDescrPart getSnmpDescrPart() {
    return findChildByClass(SmiSnmpDescrPart.class);
  }

  @Override
  @NotNull
  public SmiSnmpEnterprisePart getSnmpEnterprisePart() {
    return findNotNullChildByClass(SmiSnmpEnterprisePart.class);
  }

  @Override
  @Nullable
  public SmiSnmpReferPart getSnmpReferPart() {
    return findChildByClass(SmiSnmpReferPart.class);
  }

  @Override
  @Nullable
  public SmiSnmpVarPart getSnmpVarPart() {
    return findChildByClass(SmiSnmpVarPart.class);
  }

}
