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
import pl.jakubchmura.snmp.mib.reference.MibNodeReference;

public class SmiElementTypeNameImpl extends ASTWrapperPsiElement implements SmiElementTypeName {

  public SmiElementTypeNameImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmiVisitor visitor) {
    visitor.visitElementTypeName(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmiVisitor) accept((SmiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getIdentifierString() {
    return findNotNullChildByType(IDENTIFIER_STRING);
  }

  public String getName() {
    return SmiPsiImplUtil.getName(this);
  }

  public PsiElement setName(String name) {
    return SmiPsiImplUtil.setName(this, name);
  }

  public MibNodeReference getReference() {
    return SmiPsiImplUtil.getReference(this);
  }

  public boolean shouldHaveReference() {
    return SmiPsiImplUtil.shouldHaveReference(this);
  }

}
