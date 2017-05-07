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

public class SmiSequenceOfTypeImpl extends SmiBuiltinTypeImpl implements SmiSequenceOfType {

  public SmiSequenceOfTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmiVisitor visitor) {
    visitor.visitSequenceOfType(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmiVisitor) accept((SmiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SmiConstraint> getConstraintList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmiConstraint.class);
  }

  @Override
  @NotNull
  public SmiType getType() {
    return findNotNullChildByClass(SmiType.class);
  }

}
