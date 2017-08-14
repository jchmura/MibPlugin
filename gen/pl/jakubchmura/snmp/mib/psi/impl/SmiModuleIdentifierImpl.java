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
import pl.jakubchmura.snmp.mib.reference.SmiReference;

public class SmiModuleIdentifierImpl extends ASTWrapperPsiElement implements SmiModuleIdentifier {

  public SmiModuleIdentifierImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmiVisitor visitor) {
    visitor.visitModuleIdentifier(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmiVisitor) accept((SmiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SmiNameAndNumber> getNameAndNumberList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmiNameAndNumber.class);
  }

  @Override
  @NotNull
  public List<SmiNameValueIndex> getNameValueIndexList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmiNameValueIndex.class);
  }

  @Override
  @NotNull
  public List<SmiNameValueString> getNameValueStringList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmiNameValueString.class);
  }

  @Override
  @NotNull
  public PsiElement getIdentifierString() {
    return notNullChild(findChildByType(IDENTIFIER_STRING));
  }

  @NotNull
  public String getName() {
    return SmiPsiImplUtil.getName(this);
  }

  public PsiElement setName(String name) {
    return SmiPsiImplUtil.setName(this, name);
  }

  public SmiReference getReference() {
    return SmiPsiImplUtil.getReference(this);
  }

}
