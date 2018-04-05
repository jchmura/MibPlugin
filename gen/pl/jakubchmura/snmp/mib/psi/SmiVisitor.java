// This is a generated file. Not intended for manual editing.
package pl.jakubchmura.snmp.mib.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class SmiVisitor extends PsiElementVisitor {

  public void visitAssignment(@NotNull SmiAssignment o) {
    visitPsiElement(o);
  }

  public void visitBitOrObjectIdentifierValue(@NotNull SmiBitOrObjectIdentifierValue o) {
    visitBuiltinValue(o);
  }

  public void visitBuiltinType(@NotNull SmiBuiltinType o) {
    visitType(o);
  }

  public void visitBuiltinValue(@NotNull SmiBuiltinValue o) {
    visitValue(o);
  }

  public void visitChoiceType(@NotNull SmiChoiceType o) {
    visitBuiltinType(o);
  }

  public void visitDefinedMacroType(@NotNull SmiDefinedMacroType o) {
    visitType(o);
  }

  public void visitDefinedType(@NotNull SmiDefinedType o) {
    visitType(o);
  }

  public void visitDefinedTypeName(@NotNull SmiDefinedTypeName o) {
    visitIdentifiableElement(o);
  }

  public void visitDefinedValueName(@NotNull SmiDefinedValueName o) {
    visitValue(o);
    // visitIdentifiableElement(o);
    // visitReferenceResolver(o);
  }

  public void visitElementTyp(@NotNull SmiElementTyp o) {
    visitPsiElement(o);
  }

  public void visitElementTypeName(@NotNull SmiElementTypeName o) {
    visitReferenceResolver(o);
  }

  public void visitExportList(@NotNull SmiExportList o) {
    visitPsiElement(o);
  }

  public void visitImportList(@NotNull SmiImportList o) {
    visitPsiElement(o);
  }

  public void visitIndexType(@NotNull SmiIndexType o) {
    visitPsiElement(o);
  }

  public void visitIndexValue(@NotNull SmiIndexValue o) {
    visitPsiElement(o);
  }

  public void visitMibNode(@NotNull SmiMibNode o) {
    visitPsiElement(o);
  }

  public void visitModuleDefinition(@NotNull SmiModuleDefinition o) {
    visitPsiElement(o);
  }

  public void visitModuleIdentifier(@NotNull SmiModuleIdentifier o) {
    visitIdentifiableElement(o);
  }

  public void visitModuleIdentifierDefinition(@NotNull SmiModuleIdentifierDefinition o) {
    visitReferenceableElement(o);
  }

  public void visitNameAndNumber(@NotNull SmiNameAndNumber o) {
    visitPsiElement(o);
  }

  public void visitNameValueIndex(@NotNull SmiNameValueIndex o) {
    visitPsiElement(o);
  }

  public void visitNameValueString(@NotNull SmiNameValueString o) {
    visitIdentifiableElement(o);
  }

  public void visitNamedNumber(@NotNull SmiNamedNumber o) {
    visitPsiElement(o);
  }

  public void visitNumber(@NotNull SmiNumber o) {
    visitPsiElement(o);
  }

  public void visitSequenceOfType(@NotNull SmiSequenceOfType o) {
    visitBuiltinType(o);
  }

  public void visitSequenceType(@NotNull SmiSequenceType o) {
    visitBuiltinType(o);
  }

  public void visitSnmpAgentCapabilitiesMacroType(@NotNull SmiSnmpAgentCapabilitiesMacroType o) {
    visitDefinedMacroType(o);
  }

  public void visitSnmpDefValPart(@NotNull SmiSnmpDefValPart o) {
    visitPsiElement(o);
  }

  public void visitSnmpDescrPart(@NotNull SmiSnmpDescrPart o) {
    visitPsiElement(o);
  }

  public void visitSnmpEnterprisePart(@NotNull SmiSnmpEnterprisePart o) {
    visitPsiElement(o);
  }

  public void visitSnmpIndexPart(@NotNull SmiSnmpIndexPart o) {
    visitPsiElement(o);
  }

  public void visitSnmpModuleComplianceMacroType(@NotNull SmiSnmpModuleComplianceMacroType o) {
    visitDefinedMacroType(o);
  }

  public void visitSnmpModuleIdentityMacroType(@NotNull SmiSnmpModuleIdentityMacroType o) {
    visitDefinedMacroType(o);
  }

  public void visitSnmpNotificationGroupMacroType(@NotNull SmiSnmpNotificationGroupMacroType o) {
    visitDefinedMacroType(o);
  }

  public void visitSnmpNotificationTypeMacroType(@NotNull SmiSnmpNotificationTypeMacroType o) {
    visitDefinedMacroType(o);
  }

  public void visitSnmpObjectGroupMacroType(@NotNull SmiSnmpObjectGroupMacroType o) {
    visitDefinedMacroType(o);
  }

  public void visitSnmpObjectIdentityMacroType(@NotNull SmiSnmpObjectIdentityMacroType o) {
    visitDefinedMacroType(o);
  }

  public void visitSnmpObjectTypeMacroType(@NotNull SmiSnmpObjectTypeMacroType o) {
    visitDefinedMacroType(o);
  }

  public void visitSnmpObjectsPart(@NotNull SmiSnmpObjectsPart o) {
    visitPsiElement(o);
  }

  public void visitSnmpSyntaxPart(@NotNull SmiSnmpSyntaxPart o) {
    visitPsiElement(o);
  }

  public void visitSnmpTextualConventionMacroType(@NotNull SmiSnmpTextualConventionMacroType o) {
    visitDefinedMacroType(o);
  }

  public void visitSnmpTrapTypeMacroType(@NotNull SmiSnmpTrapTypeMacroType o) {
    visitDefinedMacroType(o);
  }

  public void visitSnmpVarPart(@NotNull SmiSnmpVarPart o) {
    visitPsiElement(o);
  }

  public void visitSymbol(@NotNull SmiSymbol o) {
    visitPsiElement(o);
  }

  public void visitSymbolName(@NotNull SmiSymbolName o) {
    visitIdentifiableElement(o);
  }

  public void visitSymbolsFromModule(@NotNull SmiSymbolsFromModule o) {
    visitPsiElement(o);
  }

  public void visitType(@NotNull SmiType o) {
    visitPsiElement(o);
  }

  public void visitTypeAssignment(@NotNull SmiTypeAssignment o) {
    visitAssignment(o);
  }

  public void visitTypeName(@NotNull SmiTypeName o) {
    visitReferenceableElement(o);
  }

  public void visitValue(@NotNull SmiValue o) {
    visitPsiElement(o);
  }

  public void visitValueAssignment(@NotNull SmiValueAssignment o) {
    visitAssignment(o);
  }

  public void visitValueList(@NotNull SmiValueList o) {
    visitPsiElement(o);
  }

  public void visitIdentifiableElement(@NotNull SmiIdentifiableElement o) {
    visitPsiElement(o);
  }

  public void visitReferenceResolver(@NotNull SmiReferenceResolver o) {
    visitPsiElement(o);
  }

  public void visitReferenceableElement(@NotNull SmiReferenceableElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
