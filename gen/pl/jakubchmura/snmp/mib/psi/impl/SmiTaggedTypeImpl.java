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

public class SmiTaggedTypeImpl extends SmiBuiltinTypeImpl implements SmiTaggedType {

  public SmiTaggedTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmiVisitor visitor) {
    visitor.visitTaggedType(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmiVisitor) accept((SmiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SmiExplicitOrImplicitTag getExplicitOrImplicitTag() {
    return findChildByClass(SmiExplicitOrImplicitTag.class);
  }

  @Override
  @NotNull
  public SmiTag getTag() {
    return findNotNullChildByClass(SmiTag.class);
  }

  @Override
  @NotNull
  public SmiType getType() {
    return findNotNullChildByClass(SmiType.class);
  }

}
