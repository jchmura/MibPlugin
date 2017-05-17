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

public class SmiTypeImpl extends ASTWrapperPsiElement implements SmiType {

  public SmiTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmiVisitor visitor) {
    visitor.visitType(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmiVisitor) accept((SmiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SmiBuiltinType getBuiltinType() {
    return findChildByClass(SmiBuiltinType.class);
  }

  @Override
  @Nullable
  public SmiDefinedType getDefinedType() {
    return findChildByClass(SmiDefinedType.class);
  }

}
