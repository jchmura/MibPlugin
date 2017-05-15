// This is a generated file. Not intended for manual editing.
package pl.jakubchmura.snmp.mib.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class SmiVisitor extends PsiElementVisitor {

  public void visitAlphabetConstraint(@NotNull SmiAlphabetConstraint o) {
    visitPsiElement(o);
  }

  public void visitAnyType(@NotNull SmiAnyType o) {
    visitBuiltinType(o);
  }

  public void visitAssignment(@NotNull SmiAssignment o) {
    visitPsiElement(o);
  }

  public void visitBinaryValue(@NotNull SmiBinaryValue o) {
    visitBuiltinValue(o);
  }

  public void visitBitOrObjectIdentifierValue(@NotNull SmiBitOrObjectIdentifierValue o) {
    visitBuiltinValue(o);
  }

  public void visitBitStringType(@NotNull SmiBitStringType o) {
    visitBuiltinType(o);
  }

  public void visitBitsType(@NotNull SmiBitsType o) {
    visitBuiltinType(o);
  }

  public void visitBooleanType(@NotNull SmiBooleanType o) {
    visitBuiltinType(o);
  }

  public void visitBooleanValue(@NotNull SmiBooleanValue o) {
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

  public void visitClassType(@NotNull SmiClassType o) {
    visitPsiElement(o);
  }

  public void visitComplianceGroup(@NotNull SmiComplianceGroup o) {
    visitPsiElement(o);
  }

  public void visitComplianceObject(@NotNull SmiComplianceObject o) {
    visitPsiElement(o);
  }

  public void visitComponentConstraint(@NotNull SmiComponentConstraint o) {
    visitPsiElement(o);
  }

  public void visitComponentPresence(@NotNull SmiComponentPresence o) {
    visitPsiElement(o);
  }

  public void visitComponentValuePresence(@NotNull SmiComponentValuePresence o) {
    visitPsiElement(o);
  }

  public void visitComponentsList(@NotNull SmiComponentsList o) {
    visitPsiElement(o);
  }

  public void visitComponentsListTail(@NotNull SmiComponentsListTail o) {
    visitPsiElement(o);
  }

  public void visitConstraint(@NotNull SmiConstraint o) {
    visitPsiElement(o);
  }

  public void visitContainedTypeConstraint(@NotNull SmiContainedTypeConstraint o) {
    visitPsiElement(o);
  }

  public void visitDefinedMacroName(@NotNull SmiDefinedMacroName o) {
    visitPsiElement(o);
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

  public void visitDefinedValue(@NotNull SmiDefinedValue o) {
    visitValue(o);
  }

  public void visitDefinedValueName(@NotNull SmiDefinedValueName o) {
    visitValue(o);
    // visitIdentifiableElement(o);
  }

  public void visitElementTyp(@NotNull SmiElementTyp o) {
    visitPsiElement(o);
  }

  public void visitElementTypeName(@NotNull SmiElementTypeName o) {
    visitReferenceResolver(o);
  }

  public void visitEnumeratedType(@NotNull SmiEnumeratedType o) {
    visitBuiltinType(o);
  }

  public void visitExplicitOrImplicitTag(@NotNull SmiExplicitOrImplicitTag o) {
    visitPsiElement(o);
  }

  public void visitExportList(@NotNull SmiExportList o) {
    visitPsiElement(o);
  }

  public void visitHexadecimalValue(@NotNull SmiHexadecimalValue o) {
    visitBuiltinValue(o);
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

  public void visitInnerTypeConstraint(@NotNull SmiInnerTypeConstraint o) {
    visitPsiElement(o);
  }

  public void visitIntegerType(@NotNull SmiIntegerType o) {
    visitBuiltinType(o);
  }

  public void visitLowerEndPoint(@NotNull SmiLowerEndPoint o) {
    visitPsiElement(o);
  }

  public void visitMacroBody(@NotNull SmiMacroBody o) {
    visitPsiElement(o);
  }

  public void visitMacroBodyElement(@NotNull SmiMacroBodyElement o) {
    visitPsiElement(o);
  }

  public void visitMacroDefinition(@NotNull SmiMacroDefinition o) {
    visitPsiElement(o);
  }

  public void visitMacroReference(@NotNull SmiMacroReference o) {
    visitPsiElement(o);
  }

  public void visitMibNode(@NotNull SmiMibNode o) {
    visitReferenceableElement(o);
  }

  public void visitModuleBody(@NotNull SmiModuleBody o) {
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

  public void visitNameValueString(@NotNull SmiNameValueString o) {
    visitIdentifiableElement(o);
  }

  public void visitNamedNumber(@NotNull SmiNamedNumber o) {
    visitPsiElement(o);
  }

  public void visitNullType(@NotNull SmiNullType o) {
    visitBuiltinType(o);
  }

  public void visitNullValue(@NotNull SmiNullValue o) {
    visitBuiltinValue(o);
  }

  public void visitNumber(@NotNull SmiNumber o) {
    visitPsiElement(o);
  }

  public void visitNumberValue(@NotNull SmiNumberValue o) {
    visitBuiltinValue(o);
  }

  public void visitObjectIdentifierType(@NotNull SmiObjectIdentifierType o) {
    visitBuiltinType(o);
  }

  public void visitObjectIdentifierValue(@NotNull SmiObjectIdentifierValue o) {
    visitPsiElement(o);
  }

  public void visitOptionalOrDefaultElement(@NotNull SmiOptionalOrDefaultElement o) {
    visitPsiElement(o);
  }

  public void visitRealType(@NotNull SmiRealType o) {
    visitBuiltinType(o);
  }

  public void visitSelectionType(@NotNull SmiSelectionType o) {
    visitBuiltinType(o);
  }

  public void visitSequenceOfType(@NotNull SmiSequenceOfType o) {
    visitBuiltinType(o);
  }

  public void visitSequenceType(@NotNull SmiSequenceType o) {
    visitBuiltinType(o);
  }

  public void visitSetOfType(@NotNull SmiSetOfType o) {
    visitBuiltinType(o);
  }

  public void visitSetType(@NotNull SmiSetType o) {
    visitBuiltinType(o);
  }

  public void visitSizeConstraint(@NotNull SmiSizeConstraint o) {
    visitPsiElement(o);
  }

  public void visitSnmpAccessPart(@NotNull SmiSnmpAccessPart o) {
    visitPsiElement(o);
  }

  public void visitSnmpAgentCapabilitiesMacroType(@NotNull SmiSnmpAgentCapabilitiesMacroType o) {
    visitDefinedMacroType(o);
  }

  public void visitSnmpCompliancePart(@NotNull SmiSnmpCompliancePart o) {
    visitPsiElement(o);
  }

  public void visitSnmpContactPart(@NotNull SmiSnmpContactPart o) {
    visitPsiElement(o);
  }

  public void visitSnmpCreationPart(@NotNull SmiSnmpCreationPart o) {
    visitPsiElement(o);
  }

  public void visitSnmpDefValPart(@NotNull SmiSnmpDefValPart o) {
    visitPsiElement(o);
  }

  public void visitSnmpDescrPart(@NotNull SmiSnmpDescrPart o) {
    visitPsiElement(o);
  }

  public void visitSnmpDisplayPart(@NotNull SmiSnmpDisplayPart o) {
    visitPsiElement(o);
  }

  public void visitSnmpEnterprisePart(@NotNull SmiSnmpEnterprisePart o) {
    visitPsiElement(o);
  }

  public void visitSnmpIndexPart(@NotNull SmiSnmpIndexPart o) {
    visitPsiElement(o);
  }

  public void visitSnmpMandatoryPart(@NotNull SmiSnmpMandatoryPart o) {
    visitPsiElement(o);
  }

  public void visitSnmpModuleComplianceMacroType(@NotNull SmiSnmpModuleComplianceMacroType o) {
    visitDefinedMacroType(o);
  }

  public void visitSnmpModuleIdentityMacroType(@NotNull SmiSnmpModuleIdentityMacroType o) {
    visitDefinedMacroType(o);
  }

  public void visitSnmpModuleImport(@NotNull SmiSnmpModuleImport o) {
    visitPsiElement(o);
  }

  public void visitSnmpModulePart(@NotNull SmiSnmpModulePart o) {
    visitPsiElement(o);
  }

  public void visitSnmpModuleSupportPart(@NotNull SmiSnmpModuleSupportPart o) {
    visitPsiElement(o);
  }

  public void visitSnmpNotificationGroupMacroType(@NotNull SmiSnmpNotificationGroupMacroType o) {
    visitDefinedMacroType(o);
  }

  public void visitSnmpNotificationTypeMacroType(@NotNull SmiSnmpNotificationTypeMacroType o) {
    visitDefinedMacroType(o);
  }

  public void visitSnmpNotificationsPart(@NotNull SmiSnmpNotificationsPart o) {
    visitPsiElement(o);
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

  public void visitSnmpOrganizationPart(@NotNull SmiSnmpOrganizationPart o) {
    visitPsiElement(o);
  }

  public void visitSnmpProductReleasePart(@NotNull SmiSnmpProductReleasePart o) {
    visitPsiElement(o);
  }

  public void visitSnmpReferPart(@NotNull SmiSnmpReferPart o) {
    visitPsiElement(o);
  }

  public void visitSnmpRevisionPart(@NotNull SmiSnmpRevisionPart o) {
    visitPsiElement(o);
  }

  public void visitSnmpStatusPart(@NotNull SmiSnmpStatusPart o) {
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

  public void visitSnmpUnitsPart(@NotNull SmiSnmpUnitsPart o) {
    visitPsiElement(o);
  }

  public void visitSnmpUpdatePart(@NotNull SmiSnmpUpdatePart o) {
    visitPsiElement(o);
  }

  public void visitSnmpVarPart(@NotNull SmiSnmpVarPart o) {
    visitPsiElement(o);
  }

  public void visitSnmpVariationPart(@NotNull SmiSnmpVariationPart o) {
    visitPsiElement(o);
  }

  public void visitSnmpWriteSyntaxPart(@NotNull SmiSnmpWriteSyntaxPart o) {
    visitPsiElement(o);
  }

  public void visitSpecialRealValue(@NotNull SmiSpecialRealValue o) {
    visitBuiltinValue(o);
  }

  public void visitStringType(@NotNull SmiStringType o) {
    visitBuiltinType(o);
  }

  public void visitStringValue(@NotNull SmiStringValue o) {
    visitBuiltinValue(o);
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

  public void visitTag(@NotNull SmiTag o) {
    visitPsiElement(o);
  }

  public void visitTagDefault(@NotNull SmiTagDefault o) {
    visitPsiElement(o);
  }

  public void visitTaggedType(@NotNull SmiTaggedType o) {
    visitBuiltinType(o);
  }

  public void visitType(@NotNull SmiType o) {
    visitPsiElement(o);
  }

  public void visitTypeAssignment(@NotNull SmiTypeAssignment o) {
    visitPsiElement(o);
  }

  public void visitTypeName(@NotNull SmiTypeName o) {
    visitReferenceableElement(o);
  }

  public void visitUpperEndPoint(@NotNull SmiUpperEndPoint o) {
    visitPsiElement(o);
  }

  public void visitValue(@NotNull SmiValue o) {
    visitPsiElement(o);
  }

  public void visitValueAssignment(@NotNull SmiValueAssignment o) {
    visitPsiElement(o);
  }

  public void visitValueConstraint(@NotNull SmiValueConstraint o) {
    visitPsiElement(o);
  }

  public void visitValueOrConstraintList(@NotNull SmiValueOrConstraintList o) {
    visitPsiElement(o);
  }

  public void visitValueRange(@NotNull SmiValueRange o) {
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
