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

public class SmiSymbolsFromModuleImpl extends ASTWrapperPsiElement implements SmiSymbolsFromModule {

  public SmiSymbolsFromModuleImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmiVisitor visitor) {
    visitor.visitSymbolsFromModule(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmiVisitor) accept((SmiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SmiModuleIdentifier getModuleIdentifier() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, SmiModuleIdentifier.class));
  }

  @Override
  @NotNull
  public List<SmiSymbol> getSymbolList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmiSymbol.class);
  }

}
