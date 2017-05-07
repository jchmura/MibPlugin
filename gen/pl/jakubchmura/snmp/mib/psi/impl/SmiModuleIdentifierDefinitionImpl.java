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

public class SmiModuleIdentifierDefinitionImpl extends ASTWrapperPsiElement implements SmiModuleIdentifierDefinition {

  public SmiModuleIdentifierDefinitionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmiVisitor visitor) {
    visitor.visitModuleIdentifierDefinition(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmiVisitor) accept((SmiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SmiObjectIdentifierValue getObjectIdentifierValue() {
    return findChildByClass(SmiObjectIdentifierValue.class);
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

}
