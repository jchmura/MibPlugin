// This is a generated file. Not intended for manual editing.
package pl.jakubchmura.snmp.mib.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static pl.jakubchmura.snmp.mib.psi.SmiTypes.*;
import pl.jakubchmura.snmp.mib.psi.*;

public class SmiSnmpAgentCapabilitiesMacroTypeImpl extends SmiDefinedMacroTypeImpl implements SmiSnmpAgentCapabilitiesMacroType {

  public SmiSnmpAgentCapabilitiesMacroTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SmiVisitor visitor) {
    visitor.visitSnmpAgentCapabilitiesMacroType(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SmiVisitor) accept((SmiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SmiModuleIdentifier> getModuleIdentifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmiModuleIdentifier.class);
  }

  @Override
  @NotNull
  public List<SmiSnmpDefValPart> getSnmpDefValPartList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmiSnmpDefValPart.class);
  }

  @Override
  @NotNull
  public List<SmiSnmpDescrPart> getSnmpDescrPartList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmiSnmpDescrPart.class);
  }

  @Override
  @NotNull
  public List<SmiSnmpSyntaxPart> getSnmpSyntaxPartList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmiSnmpSyntaxPart.class);
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
  @NotNull
  public List<SmiValueList> getValueListList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SmiValueList.class);
  }

}
