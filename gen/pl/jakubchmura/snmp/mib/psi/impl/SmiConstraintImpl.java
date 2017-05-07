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

public class SmiConstraintImpl extends ASTWrapperPsiElement implements SmiConstraint {

  public SmiConstraintImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmiVisitor visitor) {
    visitor.visitConstraint(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmiVisitor) accept((SmiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SmiAlphabetConstraint getAlphabetConstraint() {
    return findChildByClass(SmiAlphabetConstraint.class);
  }

  @Override
  @Nullable
  public SmiContainedTypeConstraint getContainedTypeConstraint() {
    return findChildByClass(SmiContainedTypeConstraint.class);
  }

  @Override
  @Nullable
  public SmiInnerTypeConstraint getInnerTypeConstraint() {
    return findChildByClass(SmiInnerTypeConstraint.class);
  }

  @Override
  @Nullable
  public SmiSizeConstraint getSizeConstraint() {
    return findChildByClass(SmiSizeConstraint.class);
  }

  @Override
  @Nullable
  public SmiValueConstraint getValueConstraint() {
    return findChildByClass(SmiValueConstraint.class);
  }

}
