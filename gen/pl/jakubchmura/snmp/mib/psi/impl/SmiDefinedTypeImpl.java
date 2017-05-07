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

public class SmiDefinedTypeImpl extends SmiTypeImpl implements SmiDefinedType {

  public SmiDefinedTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmiVisitor visitor) {
    visitor.visitDefinedType(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmiVisitor) accept((SmiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SmiDefinedTypeName getDefinedTypeName() {
    return findNotNullChildByClass(SmiDefinedTypeName.class);
  }

  @Override
  @Nullable
  public SmiValueOrConstraintList getValueOrConstraintList() {
    return findChildByClass(SmiValueOrConstraintList.class);
  }

  @Override
  @Nullable
  public PsiElement getIdentifierString() {
    return findChildByType(IDENTIFIER_STRING);
  }

}
