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

public class SmiMacroBodyImpl extends ASTWrapperPsiElement implements SmiMacroBody {

  public SmiMacroBodyImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmiVisitor visitor) {
    visitor.visitMacroBody(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmiVisitor) accept((SmiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SmiMacroBodyElement> getMacroBodyElementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmiMacroBodyElement.class);
  }

  @Override
  @Nullable
  public SmiMacroReference getMacroReference() {
    return findChildByClass(SmiMacroReference.class);
  }

  @Override
  @Nullable
  public PsiElement getIdentifierString() {
    return findChildByType(IDENTIFIER_STRING);
  }

}
