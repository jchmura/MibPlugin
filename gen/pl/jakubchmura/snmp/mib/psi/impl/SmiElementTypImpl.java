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

public class SmiElementTypImpl extends ASTWrapperPsiElement implements SmiElementTyp {

  public SmiElementTypImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmiVisitor visitor) {
    visitor.visitElementTyp(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmiVisitor) accept((SmiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SmiElementTypeName getElementTypeName() {
    return PsiTreeUtil.getChildOfType(this, SmiElementTypeName.class);
  }

  @Override
  @NotNull
  public SmiType getType() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, SmiType.class));
  }

  @Override
  @Nullable
  public SmiValue getValue() {
    return PsiTreeUtil.getChildOfType(this, SmiValue.class);
  }

  @Override
  @Nullable
  public PsiElement getIdentifierString() {
    return findChildByType(IDENTIFIER_STRING);
  }

}
