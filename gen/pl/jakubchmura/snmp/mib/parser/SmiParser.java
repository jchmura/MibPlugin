// This is a generated file. Not intended for manual editing.
package pl.jakubchmura.snmp.mib.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static pl.jakubchmura.snmp.mib.psi.SmiTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class SmiParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ALPHABET_CONSTRAINT) {
      r = alphabetConstraint(b, 0);
    }
    else if (t == ANY_TYPE) {
      r = anyType(b, 0);
    }
    else if (t == ASSIGNMENT) {
      r = assignment(b, 0);
    }
    else if (t == BINARY_VALUE) {
      r = binaryValue(b, 0);
    }
    else if (t == BIT_OR_OBJECT_IDENTIFIER_VALUE) {
      r = bitOrObjectIdentifierValue(b, 0);
    }
    else if (t == BIT_STRING_TYPE) {
      r = bitStringType(b, 0);
    }
    else if (t == BITS_TYPE) {
      r = bitsType(b, 0);
    }
    else if (t == BOOLEAN_TYPE) {
      r = booleanType(b, 0);
    }
    else if (t == BOOLEAN_VALUE) {
      r = booleanValue(b, 0);
    }
    else if (t == BUILTIN_TYPE) {
      r = builtinType(b, 0);
    }
    else if (t == BUILTIN_VALUE) {
      r = builtinValue(b, 0);
    }
    else if (t == CHOICE_TYPE) {
      r = choiceType(b, 0);
    }
    else if (t == CLASS_TYPE) {
      r = classType(b, 0);
    }
    else if (t == COMPLIANCE_GROUP) {
      r = complianceGroup(b, 0);
    }
    else if (t == COMPLIANCE_OBJECT) {
      r = complianceObject(b, 0);
    }
    else if (t == COMPONENT_CONSTRAINT) {
      r = componentConstraint(b, 0);
    }
    else if (t == COMPONENT_PRESENCE) {
      r = componentPresence(b, 0);
    }
    else if (t == COMPONENT_VALUE_PRESENCE) {
      r = componentValuePresence(b, 0);
    }
    else if (t == COMPONENTS_LIST) {
      r = componentsList(b, 0);
    }
    else if (t == COMPONENTS_LIST_TAIL) {
      r = componentsListTail(b, 0);
    }
    else if (t == CONSTRAINT) {
      r = constraint(b, 0);
    }
    else if (t == CONTAINED_TYPE_CONSTRAINT) {
      r = containedTypeConstraint(b, 0);
    }
    else if (t == DEFINED_MACRO_NAME) {
      r = definedMacroName(b, 0);
    }
    else if (t == DEFINED_MACRO_TYPE) {
      r = definedMacroType(b, 0);
    }
    else if (t == DEFINED_TYPE) {
      r = definedType(b, 0);
    }
    else if (t == DEFINED_TYPE_NAME) {
      r = definedTypeName(b, 0);
    }
    else if (t == DEFINED_VALUE) {
      r = definedValue(b, 0);
    }
    else if (t == DEFINED_VALUE_NAME) {
      r = definedValueName(b, 0);
    }
    else if (t == ELEMENT_TYP) {
      r = elementTyp(b, 0);
    }
    else if (t == ELEMENT_TYPE_NAME) {
      r = elementTypeName(b, 0);
    }
    else if (t == ENUMERATED_TYPE) {
      r = enumeratedType(b, 0);
    }
    else if (t == EXPLICIT_OR_IMPLICIT_TAG) {
      r = explicitOrImplicitTag(b, 0);
    }
    else if (t == EXPORT_LIST) {
      r = exportList(b, 0);
    }
    else if (t == HEXADECIMAL_VALUE) {
      r = hexadecimalValue(b, 0);
    }
    else if (t == IMPORT_LIST) {
      r = importList(b, 0);
    }
    else if (t == INDEX_TYPE) {
      r = indexType(b, 0);
    }
    else if (t == INDEX_VALUE) {
      r = indexValue(b, 0);
    }
    else if (t == INNER_TYPE_CONSTRAINT) {
      r = innerTypeConstraint(b, 0);
    }
    else if (t == INTEGER_TYPE) {
      r = integerType(b, 0);
    }
    else if (t == LOWER_END_POINT) {
      r = lowerEndPoint(b, 0);
    }
    else if (t == MACRO_BODY) {
      r = macroBody(b, 0);
    }
    else if (t == MACRO_BODY_ELEMENT) {
      r = macroBodyElement(b, 0);
    }
    else if (t == MACRO_DEFINITION) {
      r = macroDefinition(b, 0);
    }
    else if (t == MACRO_REFERENCE) {
      r = macroReference(b, 0);
    }
    else if (t == MIB_NODE) {
      r = mibNode(b, 0);
    }
    else if (t == MODULE_BODY) {
      r = moduleBody(b, 0);
    }
    else if (t == MODULE_DEFINITION) {
      r = moduleDefinition(b, 0);
    }
    else if (t == MODULE_IDENTIFIER) {
      r = moduleIdentifier(b, 0);
    }
    else if (t == MODULE_IDENTIFIER_DEFINITION) {
      r = moduleIdentifierDefinition(b, 0);
    }
    else if (t == NAME_AND_NUMBER) {
      r = nameAndNumber(b, 0);
    }
    else if (t == NAME_VALUE_STRING) {
      r = nameValueString(b, 0);
    }
    else if (t == NAMED_NUMBER) {
      r = namedNumber(b, 0);
    }
    else if (t == NULL_TYPE) {
      r = nullType(b, 0);
    }
    else if (t == NULL_VALUE) {
      r = nullValue(b, 0);
    }
    else if (t == NUMBER) {
      r = number(b, 0);
    }
    else if (t == NUMBER_VALUE) {
      r = numberValue(b, 0);
    }
    else if (t == OBJECT_IDENTIFIER_TYPE) {
      r = objectIdentifierType(b, 0);
    }
    else if (t == OBJECT_IDENTIFIER_VALUE) {
      r = objectIdentifierValue(b, 0);
    }
    else if (t == OPTIONAL_OR_DEFAULT_ELEMENT) {
      r = optionalOrDefaultElement(b, 0);
    }
    else if (t == REAL_TYPE) {
      r = realType(b, 0);
    }
    else if (t == SELECTION_TYPE) {
      r = selectionType(b, 0);
    }
    else if (t == SEQUENCE_OF_TYPE) {
      r = sequenceOfType(b, 0);
    }
    else if (t == SEQUENCE_TYPE) {
      r = sequenceType(b, 0);
    }
    else if (t == SET_OF_TYPE) {
      r = setOfType(b, 0);
    }
    else if (t == SET_TYPE) {
      r = setType(b, 0);
    }
    else if (t == SIZE_CONSTRAINT) {
      r = sizeConstraint(b, 0);
    }
    else if (t == SNMP_ACCESS_PART) {
      r = snmpAccessPart(b, 0);
    }
    else if (t == SNMP_AGENT_CAPABILITIES_MACRO_TYPE) {
      r = snmpAgentCapabilitiesMacroType(b, 0);
    }
    else if (t == SNMP_COMPLIANCE_PART) {
      r = snmpCompliancePart(b, 0);
    }
    else if (t == SNMP_CONTACT_PART) {
      r = snmpContactPart(b, 0);
    }
    else if (t == SNMP_CREATION_PART) {
      r = snmpCreationPart(b, 0);
    }
    else if (t == SNMP_DEF_VAL_PART) {
      r = snmpDefValPart(b, 0);
    }
    else if (t == SNMP_DESCR_PART) {
      r = snmpDescrPart(b, 0);
    }
    else if (t == SNMP_DISPLAY_PART) {
      r = snmpDisplayPart(b, 0);
    }
    else if (t == SNMP_ENTERPRISE_PART) {
      r = snmpEnterprisePart(b, 0);
    }
    else if (t == SNMP_INDEX_PART) {
      r = snmpIndexPart(b, 0);
    }
    else if (t == SNMP_MANDATORY_PART) {
      r = snmpMandatoryPart(b, 0);
    }
    else if (t == SNMP_MODULE_COMPLIANCE_MACRO_TYPE) {
      r = snmpModuleComplianceMacroType(b, 0);
    }
    else if (t == SNMP_MODULE_IDENTITY_MACRO_TYPE) {
      r = snmpModuleIdentityMacroType(b, 0);
    }
    else if (t == SNMP_MODULE_IMPORT) {
      r = snmpModuleImport(b, 0);
    }
    else if (t == SNMP_MODULE_PART) {
      r = snmpModulePart(b, 0);
    }
    else if (t == SNMP_MODULE_SUPPORT_PART) {
      r = snmpModuleSupportPart(b, 0);
    }
    else if (t == SNMP_NOTIFICATION_GROUP_MACRO_TYPE) {
      r = snmpNotificationGroupMacroType(b, 0);
    }
    else if (t == SNMP_NOTIFICATION_TYPE_MACRO_TYPE) {
      r = snmpNotificationTypeMacroType(b, 0);
    }
    else if (t == SNMP_NOTIFICATIONS_PART) {
      r = snmpNotificationsPart(b, 0);
    }
    else if (t == SNMP_OBJECT_GROUP_MACRO_TYPE) {
      r = snmpObjectGroupMacroType(b, 0);
    }
    else if (t == SNMP_OBJECT_IDENTITY_MACRO_TYPE) {
      r = snmpObjectIdentityMacroType(b, 0);
    }
    else if (t == SNMP_OBJECT_TYPE_MACRO_TYPE) {
      r = snmpObjectTypeMacroType(b, 0);
    }
    else if (t == SNMP_OBJECTS_PART) {
      r = snmpObjectsPart(b, 0);
    }
    else if (t == SNMP_ORGANIZATION_PART) {
      r = snmpOrganizationPart(b, 0);
    }
    else if (t == SNMP_PRODUCT_RELEASE_PART) {
      r = snmpProductReleasePart(b, 0);
    }
    else if (t == SNMP_REFER_PART) {
      r = snmpReferPart(b, 0);
    }
    else if (t == SNMP_REVISION_PART) {
      r = snmpRevisionPart(b, 0);
    }
    else if (t == SNMP_STATUS_PART) {
      r = snmpStatusPart(b, 0);
    }
    else if (t == SNMP_SYNTAX_PART) {
      r = snmpSyntaxPart(b, 0);
    }
    else if (t == SNMP_TEXTUAL_CONVENTION_MACRO_TYPE) {
      r = snmpTextualConventionMacroType(b, 0);
    }
    else if (t == SNMP_TRAP_TYPE_MACRO_TYPE) {
      r = snmpTrapTypeMacroType(b, 0);
    }
    else if (t == SNMP_UNITS_PART) {
      r = snmpUnitsPart(b, 0);
    }
    else if (t == SNMP_UPDATE_PART) {
      r = snmpUpdatePart(b, 0);
    }
    else if (t == SNMP_VAR_PART) {
      r = snmpVarPart(b, 0);
    }
    else if (t == SNMP_VARIATION_PART) {
      r = snmpVariationPart(b, 0);
    }
    else if (t == SNMP_WRITE_SYNTAX_PART) {
      r = snmpWriteSyntaxPart(b, 0);
    }
    else if (t == SPECIAL_REAL_VALUE) {
      r = specialRealValue(b, 0);
    }
    else if (t == STRING_TYPE) {
      r = stringType(b, 0);
    }
    else if (t == STRING_VALUE) {
      r = stringValue(b, 0);
    }
    else if (t == SYMBOL) {
      r = symbol(b, 0);
    }
    else if (t == SYMBOL_NAME) {
      r = symbolName(b, 0);
    }
    else if (t == SYMBOLS_FROM_MODULE) {
      r = symbolsFromModule(b, 0);
    }
    else if (t == TAG) {
      r = tag(b, 0);
    }
    else if (t == TAG_DEFAULT) {
      r = tagDefault(b, 0);
    }
    else if (t == TAGGED_TYPE) {
      r = taggedType(b, 0);
    }
    else if (t == TYPE) {
      r = type(b, 0);
    }
    else if (t == TYPE_ASSIGNMENT) {
      r = typeAssignment(b, 0);
    }
    else if (t == TYPE_NAME) {
      r = typeName(b, 0);
    }
    else if (t == UPPER_END_POINT) {
      r = upperEndPoint(b, 0);
    }
    else if (t == VALUE) {
      r = value(b, 0);
    }
    else if (t == VALUE_ASSIGNMENT) {
      r = valueAssignment(b, 0);
    }
    else if (t == VALUE_CONSTRAINT) {
      r = valueConstraint(b, 0);
    }
    else if (t == VALUE_OR_CONSTRAINT_LIST) {
      r = valueOrConstraintList(b, 0);
    }
    else if (t == VALUE_RANGE) {
      r = valueRange(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return mibFile(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(BINARY_VALUE, BIT_OR_OBJECT_IDENTIFIER_VALUE, BOOLEAN_VALUE, BUILTIN_VALUE,
      DEFINED_VALUE, DEFINED_VALUE_NAME, HEXADECIMAL_VALUE, NULL_VALUE,
      NUMBER_VALUE, SPECIAL_REAL_VALUE, STRING_VALUE, VALUE),
    create_token_set_(ANY_TYPE, BITS_TYPE, BIT_STRING_TYPE, BOOLEAN_TYPE,
      BUILTIN_TYPE, CHOICE_TYPE, DEFINED_MACRO_TYPE, DEFINED_TYPE,
      ENUMERATED_TYPE, INTEGER_TYPE, NULL_TYPE, OBJECT_IDENTIFIER_TYPE,
      REAL_TYPE, SELECTION_TYPE, SEQUENCE_OF_TYPE, SEQUENCE_TYPE,
      SET_OF_TYPE, SET_TYPE, SNMP_AGENT_CAPABILITIES_MACRO_TYPE, SNMP_MODULE_COMPLIANCE_MACRO_TYPE,
      SNMP_MODULE_IDENTITY_MACRO_TYPE, SNMP_NOTIFICATION_GROUP_MACRO_TYPE, SNMP_NOTIFICATION_TYPE_MACRO_TYPE, SNMP_OBJECT_GROUP_MACRO_TYPE,
      SNMP_OBJECT_IDENTITY_MACRO_TYPE, SNMP_OBJECT_TYPE_MACRO_TYPE, SNMP_TEXTUAL_CONVENTION_MACRO_TYPE, SNMP_TRAP_TYPE_MACRO_TYPE,
      STRING_TYPE, TAGGED_TYPE, TYPE),
  };

  /* ********************************************************** */
  // FROM valueConstraintList
  public static boolean alphabetConstraint(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alphabetConstraint")) return false;
    if (!nextTokenIs(b, FROM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FROM);
    r = r && valueConstraintList(b, l + 1);
    exit_section_(b, m, ALPHABET_CONSTRAINT, r);
    return r;
  }

  /* ********************************************************** */
  // ANY | (ANY DEFINED BY IDENTIFIER_STRING)
  public static boolean anyType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyType")) return false;
    if (!nextTokenIs(b, ANY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ANY);
    if (!r) r = anyType_1(b, l + 1);
    exit_section_(b, m, ANY_TYPE, r);
    return r;
  }

  // ANY DEFINED BY IDENTIFIER_STRING
  private static boolean anyType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyType_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ANY, DEFINED, BY, IDENTIFIER_STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (macroDefinition|typeAssignment|valueAssignment) SEMI_COLON?
  public static boolean assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT, "<assignment>");
    r = assignment_0(b, l + 1);
    r = r && assignment_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // macroDefinition|typeAssignment|valueAssignment
  private static boolean assignment_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = macroDefinition(b, l + 1);
    if (!r) r = typeAssignment(b, l + 1);
    if (!r) r = valueAssignment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SEMI_COLON?
  private static boolean assignment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_1")) return false;
    consumeToken(b, SEMI_COLON);
    return true;
  }

  /* ********************************************************** */
  // assignment+
  static boolean assignmentList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignmentList")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assignment(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!assignment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "assignmentList", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<param>> ( VERTICAL_BAR <<param>> )*
  static boolean bar_separated_list(PsiBuilder b, int l, Parser _param) {
    if (!recursion_guard_(b, l, "bar_separated_list")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _param.parse(b, l);
    r = r && bar_separated_list_1(b, l + 1, _param);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( VERTICAL_BAR <<param>> )*
  private static boolean bar_separated_list_1(PsiBuilder b, int l, Parser _param) {
    if (!recursion_guard_(b, l, "bar_separated_list_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!bar_separated_list_1_0(b, l + 1, _param)) break;
      if (!empty_element_parsed_guard_(b, "bar_separated_list_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // VERTICAL_BAR <<param>>
  private static boolean bar_separated_list_1_0(PsiBuilder b, int l, Parser _param) {
    if (!recursion_guard_(b, l, "bar_separated_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VERTICAL_BAR);
    r = r && _param.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BINARY_LITERAL
  public static boolean binaryValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binaryValue")) return false;
    if (!nextTokenIs(b, BINARY_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BINARY_LITERAL);
    exit_section_(b, m, BINARY_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // nameValueList
  public static boolean bitOrObjectIdentifierValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitOrObjectIdentifierValue")) return false;
    if (!nextTokenIs(b, LEFT_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nameValueList(b, l + 1);
    exit_section_(b, m, BIT_OR_OBJECT_IDENTIFIER_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // BIT_STRING valueOrConstraintList?
  public static boolean bitStringType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitStringType")) return false;
    if (!nextTokenIs(b, BIT_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BIT_STRING);
    r = r && bitStringType_1(b, l + 1);
    exit_section_(b, m, BIT_STRING_TYPE, r);
    return r;
  }

  // valueOrConstraintList?
  private static boolean bitStringType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitStringType_1")) return false;
    valueOrConstraintList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // BITS valueOrConstraintList?
  public static boolean bitsType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitsType")) return false;
    if (!nextTokenIs(b, BITS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BITS);
    r = r && bitsType_1(b, l + 1);
    exit_section_(b, m, BITS_TYPE, r);
    return r;
  }

  // valueOrConstraintList?
  private static boolean bitsType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitsType_1")) return false;
    valueOrConstraintList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // BOOLEAN
  public static boolean booleanType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "booleanType")) return false;
    if (!nextTokenIs(b, BOOLEAN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BOOLEAN);
    exit_section_(b, m, BOOLEAN_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // TRUE | FALSE
  public static boolean booleanValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "booleanValue")) return false;
    if (!nextTokenIs(b, "<boolean value>", FALSE, TRUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN_VALUE, "<boolean value>");
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // nullType | booleanType | realType | integerType | objectIdentifierType | stringType | bitStringType |
  //                 bitsType | sequenceType | sequenceOfType | setType | setOfType | choiceType | enumeratedType |
  //                 selectionType | taggedType | anyType
  public static boolean builtinType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtinType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, BUILTIN_TYPE, "<builtin type>");
    r = nullType(b, l + 1);
    if (!r) r = booleanType(b, l + 1);
    if (!r) r = realType(b, l + 1);
    if (!r) r = integerType(b, l + 1);
    if (!r) r = objectIdentifierType(b, l + 1);
    if (!r) r = stringType(b, l + 1);
    if (!r) r = bitStringType(b, l + 1);
    if (!r) r = bitsType(b, l + 1);
    if (!r) r = sequenceType(b, l + 1);
    if (!r) r = sequenceOfType(b, l + 1);
    if (!r) r = setType(b, l + 1);
    if (!r) r = setOfType(b, l + 1);
    if (!r) r = choiceType(b, l + 1);
    if (!r) r = enumeratedType(b, l + 1);
    if (!r) r = selectionType(b, l + 1);
    if (!r) r = taggedType(b, l + 1);
    if (!r) r = anyType(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // nullValue | booleanValue | specialRealValue | numberValue | binaryValue | hexadecimalValue |
  //                  stringValue | bitOrObjectIdentifierValue
  public static boolean builtinValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtinValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, BUILTIN_VALUE, "<builtin value>");
    r = nullValue(b, l + 1);
    if (!r) r = booleanValue(b, l + 1);
    if (!r) r = specialRealValue(b, l + 1);
    if (!r) r = numberValue(b, l + 1);
    if (!r) r = binaryValue(b, l + 1);
    if (!r) r = hexadecimalValue(b, l + 1);
    if (!r) r = stringValue(b, l + 1);
    if (!r) r = bitOrObjectIdentifierValue(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CHOICE LEFT_BRACE elementTypeList RIGHT_BRACE
  public static boolean choiceType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choiceType")) return false;
    if (!nextTokenIs(b, CHOICE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CHOICE, LEFT_BRACE);
    r = r && elementTypeList(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, CHOICE_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // UNIVERSAL | APPLICATION | "PRIVATE"
  public static boolean classType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_TYPE, "<class type>");
    r = consumeToken(b, UNIVERSAL);
    if (!r) r = consumeToken(b, APPLICATION);
    if (!r) r = consumeToken(b, PRIVATE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<param>> ( COMMA <<param>> )*
  static boolean comma_separated_list(PsiBuilder b, int l, Parser _param) {
    if (!recursion_guard_(b, l, "comma_separated_list")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _param.parse(b, l);
    r = r && comma_separated_list_1(b, l + 1, _param);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( COMMA <<param>> )*
  private static boolean comma_separated_list_1(PsiBuilder b, int l, Parser _param) {
    if (!recursion_guard_(b, l, "comma_separated_list_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!comma_separated_list_1_0(b, l + 1, _param)) break;
      if (!empty_element_parsed_guard_(b, "comma_separated_list_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA <<param>>
  private static boolean comma_separated_list_1_0(PsiBuilder b, int l, Parser _param) {
    if (!recursion_guard_(b, l, "comma_separated_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && _param.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // GROUP value snmpDescrPart
  public static boolean complianceGroup(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "complianceGroup")) return false;
    if (!nextTokenIs(b, GROUP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GROUP);
    r = r && value(b, l + 1);
    r = r && snmpDescrPart(b, l + 1);
    exit_section_(b, m, COMPLIANCE_GROUP, r);
    return r;
  }

  /* ********************************************************** */
  // OBJECT value snmpSyntaxPart? snmpWriteSyntaxPart? snmpAccessPart? snmpDescrPart
  public static boolean complianceObject(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "complianceObject")) return false;
    if (!nextTokenIs(b, OBJECT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OBJECT);
    r = r && value(b, l + 1);
    r = r && complianceObject_2(b, l + 1);
    r = r && complianceObject_3(b, l + 1);
    r = r && complianceObject_4(b, l + 1);
    r = r && snmpDescrPart(b, l + 1);
    exit_section_(b, m, COMPLIANCE_OBJECT, r);
    return r;
  }

  // snmpSyntaxPart?
  private static boolean complianceObject_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "complianceObject_2")) return false;
    snmpSyntaxPart(b, l + 1);
    return true;
  }

  // snmpWriteSyntaxPart?
  private static boolean complianceObject_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "complianceObject_3")) return false;
    snmpWriteSyntaxPart(b, l + 1);
    return true;
  }

  // snmpAccessPart?
  private static boolean complianceObject_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "complianceObject_4")) return false;
    snmpAccessPart(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (IDENTIFIER_STRING componentValuePresence?) componentValuePresence
  public static boolean componentConstraint(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentConstraint")) return false;
    if (!nextTokenIs(b, IDENTIFIER_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = componentConstraint_0(b, l + 1);
    r = r && componentValuePresence(b, l + 1);
    exit_section_(b, m, COMPONENT_CONSTRAINT, r);
    return r;
  }

  // IDENTIFIER_STRING componentValuePresence?
  private static boolean componentConstraint_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentConstraint_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER_STRING);
    r = r && componentConstraint_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // componentValuePresence?
  private static boolean componentConstraint_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentConstraint_0_1")) return false;
    componentValuePresence(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // PRESENT | ABSENT | OPTIONAL
  public static boolean componentPresence(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentPresence")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPONENT_PRESENCE, "<component presence>");
    r = consumeToken(b, PRESENT);
    if (!r) r = consumeToken(b, ABSENT);
    if (!r) r = consumeToken(b, OPTIONAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (valueOrConstraintList componentPresence?) | componentPresence
  public static boolean componentValuePresence(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentValuePresence")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPONENT_VALUE_PRESENCE, "<component value presence>");
    r = componentValuePresence_0(b, l + 1);
    if (!r) r = componentPresence(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // valueOrConstraintList componentPresence?
  private static boolean componentValuePresence_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentValuePresence_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = valueOrConstraintList(b, l + 1);
    r = r && componentValuePresence_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // componentPresence?
  private static boolean componentValuePresence_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentValuePresence_0_1")) return false;
    componentPresence(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (LEFT_BRACE componentConstraint componentsListTail* RIGHT_BRACE) | (LEFT_BRACE TRIPLE_DOT componentsListTail+ RIGHT_BRACE)
  public static boolean componentsList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentsList")) return false;
    if (!nextTokenIs(b, LEFT_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = componentsList_0(b, l + 1);
    if (!r) r = componentsList_1(b, l + 1);
    exit_section_(b, m, COMPONENTS_LIST, r);
    return r;
  }

  // LEFT_BRACE componentConstraint componentsListTail* RIGHT_BRACE
  private static boolean componentsList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentsList_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACE);
    r = r && componentConstraint(b, l + 1);
    r = r && componentsList_0_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // componentsListTail*
  private static boolean componentsList_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentsList_0_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!componentsListTail(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "componentsList_0_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // LEFT_BRACE TRIPLE_DOT componentsListTail+ RIGHT_BRACE
  private static boolean componentsList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentsList_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LEFT_BRACE, TRIPLE_DOT);
    r = r && componentsList_1_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // componentsListTail+
  private static boolean componentsList_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentsList_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = componentsListTail(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!componentsListTail(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "componentsList_1_2", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COMMA componentConstraint?
  public static boolean componentsListTail(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentsListTail")) return false;
    if (!nextTokenIs(b, COMMA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && componentsListTail_1(b, l + 1);
    exit_section_(b, m, COMPONENTS_LIST_TAIL, r);
    return r;
  }

  // componentConstraint?
  private static boolean componentsListTail_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentsListTail_1")) return false;
    componentConstraint(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // valueConstraint | sizeConstraint | alphabetConstraint | containedTypeConstraint | innerTypeConstraint
  public static boolean constraint(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constraint")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTRAINT, "<constraint>");
    r = valueConstraint(b, l + 1);
    if (!r) r = sizeConstraint(b, l + 1);
    if (!r) r = alphabetConstraint(b, l + 1);
    if (!r) r = containedTypeConstraint(b, l + 1);
    if (!r) r = innerTypeConstraint(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LEFT_PAREN <<bar_separated_list constraint>> RIGHT_PAREN
  static boolean constraintList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constraintList")) return false;
    if (!nextTokenIs(b, LEFT_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PAREN);
    r = r && bar_separated_list(b, l + 1, constraint_parser_);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INCLUDES type
  public static boolean containedTypeConstraint(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containedTypeConstraint")) return false;
    if (!nextTokenIs(b, INCLUDES)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INCLUDES);
    r = r && type(b, l + 1);
    exit_section_(b, m, CONTAINED_TYPE_CONSTRAINT, r);
    return r;
  }

  /* ********************************************************** */
  // MODULE_IDENTITY | OBJECT_IDENTITY | OBJECT_TYPE | NOTIFICATION_TYPE | TRAP_TYPE | TEXTUAL_CONVENTION | OBJECT_GROUP | NOTIFICATION_GROUP | MODULE_COMPLIANCE | AGENT_CAPABILITIES
  public static boolean definedMacroName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definedMacroName")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFINED_MACRO_NAME, "<defined macro name>");
    r = consumeToken(b, MODULE_IDENTITY);
    if (!r) r = consumeToken(b, OBJECT_IDENTITY);
    if (!r) r = consumeToken(b, OBJECT_TYPE);
    if (!r) r = consumeToken(b, NOTIFICATION_TYPE);
    if (!r) r = consumeToken(b, TRAP_TYPE);
    if (!r) r = consumeToken(b, TEXTUAL_CONVENTION);
    if (!r) r = consumeToken(b, OBJECT_GROUP);
    if (!r) r = consumeToken(b, NOTIFICATION_GROUP);
    if (!r) r = consumeToken(b, MODULE_COMPLIANCE);
    if (!r) r = consumeToken(b, AGENT_CAPABILITIES);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // snmpModuleIdentityMacroType | snmpObjectIdentityMacroType | snmpObjectTypeMacroType |
  //                      snmpNotificationTypeMacroType | snmpTrapTypeMacroType | snmpTextualConventionMacroType |
  //                      snmpObjectGroupMacroType | snmpNotificationGroupMacroType | snmpModuleComplianceMacroType |
  //                      snmpAgentCapabilitiesMacroType
  public static boolean definedMacroType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definedMacroType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, DEFINED_MACRO_TYPE, "<defined macro type>");
    r = snmpModuleIdentityMacroType(b, l + 1);
    if (!r) r = snmpObjectIdentityMacroType(b, l + 1);
    if (!r) r = snmpObjectTypeMacroType(b, l + 1);
    if (!r) r = snmpNotificationTypeMacroType(b, l + 1);
    if (!r) r = snmpTrapTypeMacroType(b, l + 1);
    if (!r) r = snmpTextualConventionMacroType(b, l + 1);
    if (!r) r = snmpObjectGroupMacroType(b, l + 1);
    if (!r) r = snmpNotificationGroupMacroType(b, l + 1);
    if (!r) r = snmpModuleComplianceMacroType(b, l + 1);
    if (!r) r = snmpAgentCapabilitiesMacroType(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // moduleReference? definedTypeName valueOrConstraintList?
  public static boolean definedType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definedType")) return false;
    if (!nextTokenIs(b, IDENTIFIER_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = definedType_0(b, l + 1);
    r = r && definedTypeName(b, l + 1);
    r = r && definedType_2(b, l + 1);
    exit_section_(b, m, DEFINED_TYPE, r);
    return r;
  }

  // moduleReference?
  private static boolean definedType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definedType_0")) return false;
    moduleReference(b, l + 1);
    return true;
  }

  // valueOrConstraintList?
  private static boolean definedType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definedType_2")) return false;
    valueOrConstraintList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER_STRING
  public static boolean definedTypeName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definedTypeName")) return false;
    if (!nextTokenIs(b, IDENTIFIER_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER_STRING);
    exit_section_(b, m, DEFINED_TYPE_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // moduleReference? definedValueName
  public static boolean definedValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definedValue")) return false;
    if (!nextTokenIs(b, IDENTIFIER_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, DEFINED_VALUE, null);
    r = definedValue_0(b, l + 1);
    r = r && definedValueName(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // moduleReference?
  private static boolean definedValue_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definedValue_0")) return false;
    moduleReference(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER_STRING
  public static boolean definedValueName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definedValueName")) return false;
    if (!nextTokenIs(b, IDENTIFIER_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER_STRING);
    exit_section_(b, m, DEFINED_VALUE_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // (elementTypeName? type optionalOrDefaultElement?) | (elementTypeName? COMPONENTS OF type)
  public static boolean elementTyp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elementTyp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELEMENT_TYP, "<element typ>");
    r = elementTyp_0(b, l + 1);
    if (!r) r = elementTyp_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // elementTypeName? type optionalOrDefaultElement?
  private static boolean elementTyp_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elementTyp_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elementTyp_0_0(b, l + 1);
    r = r && type(b, l + 1);
    r = r && elementTyp_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // elementTypeName?
  private static boolean elementTyp_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elementTyp_0_0")) return false;
    elementTypeName(b, l + 1);
    return true;
  }

  // optionalOrDefaultElement?
  private static boolean elementTyp_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elementTyp_0_2")) return false;
    optionalOrDefaultElement(b, l + 1);
    return true;
  }

  // elementTypeName? COMPONENTS OF type
  private static boolean elementTyp_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elementTyp_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elementTyp_1_0(b, l + 1);
    r = r && consumeTokens(b, 0, COMPONENTS, OF);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // elementTypeName?
  private static boolean elementTyp_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elementTyp_1_0")) return false;
    elementTypeName(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<comma_separated_list elementTyp>>
  static boolean elementTypeList(PsiBuilder b, int l) {
    return comma_separated_list(b, l + 1, elementTyp_parser_);
  }

  /* ********************************************************** */
  // IDENTIFIER_STRING
  public static boolean elementTypeName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elementTypeName")) return false;
    if (!nextTokenIs(b, IDENTIFIER_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER_STRING);
    exit_section_(b, m, ELEMENT_TYPE_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // !END
  static boolean end_rule_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "end_rule_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, END);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ENUMERATED namedNumberList
  public static boolean enumeratedType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumeratedType")) return false;
    if (!nextTokenIs(b, ENUMERATED)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENUMERATED);
    r = r && namedNumberList(b, l + 1);
    exit_section_(b, m, ENUMERATED_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // EXPLICIT | IMPLICIT
  public static boolean explicitOrImplicitTag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "explicitOrImplicitTag")) return false;
    if (!nextTokenIs(b, "<explicit or implicit tag>", EXPLICIT, IMPLICIT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPLICIT_OR_IMPLICIT_TAG, "<explicit or implicit tag>");
    r = consumeToken(b, EXPLICIT);
    if (!r) r = consumeToken(b, IMPLICIT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // EXPORTS symbolList? SEMI_COLON
  public static boolean exportList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exportList")) return false;
    if (!nextTokenIs(b, EXPORTS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXPORTS);
    r = r && exportList_1(b, l + 1);
    r = r && consumeToken(b, SEMI_COLON);
    exit_section_(b, m, EXPORT_LIST, r);
    return r;
  }

  // symbolList?
  private static boolean exportList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exportList_1")) return false;
    symbolList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // HEXADECIMAL_LITERAL
  public static boolean hexadecimalValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hexadecimalValue")) return false;
    if (!nextTokenIs(b, HEXADECIMAL_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HEXADECIMAL_LITERAL);
    exit_section_(b, m, HEXADECIMAL_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // IMPORTS symbolsFromModule* SEMI_COLON
  public static boolean importList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "importList")) return false;
    if (!nextTokenIs(b, IMPORTS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IMPORTS);
    r = r && importList_1(b, l + 1);
    r = r && consumeToken(b, SEMI_COLON);
    exit_section_(b, m, IMPORT_LIST, r);
    return r;
  }

  // symbolsFromModule*
  private static boolean importList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "importList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!symbolsFromModule(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "importList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // integerType | stringType | objectIdentifierType
  public static boolean indexType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INDEX_TYPE, "<index type>");
    r = integerType(b, l + 1);
    if (!r) r = stringType(b, l + 1);
    if (!r) r = objectIdentifierType(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // value | (IMPLIED value) | indexType
  public static boolean indexValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INDEX_VALUE, "<index value>");
    r = value(b, l + 1);
    if (!r) r = indexValue_1(b, l + 1);
    if (!r) r = indexType(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IMPLIED value
  private static boolean indexValue_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexValue_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IMPLIED);
    r = r && value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<comma_separated_list indexValue>>
  static boolean indexValueList(PsiBuilder b, int l) {
    return comma_separated_list(b, l + 1, indexValue_parser_);
  }

  /* ********************************************************** */
  // (WITH COMPONENTS valueOrConstraintList) | (WITH COMPONENTS componentsList)
  public static boolean innerTypeConstraint(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "innerTypeConstraint")) return false;
    if (!nextTokenIs(b, WITH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = innerTypeConstraint_0(b, l + 1);
    if (!r) r = innerTypeConstraint_1(b, l + 1);
    exit_section_(b, m, INNER_TYPE_CONSTRAINT, r);
    return r;
  }

  // WITH COMPONENTS valueOrConstraintList
  private static boolean innerTypeConstraint_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "innerTypeConstraint_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, WITH, COMPONENTS);
    r = r && valueOrConstraintList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WITH COMPONENTS componentsList
  private static boolean innerTypeConstraint_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "innerTypeConstraint_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, WITH, COMPONENTS);
    r = r && componentsList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INTEGER valueOrConstraintList?
  public static boolean integerType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integerType")) return false;
    if (!nextTokenIs(b, INTEGER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INTEGER);
    r = r && integerType_1(b, l + 1);
    exit_section_(b, m, INTEGER_TYPE, r);
    return r;
  }

  // valueOrConstraintList?
  private static boolean integerType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integerType_1")) return false;
    valueOrConstraintList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // value | MIN
  public static boolean lowerEndPoint(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lowerEndPoint")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOWER_END_POINT, "<lower end point>");
    r = value(b, l + 1);
    if (!r) r = consumeToken(b, MIN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (BEGIN macroBodyElement* END) | (moduleReference macroReference)
  public static boolean macroBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macroBody")) return false;
    if (!nextTokenIs(b, "<macro body>", BEGIN, IDENTIFIER_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MACRO_BODY, "<macro body>");
    r = macroBody_0(b, l + 1);
    if (!r) r = macroBody_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BEGIN macroBodyElement* END
  private static boolean macroBody_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macroBody_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BEGIN);
    r = r && macroBody_0_1(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, null, r);
    return r;
  }

  // macroBodyElement*
  private static boolean macroBody_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macroBody_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!macroBodyElement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "macroBody_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // moduleReference macroReference
  private static boolean macroBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macroBody_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = moduleReference(b, l + 1);
    r = r && macroReference(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_PAREN|RIGHT_PAREN|VERTICAL_BAR|DEFINITION|INTEGER|REAL|BOOLEAN|NULL|BIT|OCTET|STRING|OBJECT|IDENTIFIER|IDENTIFIER_STRING|STRING_LITERAL|OBJECT_IDENTIFIER
  public static boolean macroBodyElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macroBodyElement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MACRO_BODY_ELEMENT, "<macro body element>");
    r = consumeToken(b, LEFT_PAREN);
    if (!r) r = consumeToken(b, RIGHT_PAREN);
    if (!r) r = consumeToken(b, VERTICAL_BAR);
    if (!r) r = consumeToken(b, DEFINITION);
    if (!r) r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, REAL);
    if (!r) r = consumeToken(b, BOOLEAN);
    if (!r) r = consumeToken(b, NULL);
    if (!r) r = consumeToken(b, BIT);
    if (!r) r = consumeToken(b, OCTET);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, OBJECT);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, IDENTIFIER_STRING);
    if (!r) r = consumeToken(b, STRING_LITERAL);
    if (!r) r = consumeToken(b, OBJECT_IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // macroReference MACRO DEFINITION macroBody
  public static boolean macroDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macroDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MACRO_DEFINITION, "<macro definition>");
    r = macroReference(b, l + 1);
    r = r && consumeTokens(b, 0, MACRO, DEFINITION);
    r = r && macroBody(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER_STRING | definedMacroName
  public static boolean macroReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macroReference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MACRO_REFERENCE, "<macro reference>");
    r = consumeToken(b, IDENTIFIER_STRING);
    if (!r) r = definedMacroName(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // moduleDefinition+
  static boolean mibFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mibFile")) return false;
    if (!nextTokenIs(b, IDENTIFIER_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = moduleDefinition(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!moduleDefinition(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mibFile", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER_STRING
  public static boolean mibNode(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mibNode")) return false;
    if (!nextTokenIs(b, IDENTIFIER_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER_STRING);
    exit_section_(b, m, MIB_NODE, r);
    return r;
  }

  /* ********************************************************** */
  // exportList? importList? assignmentList
  public static boolean moduleBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleBody")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODULE_BODY, "<module body>");
    r = moduleBody_0(b, l + 1);
    r = r && moduleBody_1(b, l + 1);
    r = r && assignmentList(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // exportList?
  private static boolean moduleBody_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleBody_0")) return false;
    exportList(b, l + 1);
    return true;
  }

  // importList?
  private static boolean moduleBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleBody_1")) return false;
    importList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // moduleIdentifierDefinition DEFINITIONS tagDefault? DEFINITION BEGIN moduleBody? END
  public static boolean moduleDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleDefinition")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MODULE_DEFINITION, "<module definition>");
    r = moduleIdentifierDefinition(b, l + 1);
    r = r && consumeToken(b, DEFINITIONS);
    r = r && moduleDefinition_2(b, l + 1);
    r = r && consumeTokens(b, 2, DEFINITION, BEGIN);
    p = r; // pin = 5
    r = r && report_error_(b, moduleDefinition_5(b, l + 1));
    r = p && consumeToken(b, END) && r;
    exit_section_(b, l, m, r, p, end_rule_recover_parser_);
    return r || p;
  }

  // tagDefault?
  private static boolean moduleDefinition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleDefinition_2")) return false;
    tagDefault(b, l + 1);
    return true;
  }

  // moduleBody?
  private static boolean moduleDefinition_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleDefinition_5")) return false;
    moduleBody(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER_STRING objectIdentifierValue?
  public static boolean moduleIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleIdentifier")) return false;
    if (!nextTokenIs(b, IDENTIFIER_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER_STRING);
    r = r && moduleIdentifier_1(b, l + 1);
    exit_section_(b, m, MODULE_IDENTIFIER, r);
    return r;
  }

  // objectIdentifierValue?
  private static boolean moduleIdentifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleIdentifier_1")) return false;
    objectIdentifierValue(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER_STRING objectIdentifierValue?
  public static boolean moduleIdentifierDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleIdentifierDefinition")) return false;
    if (!nextTokenIs(b, IDENTIFIER_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER_STRING);
    r = r && moduleIdentifierDefinition_1(b, l + 1);
    exit_section_(b, m, MODULE_IDENTIFIER_DEFINITION, r);
    return r;
  }

  // objectIdentifierValue?
  private static boolean moduleIdentifierDefinition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleIdentifierDefinition_1")) return false;
    objectIdentifierValue(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER_STRING DOT
  static boolean moduleReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleReference")) return false;
    if (!nextTokenIs(b, IDENTIFIER_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER_STRING, DOT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (IDENTIFIER_STRING LEFT_PAREN NUMBER_LITERAL RIGHT_PAREN) | (IDENTIFIER_STRING LEFT_PAREN definedValue RIGHT_PAREN)
  public static boolean nameAndNumber(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameAndNumber")) return false;
    if (!nextTokenIs(b, IDENTIFIER_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nameAndNumber_0(b, l + 1);
    if (!r) r = nameAndNumber_1(b, l + 1);
    exit_section_(b, m, NAME_AND_NUMBER, r);
    return r;
  }

  // IDENTIFIER_STRING LEFT_PAREN NUMBER_LITERAL RIGHT_PAREN
  private static boolean nameAndNumber_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameAndNumber_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER_STRING, LEFT_PAREN, NUMBER_LITERAL, RIGHT_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER_STRING LEFT_PAREN definedValue RIGHT_PAREN
  private static boolean nameAndNumber_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameAndNumber_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER_STRING, LEFT_PAREN);
    r = r && definedValue(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NUMBER_LITERAL | nameAndNumber | nameValueString
  static boolean nameOrNumber(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameOrNumber")) return false;
    if (!nextTokenIs(b, "", IDENTIFIER_STRING, NUMBER_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NUMBER_LITERAL);
    if (!r) r = nameAndNumber(b, l + 1);
    if (!r) r = nameValueString(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COMMA? nameOrNumber
  static boolean nameValueComponent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameValueComponent")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nameValueComponent_0(b, l + 1);
    r = r && nameOrNumber(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean nameValueComponent_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameValueComponent_0")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // LEFT_BRACE nameValueComponent* RIGHT_BRACE
  static boolean nameValueList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameValueList")) return false;
    if (!nextTokenIs(b, LEFT_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACE);
    r = r && nameValueList_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // nameValueComponent*
  private static boolean nameValueList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameValueList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!nameValueComponent(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nameValueList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER_STRING
  public static boolean nameValueString(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameValueString")) return false;
    if (!nextTokenIs(b, IDENTIFIER_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER_STRING);
    exit_section_(b, m, NAME_VALUE_STRING, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER_STRING LEFT_PAREN number RIGHT_PAREN
  public static boolean namedNumber(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namedNumber")) return false;
    if (!nextTokenIs(b, IDENTIFIER_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER_STRING, LEFT_PAREN);
    r = r && number(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, NAMED_NUMBER, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE <<comma_separated_list namedNumber>> RIGHT_BRACE
  static boolean namedNumberList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namedNumberList")) return false;
    if (!nextTokenIs(b, LEFT_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACE);
    r = r && comma_separated_list(b, l + 1, namedNumber_parser_);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NULL
  public static boolean nullType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nullType")) return false;
    if (!nextTokenIs(b, NULL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NULL);
    exit_section_(b, m, NULL_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // NULL
  public static boolean nullValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nullValue")) return false;
    if (!nextTokenIs(b, NULL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NULL);
    exit_section_(b, m, NULL_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // numberValue | binaryValue | hexadecimalValue | definedValue
  public static boolean number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER, "<number>");
    r = numberValue(b, l + 1);
    if (!r) r = binaryValue(b, l + 1);
    if (!r) r = hexadecimalValue(b, l + 1);
    if (!r) r = definedValue(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "-"? NUMBER_LITERAL
  public static boolean numberValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "numberValue")) return false;
    if (!nextTokenIs(b, "<number value>", MINUS, NUMBER_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER_VALUE, "<number value>");
    r = numberValue_0(b, l + 1);
    r = r && consumeToken(b, NUMBER_LITERAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "-"?
  private static boolean numberValue_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "numberValue_0")) return false;
    consumeToken(b, MINUS);
    return true;
  }

  /* ********************************************************** */
  // OBJECT_IDENTIFIER
  public static boolean objectIdentifierType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectIdentifierType")) return false;
    if (!nextTokenIs(b, OBJECT_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OBJECT_IDENTIFIER);
    exit_section_(b, m, OBJECT_IDENTIFIER_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // nameValueList
  public static boolean objectIdentifierValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectIdentifierValue")) return false;
    if (!nextTokenIs(b, LEFT_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nameValueList(b, l + 1);
    exit_section_(b, m, OBJECT_IDENTIFIER_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // OPTIONAL | (DEFAULT IDENTIFIER_STRING? value)
  public static boolean optionalOrDefaultElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "optionalOrDefaultElement")) return false;
    if (!nextTokenIs(b, "<optional or default element>", DEFAULT, OPTIONAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPTIONAL_OR_DEFAULT_ELEMENT, "<optional or default element>");
    r = consumeToken(b, OPTIONAL);
    if (!r) r = optionalOrDefaultElement_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DEFAULT IDENTIFIER_STRING? value
  private static boolean optionalOrDefaultElement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "optionalOrDefaultElement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEFAULT);
    r = r && optionalOrDefaultElement_1_1(b, l + 1);
    r = r && value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER_STRING?
  private static boolean optionalOrDefaultElement_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "optionalOrDefaultElement_1_1")) return false;
    consumeToken(b, IDENTIFIER_STRING);
    return true;
  }

  /* ********************************************************** */
  // REAL
  public static boolean realType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "realType")) return false;
    if (!nextTokenIs(b, REAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REAL);
    exit_section_(b, m, REAL_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER_STRING LESS_THAN type
  public static boolean selectionType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selectionType")) return false;
    if (!nextTokenIs(b, IDENTIFIER_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER_STRING, LESS_THAN);
    r = r && type(b, l + 1);
    exit_section_(b, m, SELECTION_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // SEQUENCE constraintList? OF type
  public static boolean sequenceOfType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sequenceOfType")) return false;
    if (!nextTokenIs(b, SEQUENCE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEQUENCE);
    r = r && sequenceOfType_1(b, l + 1);
    r = r && consumeToken(b, OF);
    r = r && type(b, l + 1);
    exit_section_(b, m, SEQUENCE_OF_TYPE, r);
    return r;
  }

  // constraintList?
  private static boolean sequenceOfType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sequenceOfType_1")) return false;
    constraintList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // SEQUENCE LEFT_BRACE elementTypeList? RIGHT_BRACE
  public static boolean sequenceType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sequenceType")) return false;
    if (!nextTokenIs(b, SEQUENCE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SEQUENCE, LEFT_BRACE);
    r = r && sequenceType_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, SEQUENCE_TYPE, r);
    return r;
  }

  // elementTypeList?
  private static boolean sequenceType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sequenceType_2")) return false;
    elementTypeList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // SET sizeConstraint? OF type
  public static boolean setOfType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setOfType")) return false;
    if (!nextTokenIs(b, SET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SET);
    r = r && setOfType_1(b, l + 1);
    r = r && consumeToken(b, OF);
    r = r && type(b, l + 1);
    exit_section_(b, m, SET_OF_TYPE, r);
    return r;
  }

  // sizeConstraint?
  private static boolean setOfType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setOfType_1")) return false;
    sizeConstraint(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // SET LEFT_BRACE elementTypeList? RIGHT_BRACE
  public static boolean setType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setType")) return false;
    if (!nextTokenIs(b, SET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SET, LEFT_BRACE);
    r = r && setType_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, SET_TYPE, r);
    return r;
  }

  // elementTypeList?
  private static boolean setType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setType_2")) return false;
    elementTypeList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // SIZE valueConstraintList
  public static boolean sizeConstraint(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sizeConstraint")) return false;
    if (!nextTokenIs(b, SIZE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SIZE);
    r = r && valueConstraintList(b, l + 1);
    exit_section_(b, m, SIZE_CONSTRAINT, r);
    return r;
  }

  /* ********************************************************** */
  // (ACCESS IDENTIFIER_STRING) | (MAX_ACCESS IDENTIFIER_STRING) | (MIN_ACCESS IDENTIFIER_STRING)
  public static boolean snmpAccessPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpAccessPart")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SNMP_ACCESS_PART, "<snmp access part>");
    r = snmpAccessPart_0(b, l + 1);
    if (!r) r = snmpAccessPart_1(b, l + 1);
    if (!r) r = snmpAccessPart_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ACCESS IDENTIFIER_STRING
  private static boolean snmpAccessPart_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpAccessPart_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ACCESS, IDENTIFIER_STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  // MAX_ACCESS IDENTIFIER_STRING
  private static boolean snmpAccessPart_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpAccessPart_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MAX_ACCESS, IDENTIFIER_STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  // MIN_ACCESS IDENTIFIER_STRING
  private static boolean snmpAccessPart_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpAccessPart_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MIN_ACCESS, IDENTIFIER_STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // AGENT_CAPABILITIES
  //                                    snmpProductReleasePart
  //                                    snmpStatusPart
  //                                    snmpDescrPart
  //                                    snmpReferPart?
  //                                    snmpModuleSupportPart*
  public static boolean snmpAgentCapabilitiesMacroType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpAgentCapabilitiesMacroType")) return false;
    if (!nextTokenIs(b, AGENT_CAPABILITIES)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AGENT_CAPABILITIES);
    r = r && snmpProductReleasePart(b, l + 1);
    r = r && snmpStatusPart(b, l + 1);
    r = r && snmpDescrPart(b, l + 1);
    r = r && snmpAgentCapabilitiesMacroType_4(b, l + 1);
    r = r && snmpAgentCapabilitiesMacroType_5(b, l + 1);
    exit_section_(b, m, SNMP_AGENT_CAPABILITIES_MACRO_TYPE, r);
    return r;
  }

  // snmpReferPart?
  private static boolean snmpAgentCapabilitiesMacroType_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpAgentCapabilitiesMacroType_4")) return false;
    snmpReferPart(b, l + 1);
    return true;
  }

  // snmpModuleSupportPart*
  private static boolean snmpAgentCapabilitiesMacroType_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpAgentCapabilitiesMacroType_5")) return false;
    int c = current_position_(b);
    while (true) {
      if (!snmpModuleSupportPart(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "snmpAgentCapabilitiesMacroType_5", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // complianceGroup | complianceObject
  public static boolean snmpCompliancePart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpCompliancePart")) return false;
    if (!nextTokenIs(b, "<snmp compliance part>", GROUP, OBJECT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SNMP_COMPLIANCE_PART, "<snmp compliance part>");
    r = complianceGroup(b, l + 1);
    if (!r) r = complianceObject(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CONTACT_INFO STRING_LITERAL
  public static boolean snmpContactPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpContactPart")) return false;
    if (!nextTokenIs(b, CONTACT_INFO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CONTACT_INFO, STRING_LITERAL);
    exit_section_(b, m, SNMP_CONTACT_PART, r);
    return r;
  }

  /* ********************************************************** */
  // CREATION_REQUIRES LEFT_BRACE valueList RIGHT_BRACE
  public static boolean snmpCreationPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpCreationPart")) return false;
    if (!nextTokenIs(b, CREATION_REQUIRES)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CREATION_REQUIRES, LEFT_BRACE);
    r = r && valueList(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, SNMP_CREATION_PART, r);
    return r;
  }

  /* ********************************************************** */
  // DEFVAL LEFT_BRACE value RIGHT_BRACE
  public static boolean snmpDefValPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpDefValPart")) return false;
    if (!nextTokenIs(b, DEFVAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DEFVAL, LEFT_BRACE);
    r = r && value(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, SNMP_DEF_VAL_PART, r);
    return r;
  }

  /* ********************************************************** */
  // DESCRIPTION STRING_LITERAL
  public static boolean snmpDescrPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpDescrPart")) return false;
    if (!nextTokenIs(b, DESCRIPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DESCRIPTION, STRING_LITERAL);
    exit_section_(b, m, SNMP_DESCR_PART, r);
    return r;
  }

  /* ********************************************************** */
  // DISPLAY_HINT STRING_LITERAL
  public static boolean snmpDisplayPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpDisplayPart")) return false;
    if (!nextTokenIs(b, DISPLAY_HINT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DISPLAY_HINT, STRING_LITERAL);
    exit_section_(b, m, SNMP_DISPLAY_PART, r);
    return r;
  }

  /* ********************************************************** */
  // ENTERPRISE value
  public static boolean snmpEnterprisePart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpEnterprisePart")) return false;
    if (!nextTokenIs(b, ENTERPRISE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENTERPRISE);
    r = r && value(b, l + 1);
    exit_section_(b, m, SNMP_ENTERPRISE_PART, r);
    return r;
  }

  /* ********************************************************** */
  // (INDEX LEFT_BRACE indexValueList RIGHT_BRACE) | (AUGMENTS LEFT_BRACE value RIGHT_BRACE)
  public static boolean snmpIndexPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpIndexPart")) return false;
    if (!nextTokenIs(b, "<snmp index part>", AUGMENTS, INDEX)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SNMP_INDEX_PART, "<snmp index part>");
    r = snmpIndexPart_0(b, l + 1);
    if (!r) r = snmpIndexPart_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // INDEX LEFT_BRACE indexValueList RIGHT_BRACE
  private static boolean snmpIndexPart_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpIndexPart_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, INDEX, LEFT_BRACE);
    r = r && indexValueList(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // AUGMENTS LEFT_BRACE value RIGHT_BRACE
  private static boolean snmpIndexPart_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpIndexPart_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, AUGMENTS, LEFT_BRACE);
    r = r && value(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MANDATORY_GROUPS LEFT_BRACE valueList RIGHT_BRACE
  public static boolean snmpMandatoryPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpMandatoryPart")) return false;
    if (!nextTokenIs(b, MANDATORY_GROUPS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MANDATORY_GROUPS, LEFT_BRACE);
    r = r && valueList(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, SNMP_MANDATORY_PART, r);
    return r;
  }

  /* ********************************************************** */
  // MODULE_COMPLIANCE
  //                                   snmpStatusPart
  //                                   snmpDescrPart
  //                                   snmpReferPart?
  //                                   snmpModulePart+
  public static boolean snmpModuleComplianceMacroType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpModuleComplianceMacroType")) return false;
    if (!nextTokenIs(b, MODULE_COMPLIANCE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MODULE_COMPLIANCE);
    r = r && snmpStatusPart(b, l + 1);
    r = r && snmpDescrPart(b, l + 1);
    r = r && snmpModuleComplianceMacroType_3(b, l + 1);
    r = r && snmpModuleComplianceMacroType_4(b, l + 1);
    exit_section_(b, m, SNMP_MODULE_COMPLIANCE_MACRO_TYPE, r);
    return r;
  }

  // snmpReferPart?
  private static boolean snmpModuleComplianceMacroType_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpModuleComplianceMacroType_3")) return false;
    snmpReferPart(b, l + 1);
    return true;
  }

  // snmpModulePart+
  private static boolean snmpModuleComplianceMacroType_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpModuleComplianceMacroType_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = snmpModulePart(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!snmpModulePart(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "snmpModuleComplianceMacroType_4", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MODULE_IDENTITY
  //                                 snmpUpdatePart
  //                                 snmpOrganizationPart
  //                                 snmpContactPart
  //                                 snmpDescrPart
  //                                 snmpRevisionPart*
  public static boolean snmpModuleIdentityMacroType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpModuleIdentityMacroType")) return false;
    if (!nextTokenIs(b, MODULE_IDENTITY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MODULE_IDENTITY);
    r = r && snmpUpdatePart(b, l + 1);
    r = r && snmpOrganizationPart(b, l + 1);
    r = r && snmpContactPart(b, l + 1);
    r = r && snmpDescrPart(b, l + 1);
    r = r && snmpModuleIdentityMacroType_5(b, l + 1);
    exit_section_(b, m, SNMP_MODULE_IDENTITY_MACRO_TYPE, r);
    return r;
  }

  // snmpRevisionPart*
  private static boolean snmpModuleIdentityMacroType_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpModuleIdentityMacroType_5")) return false;
    int c = current_position_(b);
    while (true) {
      if (!snmpRevisionPart(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "snmpModuleIdentityMacroType_5", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // moduleIdentifier
  public static boolean snmpModuleImport(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpModuleImport")) return false;
    if (!nextTokenIs(b, IDENTIFIER_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = moduleIdentifier(b, l + 1);
    exit_section_(b, m, SNMP_MODULE_IMPORT, r);
    return r;
  }

  /* ********************************************************** */
  // MODULE snmpModuleImport? snmpMandatoryPart? snmpCompliancePart*
  public static boolean snmpModulePart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpModulePart")) return false;
    if (!nextTokenIs(b, MODULE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MODULE);
    r = r && snmpModulePart_1(b, l + 1);
    r = r && snmpModulePart_2(b, l + 1);
    r = r && snmpModulePart_3(b, l + 1);
    exit_section_(b, m, SNMP_MODULE_PART, r);
    return r;
  }

  // snmpModuleImport?
  private static boolean snmpModulePart_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpModulePart_1")) return false;
    snmpModuleImport(b, l + 1);
    return true;
  }

  // snmpMandatoryPart?
  private static boolean snmpModulePart_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpModulePart_2")) return false;
    snmpMandatoryPart(b, l + 1);
    return true;
  }

  // snmpCompliancePart*
  private static boolean snmpModulePart_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpModulePart_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!snmpCompliancePart(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "snmpModulePart_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // SUPPORTS snmpModuleImport INCLUDES LEFT_BRACE valueList RIGHT_BRACE snmpVariationPart*
  public static boolean snmpModuleSupportPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpModuleSupportPart")) return false;
    if (!nextTokenIs(b, SUPPORTS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SUPPORTS);
    r = r && snmpModuleImport(b, l + 1);
    r = r && consumeTokens(b, 0, INCLUDES, LEFT_BRACE);
    r = r && valueList(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    r = r && snmpModuleSupportPart_6(b, l + 1);
    exit_section_(b, m, SNMP_MODULE_SUPPORT_PART, r);
    return r;
  }

  // snmpVariationPart*
  private static boolean snmpModuleSupportPart_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpModuleSupportPart_6")) return false;
    int c = current_position_(b);
    while (true) {
      if (!snmpVariationPart(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "snmpModuleSupportPart_6", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // NOTIFICATION_GROUP
  //                                    snmpNotificationsPart
  //                                    snmpStatusPart
  //                                    snmpDescrPart
  //                                    snmpReferPart?
  public static boolean snmpNotificationGroupMacroType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpNotificationGroupMacroType")) return false;
    if (!nextTokenIs(b, NOTIFICATION_GROUP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NOTIFICATION_GROUP);
    r = r && snmpNotificationsPart(b, l + 1);
    r = r && snmpStatusPart(b, l + 1);
    r = r && snmpDescrPart(b, l + 1);
    r = r && snmpNotificationGroupMacroType_4(b, l + 1);
    exit_section_(b, m, SNMP_NOTIFICATION_GROUP_MACRO_TYPE, r);
    return r;
  }

  // snmpReferPart?
  private static boolean snmpNotificationGroupMacroType_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpNotificationGroupMacroType_4")) return false;
    snmpReferPart(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // NOTIFICATION_TYPE
  //                                   snmpObjectsPart?
  //                                   snmpStatusPart
  //                                   snmpDescrPart
  //                                   snmpReferPart?
  public static boolean snmpNotificationTypeMacroType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpNotificationTypeMacroType")) return false;
    if (!nextTokenIs(b, NOTIFICATION_TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NOTIFICATION_TYPE);
    r = r && snmpNotificationTypeMacroType_1(b, l + 1);
    r = r && snmpStatusPart(b, l + 1);
    r = r && snmpDescrPart(b, l + 1);
    r = r && snmpNotificationTypeMacroType_4(b, l + 1);
    exit_section_(b, m, SNMP_NOTIFICATION_TYPE_MACRO_TYPE, r);
    return r;
  }

  // snmpObjectsPart?
  private static boolean snmpNotificationTypeMacroType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpNotificationTypeMacroType_1")) return false;
    snmpObjectsPart(b, l + 1);
    return true;
  }

  // snmpReferPart?
  private static boolean snmpNotificationTypeMacroType_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpNotificationTypeMacroType_4")) return false;
    snmpReferPart(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // NOTIFICATIONS LEFT_BRACE valueList RIGHT_BRACE
  public static boolean snmpNotificationsPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpNotificationsPart")) return false;
    if (!nextTokenIs(b, NOTIFICATIONS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NOTIFICATIONS, LEFT_BRACE);
    r = r && valueList(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, SNMP_NOTIFICATIONS_PART, r);
    return r;
  }

  /* ********************************************************** */
  // OBJECT_GROUP
  //                              snmpObjectsPart
  //                              snmpStatusPart
  //                              snmpDescrPart
  //                              snmpReferPart?
  public static boolean snmpObjectGroupMacroType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpObjectGroupMacroType")) return false;
    if (!nextTokenIs(b, OBJECT_GROUP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OBJECT_GROUP);
    r = r && snmpObjectsPart(b, l + 1);
    r = r && snmpStatusPart(b, l + 1);
    r = r && snmpDescrPart(b, l + 1);
    r = r && snmpObjectGroupMacroType_4(b, l + 1);
    exit_section_(b, m, SNMP_OBJECT_GROUP_MACRO_TYPE, r);
    return r;
  }

  // snmpReferPart?
  private static boolean snmpObjectGroupMacroType_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpObjectGroupMacroType_4")) return false;
    snmpReferPart(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // OBJECT_IDENTITY
  //                                 snmpStatusPart
  //                                 snmpDescrPart
  //                                 snmpReferPart?
  public static boolean snmpObjectIdentityMacroType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpObjectIdentityMacroType")) return false;
    if (!nextTokenIs(b, OBJECT_IDENTITY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OBJECT_IDENTITY);
    r = r && snmpStatusPart(b, l + 1);
    r = r && snmpDescrPart(b, l + 1);
    r = r && snmpObjectIdentityMacroType_3(b, l + 1);
    exit_section_(b, m, SNMP_OBJECT_IDENTITY_MACRO_TYPE, r);
    return r;
  }

  // snmpReferPart?
  private static boolean snmpObjectIdentityMacroType_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpObjectIdentityMacroType_3")) return false;
    snmpReferPart(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // OBJECT_TYPE
  //                             snmpSyntaxPart
  //                             snmpUnitsPart?
  //                             snmpAccessPart
  //                             snmpStatusPart
  //                             snmpDescrPart?
  //                             snmpReferPart?
  //                             snmpIndexPart?
  //                             snmpDefValPart?
  public static boolean snmpObjectTypeMacroType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpObjectTypeMacroType")) return false;
    if (!nextTokenIs(b, OBJECT_TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OBJECT_TYPE);
    r = r && snmpSyntaxPart(b, l + 1);
    r = r && snmpObjectTypeMacroType_2(b, l + 1);
    r = r && snmpAccessPart(b, l + 1);
    r = r && snmpStatusPart(b, l + 1);
    r = r && snmpObjectTypeMacroType_5(b, l + 1);
    r = r && snmpObjectTypeMacroType_6(b, l + 1);
    r = r && snmpObjectTypeMacroType_7(b, l + 1);
    r = r && snmpObjectTypeMacroType_8(b, l + 1);
    exit_section_(b, m, SNMP_OBJECT_TYPE_MACRO_TYPE, r);
    return r;
  }

  // snmpUnitsPart?
  private static boolean snmpObjectTypeMacroType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpObjectTypeMacroType_2")) return false;
    snmpUnitsPart(b, l + 1);
    return true;
  }

  // snmpDescrPart?
  private static boolean snmpObjectTypeMacroType_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpObjectTypeMacroType_5")) return false;
    snmpDescrPart(b, l + 1);
    return true;
  }

  // snmpReferPart?
  private static boolean snmpObjectTypeMacroType_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpObjectTypeMacroType_6")) return false;
    snmpReferPart(b, l + 1);
    return true;
  }

  // snmpIndexPart?
  private static boolean snmpObjectTypeMacroType_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpObjectTypeMacroType_7")) return false;
    snmpIndexPart(b, l + 1);
    return true;
  }

  // snmpDefValPart?
  private static boolean snmpObjectTypeMacroType_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpObjectTypeMacroType_8")) return false;
    snmpDefValPart(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // OBJECTS LEFT_BRACE valueList RIGHT_BRACE
  public static boolean snmpObjectsPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpObjectsPart")) return false;
    if (!nextTokenIs(b, OBJECTS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, OBJECTS, LEFT_BRACE);
    r = r && valueList(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, SNMP_OBJECTS_PART, r);
    return r;
  }

  /* ********************************************************** */
  // ORGANIZATION STRING_LITERAL
  public static boolean snmpOrganizationPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpOrganizationPart")) return false;
    if (!nextTokenIs(b, ORGANIZATION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ORGANIZATION, STRING_LITERAL);
    exit_section_(b, m, SNMP_ORGANIZATION_PART, r);
    return r;
  }

  /* ********************************************************** */
  // PRODUCT_RELEASE STRING_LITERAL
  public static boolean snmpProductReleasePart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpProductReleasePart")) return false;
    if (!nextTokenIs(b, PRODUCT_RELEASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PRODUCT_RELEASE, STRING_LITERAL);
    exit_section_(b, m, SNMP_PRODUCT_RELEASE_PART, r);
    return r;
  }

  /* ********************************************************** */
  // REFERENCE STRING_LITERAL
  public static boolean snmpReferPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpReferPart")) return false;
    if (!nextTokenIs(b, REFERENCE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, REFERENCE, STRING_LITERAL);
    exit_section_(b, m, SNMP_REFER_PART, r);
    return r;
  }

  /* ********************************************************** */
  // REVISION value DESCRIPTION STRING_LITERAL
  public static boolean snmpRevisionPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpRevisionPart")) return false;
    if (!nextTokenIs(b, REVISION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REVISION);
    r = r && value(b, l + 1);
    r = r && consumeTokens(b, 0, DESCRIPTION, STRING_LITERAL);
    exit_section_(b, m, SNMP_REVISION_PART, r);
    return r;
  }

  /* ********************************************************** */
  // STATUS IDENTIFIER_STRING
  public static boolean snmpStatusPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpStatusPart")) return false;
    if (!nextTokenIs(b, STATUS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, STATUS, IDENTIFIER_STRING);
    exit_section_(b, m, SNMP_STATUS_PART, r);
    return r;
  }

  /* ********************************************************** */
  // SYNTAX type
  public static boolean snmpSyntaxPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpSyntaxPart")) return false;
    if (!nextTokenIs(b, SYNTAX)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SYNTAX);
    r = r && type(b, l + 1);
    exit_section_(b, m, SNMP_SYNTAX_PART, r);
    return r;
  }

  /* ********************************************************** */
  // TEXTUAL_CONVENTION
  //                                    snmpDisplayPart?
  //                                    snmpStatusPart
  //                                    snmpDescrPart
  //                                    snmpReferPart?
  //                                    snmpSyntaxPart
  public static boolean snmpTextualConventionMacroType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpTextualConventionMacroType")) return false;
    if (!nextTokenIs(b, TEXTUAL_CONVENTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TEXTUAL_CONVENTION);
    r = r && snmpTextualConventionMacroType_1(b, l + 1);
    r = r && snmpStatusPart(b, l + 1);
    r = r && snmpDescrPart(b, l + 1);
    r = r && snmpTextualConventionMacroType_4(b, l + 1);
    r = r && snmpSyntaxPart(b, l + 1);
    exit_section_(b, m, SNMP_TEXTUAL_CONVENTION_MACRO_TYPE, r);
    return r;
  }

  // snmpDisplayPart?
  private static boolean snmpTextualConventionMacroType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpTextualConventionMacroType_1")) return false;
    snmpDisplayPart(b, l + 1);
    return true;
  }

  // snmpReferPart?
  private static boolean snmpTextualConventionMacroType_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpTextualConventionMacroType_4")) return false;
    snmpReferPart(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // TRAP_TYPE
  //                           snmpEnterprisePart
  //                           snmpVarPart?
  //                           snmpDescrPart?
  //                           snmpReferPart?
  public static boolean snmpTrapTypeMacroType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpTrapTypeMacroType")) return false;
    if (!nextTokenIs(b, TRAP_TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRAP_TYPE);
    r = r && snmpEnterprisePart(b, l + 1);
    r = r && snmpTrapTypeMacroType_2(b, l + 1);
    r = r && snmpTrapTypeMacroType_3(b, l + 1);
    r = r && snmpTrapTypeMacroType_4(b, l + 1);
    exit_section_(b, m, SNMP_TRAP_TYPE_MACRO_TYPE, r);
    return r;
  }

  // snmpVarPart?
  private static boolean snmpTrapTypeMacroType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpTrapTypeMacroType_2")) return false;
    snmpVarPart(b, l + 1);
    return true;
  }

  // snmpDescrPart?
  private static boolean snmpTrapTypeMacroType_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpTrapTypeMacroType_3")) return false;
    snmpDescrPart(b, l + 1);
    return true;
  }

  // snmpReferPart?
  private static boolean snmpTrapTypeMacroType_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpTrapTypeMacroType_4")) return false;
    snmpReferPart(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // UNITS STRING_LITERAL
  public static boolean snmpUnitsPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpUnitsPart")) return false;
    if (!nextTokenIs(b, UNITS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, UNITS, STRING_LITERAL);
    exit_section_(b, m, SNMP_UNITS_PART, r);
    return r;
  }

  /* ********************************************************** */
  // LAST_UPDATED STRING_LITERAL
  public static boolean snmpUpdatePart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpUpdatePart")) return false;
    if (!nextTokenIs(b, LAST_UPDATED)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LAST_UPDATED, STRING_LITERAL);
    exit_section_(b, m, SNMP_UPDATE_PART, r);
    return r;
  }

  /* ********************************************************** */
  // VARIABLES LEFT_BRACE valueList RIGHT_BRACE
  public static boolean snmpVarPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpVarPart")) return false;
    if (!nextTokenIs(b, VARIABLES)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, VARIABLES, LEFT_BRACE);
    r = r && valueList(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, SNMP_VAR_PART, r);
    return r;
  }

  /* ********************************************************** */
  // VARIATION value snmpSyntaxPart? snmpWriteSyntaxPart? snmpAccessPart? snmpCreationPart? snmpDefValPart? snmpDescrPart
  public static boolean snmpVariationPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpVariationPart")) return false;
    if (!nextTokenIs(b, VARIATION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VARIATION);
    r = r && value(b, l + 1);
    r = r && snmpVariationPart_2(b, l + 1);
    r = r && snmpVariationPart_3(b, l + 1);
    r = r && snmpVariationPart_4(b, l + 1);
    r = r && snmpVariationPart_5(b, l + 1);
    r = r && snmpVariationPart_6(b, l + 1);
    r = r && snmpDescrPart(b, l + 1);
    exit_section_(b, m, SNMP_VARIATION_PART, r);
    return r;
  }

  // snmpSyntaxPart?
  private static boolean snmpVariationPart_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpVariationPart_2")) return false;
    snmpSyntaxPart(b, l + 1);
    return true;
  }

  // snmpWriteSyntaxPart?
  private static boolean snmpVariationPart_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpVariationPart_3")) return false;
    snmpWriteSyntaxPart(b, l + 1);
    return true;
  }

  // snmpAccessPart?
  private static boolean snmpVariationPart_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpVariationPart_4")) return false;
    snmpAccessPart(b, l + 1);
    return true;
  }

  // snmpCreationPart?
  private static boolean snmpVariationPart_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpVariationPart_5")) return false;
    snmpCreationPart(b, l + 1);
    return true;
  }

  // snmpDefValPart?
  private static boolean snmpVariationPart_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpVariationPart_6")) return false;
    snmpDefValPart(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // WRITE_SYNTAX type
  public static boolean snmpWriteSyntaxPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snmpWriteSyntaxPart")) return false;
    if (!nextTokenIs(b, WRITE_SYNTAX)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WRITE_SYNTAX);
    r = r && type(b, l + 1);
    exit_section_(b, m, SNMP_WRITE_SYNTAX_PART, r);
    return r;
  }

  /* ********************************************************** */
  // PLUS_INFINITY | MINUS_INFINITY
  public static boolean specialRealValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "specialRealValue")) return false;
    if (!nextTokenIs(b, "<special real value>", MINUS_INFINITY, PLUS_INFINITY)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SPECIAL_REAL_VALUE, "<special real value>");
    r = consumeToken(b, PLUS_INFINITY);
    if (!r) r = consumeToken(b, MINUS_INFINITY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OCTET_STRING constraintList?
  public static boolean stringType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringType")) return false;
    if (!nextTokenIs(b, OCTET_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OCTET_STRING);
    r = r && stringType_1(b, l + 1);
    exit_section_(b, m, STRING_TYPE, r);
    return r;
  }

  // constraintList?
  private static boolean stringType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringType_1")) return false;
    constraintList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // STRING_LITERAL
  public static boolean stringValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringValue")) return false;
    if (!nextTokenIs(b, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING_LITERAL);
    exit_section_(b, m, STRING_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // symbolName | definedMacroName
  public static boolean symbol(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "symbol")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SYMBOL, "<symbol>");
    r = symbolName(b, l + 1);
    if (!r) r = definedMacroName(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<comma_separated_list symbol>>
  static boolean symbolList(PsiBuilder b, int l) {
    return comma_separated_list(b, l + 1, symbol_parser_);
  }

  /* ********************************************************** */
  // IDENTIFIER_STRING
  public static boolean symbolName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "symbolName")) return false;
    if (!nextTokenIs(b, IDENTIFIER_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER_STRING);
    exit_section_(b, m, SYMBOL_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // symbolList FROM moduleIdentifier
  public static boolean symbolsFromModule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "symbolsFromModule")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SYMBOLS_FROM_MODULE, "<symbols from module>");
    r = symbolList(b, l + 1);
    r = r && consumeToken(b, FROM);
    r = r && moduleIdentifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACKET classType? NUMBER_LITERAL RIGHT_BRACKET
  public static boolean tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag")) return false;
    if (!nextTokenIs(b, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACKET);
    r = r && tag_1(b, l + 1);
    r = r && consumeTokens(b, 0, NUMBER_LITERAL, RIGHT_BRACKET);
    exit_section_(b, m, TAG, r);
    return r;
  }

  // classType?
  private static boolean tag_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_1")) return false;
    classType(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (EXPLICIT|IMPLICIT) TAGS
  public static boolean tagDefault(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagDefault")) return false;
    if (!nextTokenIs(b, "<tag default>", EXPLICIT, IMPLICIT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TAG_DEFAULT, "<tag default>");
    r = tagDefault_0(b, l + 1);
    r = r && consumeToken(b, TAGS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // EXPLICIT|IMPLICIT
  private static boolean tagDefault_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagDefault_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXPLICIT);
    if (!r) r = consumeToken(b, IMPLICIT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // tag explicitOrImplicitTag? type
  public static boolean taggedType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "taggedType")) return false;
    if (!nextTokenIs(b, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tag(b, l + 1);
    r = r && taggedType_1(b, l + 1);
    r = r && type(b, l + 1);
    exit_section_(b, m, TAGGED_TYPE, r);
    return r;
  }

  // explicitOrImplicitTag?
  private static boolean taggedType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "taggedType_1")) return false;
    explicitOrImplicitTag(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // builtinType | definedType | definedMacroType | macroDefinition
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, TYPE, "<type>");
    r = builtinType(b, l + 1);
    if (!r) r = definedType(b, l + 1);
    if (!r) r = definedMacroType(b, l + 1);
    if (!r) r = macroDefinition(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // typeName DEFINITION type
  public static boolean typeAssignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeAssignment")) return false;
    if (!nextTokenIs(b, IDENTIFIER_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = typeName(b, l + 1);
    r = r && consumeToken(b, DEFINITION);
    r = r && type(b, l + 1);
    exit_section_(b, m, TYPE_ASSIGNMENT, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER_STRING
  public static boolean typeName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeName")) return false;
    if (!nextTokenIs(b, IDENTIFIER_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER_STRING);
    exit_section_(b, m, TYPE_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // value | MAX
  public static boolean upperEndPoint(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "upperEndPoint")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UPPER_END_POINT, "<upper end point>");
    r = value(b, l + 1);
    if (!r) r = consumeToken(b, MAX);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // builtinValue | definedValue
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, VALUE, "<value>");
    r = builtinValue(b, l + 1);
    if (!r) r = definedValue(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // mibNode type DEFINITION value
  public static boolean valueAssignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valueAssignment")) return false;
    if (!nextTokenIs(b, IDENTIFIER_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = mibNode(b, l + 1);
    r = r && type(b, l + 1);
    r = r && consumeToken(b, DEFINITION);
    r = r && value(b, l + 1);
    exit_section_(b, m, VALUE_ASSIGNMENT, r);
    return r;
  }

  /* ********************************************************** */
  // lowerEndPoint valueRange?
  public static boolean valueConstraint(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valueConstraint")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE_CONSTRAINT, "<value constraint>");
    r = lowerEndPoint(b, l + 1);
    r = r && valueConstraint_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // valueRange?
  private static boolean valueConstraint_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valueConstraint_1")) return false;
    valueRange(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LEFT_PAREN <<bar_separated_list valueConstraint>> RIGHT_PAREN
  static boolean valueConstraintList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valueConstraintList")) return false;
    if (!nextTokenIs(b, LEFT_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PAREN);
    r = r && bar_separated_list(b, l + 1, valueConstraint_parser_);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<comma_separated_list value>>
  static boolean valueList(PsiBuilder b, int l) {
    return comma_separated_list(b, l + 1, value_parser_);
  }

  /* ********************************************************** */
  // namedNumberList | constraintList
  public static boolean valueOrConstraintList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valueOrConstraintList")) return false;
    if (!nextTokenIs(b, "<value or constraint list>", LEFT_BRACE, LEFT_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE_OR_CONSTRAINT_LIST, "<value or constraint list>");
    r = namedNumberList(b, l + 1);
    if (!r) r = constraintList(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LESS_THAN? DOUBLE_DOT LESS_THAN? upperEndPoint
  public static boolean valueRange(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valueRange")) return false;
    if (!nextTokenIs(b, "<value range>", DOUBLE_DOT, LESS_THAN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE_RANGE, "<value range>");
    r = valueRange_0(b, l + 1);
    r = r && consumeToken(b, DOUBLE_DOT);
    r = r && valueRange_2(b, l + 1);
    r = r && upperEndPoint(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LESS_THAN?
  private static boolean valueRange_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valueRange_0")) return false;
    consumeToken(b, LESS_THAN);
    return true;
  }

  // LESS_THAN?
  private static boolean valueRange_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valueRange_2")) return false;
    consumeToken(b, LESS_THAN);
    return true;
  }

  final static Parser constraint_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return constraint(b, l + 1);
    }
  };
  final static Parser elementTyp_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return elementTyp(b, l + 1);
    }
  };
  final static Parser end_rule_recover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return end_rule_recover(b, l + 1);
    }
  };
  final static Parser indexValue_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return indexValue(b, l + 1);
    }
  };
  final static Parser namedNumber_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return namedNumber(b, l + 1);
    }
  };
  final static Parser symbol_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return symbol(b, l + 1);
    }
  };
  final static Parser valueConstraint_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return valueConstraint(b, l + 1);
    }
  };
  final static Parser value_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return value(b, l + 1);
    }
  };
}
