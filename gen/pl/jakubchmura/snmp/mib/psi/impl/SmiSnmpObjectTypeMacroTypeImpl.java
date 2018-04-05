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

public class SmiSnmpObjectTypeMacroTypeImpl extends SmiDefinedMacroTypeImpl implements SmiSnmpObjectTypeMacroType {

  public SmiSnmpObjectTypeMacroTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmiVisitor visitor) {
    visitor.visitSnmpObjectTypeMacroType(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmiVisitor) accept((SmiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SmiSnmpDefValPart getSnmpDefValPart() {
    return PsiTreeUtil.getChildOfType(this, SmiSnmpDefValPart.class);
  }

  @Override
  @Nullable
  public SmiSnmpDescrPart getSnmpDescrPart() {
    return PsiTreeUtil.getChildOfType(this, SmiSnmpDescrPart.class);
  }

  @Override
  @Nullable
  public SmiSnmpIndexPart getSnmpIndexPart() {
    return PsiTreeUtil.getChildOfType(this, SmiSnmpIndexPart.class);
  }

  @Override
  @NotNull
  public SmiSnmpSyntaxPart getSnmpSyntaxPart() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, SmiSnmpSyntaxPart.class));
  }

}
