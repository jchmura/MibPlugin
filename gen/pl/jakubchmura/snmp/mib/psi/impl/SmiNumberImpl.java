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

public class SmiNumberImpl extends ASTWrapperPsiElement implements SmiNumber {

  public SmiNumberImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmiVisitor visitor) {
    visitor.visitNumber(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmiVisitor) accept((SmiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SmiDefinedValueName getDefinedValueName() {
    return PsiTreeUtil.getChildOfType(this, SmiDefinedValueName.class);
  }

  @Override
  @Nullable
  public PsiElement getBinaryLiteral() {
    return findChildByType(BINARY_LITERAL);
  }

  @Override
  @Nullable
  public PsiElement getHexadecimalLiteral() {
    return findChildByType(HEXADECIMAL_LITERAL);
  }

  @Override
  @Nullable
  public PsiElement getIdentifierString() {
    return findChildByType(IDENTIFIER_STRING);
  }

  @Override
  @Nullable
  public PsiElement getNumberLiteral() {
    return findChildByType(NUMBER_LITERAL);
  }

}
