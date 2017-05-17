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

public class SmiDefinedTypeImpl extends ASTWrapperPsiElement implements SmiDefinedType {

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

}
