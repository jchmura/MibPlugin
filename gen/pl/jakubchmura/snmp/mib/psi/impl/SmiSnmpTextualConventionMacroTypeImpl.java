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

public class SmiSnmpTextualConventionMacroTypeImpl extends SmiDefinedMacroTypeImpl implements SmiSnmpTextualConventionMacroType {

  public SmiSnmpTextualConventionMacroTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmiVisitor visitor) {
    visitor.visitSnmpTextualConventionMacroType(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmiVisitor) accept((SmiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SmiSnmpDescrPart getSnmpDescrPart() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, SmiSnmpDescrPart.class));
  }

  @Override
  @NotNull
  public SmiSnmpSyntaxPart getSnmpSyntaxPart() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, SmiSnmpSyntaxPart.class));
  }

  @Override
  @NotNull
  public PsiElement getIdentifierString() {
    return notNullChild(findChildByType(IDENTIFIER_STRING));
  }

}
