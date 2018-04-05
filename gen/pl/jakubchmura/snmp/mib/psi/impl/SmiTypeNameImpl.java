// This is a generated file. Not intended for manual editing.
package pl.jakubchmura.snmp.mib.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static pl.jakubchmura.snmp.mib.psi.SmiTypes.*;
import com.intellij.extapi.psi.StubBasedPsiElementBase;
import pl.jakubchmura.snmp.mib.psi.TextualConventionStub;
import pl.jakubchmura.snmp.mib.psi.*;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.tree.IElementType;

public class SmiTypeNameImpl extends StubBasedPsiElementBase<TextualConventionStub> implements SmiTypeName {

  public SmiTypeNameImpl(TextualConventionStub stub, IStubElementType type) {
    super(stub, type);
  }

  public SmiTypeNameImpl(ASTNode node) {
    super(node);
  }

  public SmiTypeNameImpl(TextualConventionStub stub, IElementType type, ASTNode node) {
    super(stub, type, node);
  }

  public void accept(@NotNull SmiVisitor visitor) {
    visitor.visitTypeName(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmiVisitor) accept((SmiVisitor)visitor);
    else super.accept(visitor);
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

  public ItemPresentation getPresentation() {
    return SmiPsiImplUtil.getPresentation(this);
  }

  public SmiTypeAssignment getParentAssignment() {
    return SmiPsiImplUtil.getParentAssignment(this);
  }

}
