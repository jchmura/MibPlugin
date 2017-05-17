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

public class SmiBuiltinTypeImpl extends ASTWrapperPsiElement implements SmiBuiltinType {

  public SmiBuiltinTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmiVisitor visitor) {
    visitor.visitBuiltinType(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmiVisitor) accept((SmiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SmiChoiceType getChoiceType() {
    return findChildByClass(SmiChoiceType.class);
  }

  @Override
  @NotNull
  public List<SmiElementTyp> getElementTypList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmiElementTyp.class);
  }

  @Override
  @NotNull
  public List<SmiNamedNumber> getNamedNumberList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmiNamedNumber.class);
  }

  @Override
  @NotNull
  public List<SmiType> getTypeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmiType.class);
  }

  @Override
  @NotNull
  public List<SmiValue> getValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmiValue.class);
  }

  @Override
  @Nullable
  public PsiElement getNumberLiteral() {
    return findChildByType(NUMBER_LITERAL);
  }

}
