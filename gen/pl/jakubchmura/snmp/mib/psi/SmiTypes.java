// This is a generated file. Not intended for manual editing.
package pl.jakubchmura.snmp.mib.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import pl.jakubchmura.snmp.mib.psi.impl.*;

public interface SmiTypes {

  IElementType ASSIGNMENT = SmiElementTypeFactory.createType("ASSIGNMENT");
  IElementType BIT_OR_OBJECT_IDENTIFIER_VALUE = SmiElementTypeFactory.createType("BIT_OR_OBJECT_IDENTIFIER_VALUE");
  IElementType BUILTIN_TYPE = SmiElementTypeFactory.createType("BUILTIN_TYPE");
  IElementType BUILTIN_VALUE = SmiElementTypeFactory.createType("BUILTIN_VALUE");
  IElementType CHOICE_TYPE = SmiElementTypeFactory.createType("CHOICE_TYPE");
  IElementType DEFINED_MACRO_TYPE = SmiElementTypeFactory.createType("DEFINED_MACRO_TYPE");
  IElementType DEFINED_TYPE = SmiElementTypeFactory.createType("DEFINED_TYPE");
  IElementType DEFINED_TYPE_NAME = SmiElementTypeFactory.createType("DEFINED_TYPE_NAME");
  IElementType DEFINED_VALUE_NAME = SmiElementTypeFactory.createType("DEFINED_VALUE_NAME");
  IElementType ELEMENT_TYP = SmiElementTypeFactory.createType("ELEMENT_TYP");
  IElementType ELEMENT_TYPE_NAME = SmiElementTypeFactory.createType("ELEMENT_TYPE_NAME");
  IElementType EXPORT_LIST = SmiElementTypeFactory.createType("EXPORT_LIST");
  IElementType IMPORT_LIST = SmiElementTypeFactory.createType("IMPORT_LIST");
  IElementType INDEX_TYPE = SmiElementTypeFactory.createType("INDEX_TYPE");
  IElementType INDEX_VALUE = SmiElementTypeFactory.createType("INDEX_VALUE");
  IElementType MIB_NODE = SmiElementTypeFactory.createType("MIB_NODE");
  IElementType MODULE_DEFINITION = SmiElementTypeFactory.createType("MODULE_DEFINITION");
  IElementType MODULE_IDENTIFIER = SmiElementTypeFactory.createType("MODULE_IDENTIFIER");
  IElementType MODULE_IDENTIFIER_DEFINITION = SmiElementTypeFactory.createType("MODULE_IDENTIFIER_DEFINITION");
  IElementType NAMED_NUMBER = SmiElementTypeFactory.createType("NAMED_NUMBER");
  IElementType NAME_AND_NUMBER = SmiElementTypeFactory.createType("NAME_AND_NUMBER");
  IElementType NAME_VALUE_INDEX = SmiElementTypeFactory.createType("NAME_VALUE_INDEX");
  IElementType NAME_VALUE_STRING = SmiElementTypeFactory.createType("NAME_VALUE_STRING");
  IElementType NUMBER = SmiElementTypeFactory.createType("NUMBER");
  IElementType SEQUENCE_OF_TYPE = SmiElementTypeFactory.createType("SEQUENCE_OF_TYPE");
  IElementType SEQUENCE_TYPE = SmiElementTypeFactory.createType("SEQUENCE_TYPE");
  IElementType SNMP_AGENT_CAPABILITIES_MACRO_TYPE = SmiElementTypeFactory.createType("SNMP_AGENT_CAPABILITIES_MACRO_TYPE");
  IElementType SNMP_DEF_VAL_PART = SmiElementTypeFactory.createType("SNMP_DEF_VAL_PART");
  IElementType SNMP_DESCR_PART = SmiElementTypeFactory.createType("SNMP_DESCR_PART");
  IElementType SNMP_ENTERPRISE_PART = SmiElementTypeFactory.createType("SNMP_ENTERPRISE_PART");
  IElementType SNMP_INDEX_PART = SmiElementTypeFactory.createType("SNMP_INDEX_PART");
  IElementType SNMP_MODULE_COMPLIANCE_MACRO_TYPE = SmiElementTypeFactory.createType("SNMP_MODULE_COMPLIANCE_MACRO_TYPE");
  IElementType SNMP_MODULE_IDENTITY_MACRO_TYPE = SmiElementTypeFactory.createType("SNMP_MODULE_IDENTITY_MACRO_TYPE");
  IElementType SNMP_NOTIFICATION_GROUP_MACRO_TYPE = SmiElementTypeFactory.createType("SNMP_NOTIFICATION_GROUP_MACRO_TYPE");
  IElementType SNMP_NOTIFICATION_TYPE_MACRO_TYPE = SmiElementTypeFactory.createType("SNMP_NOTIFICATION_TYPE_MACRO_TYPE");
  IElementType SNMP_OBJECTS_PART = SmiElementTypeFactory.createType("SNMP_OBJECTS_PART");
  IElementType SNMP_OBJECT_GROUP_MACRO_TYPE = SmiElementTypeFactory.createType("SNMP_OBJECT_GROUP_MACRO_TYPE");
  IElementType SNMP_OBJECT_IDENTITY_MACRO_TYPE = SmiElementTypeFactory.createType("SNMP_OBJECT_IDENTITY_MACRO_TYPE");
  IElementType SNMP_OBJECT_TYPE_MACRO_TYPE = SmiElementTypeFactory.createType("SNMP_OBJECT_TYPE_MACRO_TYPE");
  IElementType SNMP_SYNTAX_PART = SmiElementTypeFactory.createType("SNMP_SYNTAX_PART");
  IElementType SNMP_TEXTUAL_CONVENTION_MACRO_TYPE = SmiElementTypeFactory.createType("SNMP_TEXTUAL_CONVENTION_MACRO_TYPE");
  IElementType SNMP_TRAP_TYPE_MACRO_TYPE = SmiElementTypeFactory.createType("SNMP_TRAP_TYPE_MACRO_TYPE");
  IElementType SNMP_VAR_PART = SmiElementTypeFactory.createType("SNMP_VAR_PART");
  IElementType SYMBOL = SmiElementTypeFactory.createType("SYMBOL");
  IElementType SYMBOLS_FROM_MODULE = SmiElementTypeFactory.createType("SYMBOLS_FROM_MODULE");
  IElementType SYMBOL_NAME = SmiElementTypeFactory.createType("SYMBOL_NAME");
  IElementType TYPE = SmiElementTypeFactory.createType("TYPE");
  IElementType TYPE_ASSIGNMENT = SmiElementTypeFactory.createType("TYPE_ASSIGNMENT");
  IElementType TYPE_NAME = SmiElementTypeFactory.createType("TYPE_NAME");
  IElementType VALUE = SmiElementTypeFactory.createType("VALUE");
  IElementType VALUE_ASSIGNMENT = SmiElementTypeFactory.createType("VALUE_ASSIGNMENT");
  IElementType VALUE_LIST = SmiElementTypeFactory.createType("VALUE_LIST");

  IElementType ABSENT = new SmiTokenType("ABSENT");
  IElementType ACCESS = new SmiTokenType("ACCESS");
  IElementType AGENT_CAPABILITIES = new SmiTokenType("AGENT-CAPABILITIES");
  IElementType ANY = new SmiTokenType("ANY");
  IElementType APPLICATION = new SmiTokenType("APPLICATION");
  IElementType AUGMENTS = new SmiTokenType("AUGMENTS");
  IElementType BEGIN = new SmiTokenType("BEGIN");
  IElementType BINARY_LITERAL = new SmiTokenType("BINARY_LITERAL");
  IElementType BIT = new SmiTokenType("BIT");
  IElementType BITS = new SmiTokenType("BITS");
  IElementType BIT_STRING = new SmiTokenType("BIT STRING");
  IElementType BOOLEAN = new SmiTokenType("BOOLEAN");
  IElementType BY = new SmiTokenType("BY");
  IElementType CHOICE = new SmiTokenType("CHOICE");
  IElementType COMMA = new SmiTokenType(",");
  IElementType COMMENT = new SmiTokenType("comment");
  IElementType COMPONENTS = new SmiTokenType("COMPONENTS");
  IElementType CONTACT_INFO = new SmiTokenType("CONTACT-INFO");
  IElementType CREATION_REQUIRES = new SmiTokenType("CREATION-REQUIRES");
  IElementType DEFAULT = new SmiTokenType("DEFAULT");
  IElementType DEFINED = new SmiTokenType("DEFINED");
  IElementType DEFINITION = new SmiTokenType("::=");
  IElementType DEFINITIONS = new SmiTokenType("DEFINITIONS");
  IElementType DEFVAL = new SmiTokenType("DEFVAL");
  IElementType DESCRIPTION = new SmiTokenType("DESCRIPTION");
  IElementType DISPLAY_HINT = new SmiTokenType("DISPLAY-HINT");
  IElementType DOT = new SmiTokenType(".");
  IElementType DOUBLE_DOT = new SmiTokenType("..");
  IElementType END = new SmiTokenType("END");
  IElementType ENTERPRISE = new SmiTokenType("ENTERPRISE");
  IElementType ENUMERATED = new SmiTokenType("ENUMERATED");
  IElementType EXPLICIT = new SmiTokenType("EXPLICIT");
  IElementType EXPORTS = new SmiTokenType("EXPORTS");
  IElementType FALSE = new SmiTokenType("FALSE");
  IElementType FROM = new SmiTokenType("FROM");
  IElementType GROUP = new SmiTokenType("GROUP");
  IElementType HEXADECIMAL_LITERAL = new SmiTokenType("HEXADECIMAL_LITERAL");
  IElementType IDENTIFIER = new SmiTokenType("IDENTIFIER");
  IElementType IDENTIFIER_STRING = new SmiTokenType("IDENTIFIER_STRING");
  IElementType IMPLICIT = new SmiTokenType("IMPLICIT");
  IElementType IMPLIED = new SmiTokenType("IMPLIED");
  IElementType IMPORTS = new SmiTokenType("IMPORTS");
  IElementType INCLUDES = new SmiTokenType("INCLUDES");
  IElementType INDEX = new SmiTokenType("INDEX");
  IElementType INTEGER = new SmiTokenType("INTEGER");
  IElementType LAST_UPDATED = new SmiTokenType("LAST-UPDATED");
  IElementType LEFT_BRACE = new SmiTokenType("{");
  IElementType LEFT_BRACKET = new SmiTokenType("[");
  IElementType LEFT_PAREN = new SmiTokenType("(");
  IElementType LESS_THAN = new SmiTokenType("<");
  IElementType MACRO = new SmiTokenType("MACRO");
  IElementType MANDATORY_GROUPS = new SmiTokenType("MANDATORY-GROUPS");
  IElementType MAX = new SmiTokenType("MAX");
  IElementType MAX_ACCESS = new SmiTokenType("MAX-ACCESS");
  IElementType MIN = new SmiTokenType("MIN");
  IElementType MINUS = new SmiTokenType("-");
  IElementType MINUS_INFINITY = new SmiTokenType("MINUS-INFINITY");
  IElementType MIN_ACCESS = new SmiTokenType("MIN-ACCESS");
  IElementType MODULE = new SmiTokenType("MODULE");
  IElementType MODULE_COMPLIANCE = new SmiTokenType("MODULE-COMPLIANCE");
  IElementType MODULE_IDENTITY = new SmiTokenType("MODULE-IDENTITY");
  IElementType NOTIFICATIONS = new SmiTokenType("NOTIFICATIONS");
  IElementType NOTIFICATION_GROUP = new SmiTokenType("NOTIFICATION-GROUP");
  IElementType NOTIFICATION_TYPE = new SmiTokenType("NOTIFICATION-TYPE");
  IElementType NULL = new SmiTokenType("NULL");
  IElementType NUMBER_LITERAL = new SmiTokenType("NUMBER_LITERAL");
  IElementType OBJECT = new SmiTokenType("OBJECT");
  IElementType OBJECTS = new SmiTokenType("OBJECTS");
  IElementType OBJECT_GROUP = new SmiTokenType("OBJECT-GROUP");
  IElementType OBJECT_IDENTIFIER = new SmiTokenType("OBJECT IDENTIFIER");
  IElementType OBJECT_IDENTITY = new SmiTokenType("OBJECT-IDENTITY");
  IElementType OBJECT_TYPE = new SmiTokenType("OBJECT-TYPE");
  IElementType OCTET = new SmiTokenType("OCTET");
  IElementType OCTET_STRING = new SmiTokenType("OCTET STRING");
  IElementType OF = new SmiTokenType("OF");
  IElementType OPTIONAL = new SmiTokenType("OPTIONAL");
  IElementType ORGANIZATION = new SmiTokenType("ORGANIZATION");
  IElementType PLUS_INFINITY = new SmiTokenType("PLUS-INFINITY");
  IElementType PRESENT = new SmiTokenType("PRESENT");
  IElementType PRIVATE = new SmiTokenType("PRIVATE");
  IElementType PRODUCT_RELEASE = new SmiTokenType("PRODUCT-RELEASE");
  IElementType REAL = new SmiTokenType("REAL");
  IElementType REFERENCE = new SmiTokenType("REFERENCE");
  IElementType REVISION = new SmiTokenType("REVISION");
  IElementType RIGHT_BRACE = new SmiTokenType("}");
  IElementType RIGHT_BRACKET = new SmiTokenType("]");
  IElementType RIGHT_PAREN = new SmiTokenType(")");
  IElementType SEMI_COLON = new SmiTokenType(";");
  IElementType SEQUENCE = new SmiTokenType("SEQUENCE");
  IElementType SET = new SmiTokenType("SET");
  IElementType SIZE = new SmiTokenType("SIZE");
  IElementType STATUS = new SmiTokenType("STATUS");
  IElementType STRING = new SmiTokenType("STRING");
  IElementType STRING_LITERAL = new SmiTokenType("STRING_LITERAL");
  IElementType SUPPORTS = new SmiTokenType("SUPPORTS");
  IElementType SYNTAX = new SmiTokenType("SYNTAX");
  IElementType TAGS = new SmiTokenType("TAGS");
  IElementType TEXTUAL_CONVENTION = new SmiTokenType("TEXTUAL-CONVENTION");
  IElementType TRAP_TYPE = new SmiTokenType("TRAP-TYPE");
  IElementType TRIPLE_DOT = new SmiTokenType("...");
  IElementType TRUE = new SmiTokenType("TRUE");
  IElementType UNITS = new SmiTokenType("UNITS");
  IElementType UNIVERSAL = new SmiTokenType("UNIVERSAL");
  IElementType VARIABLES = new SmiTokenType("VARIABLES");
  IElementType VARIATION = new SmiTokenType("VARIATION");
  IElementType VERTICAL_BAR = new SmiTokenType("|");
  IElementType WITH = new SmiTokenType("WITH");
  IElementType WRITE_SYNTAX = new SmiTokenType("WRITE-SYNTAX");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ASSIGNMENT) {
        return new SmiAssignmentImpl(node);
      }
      else if (type == BIT_OR_OBJECT_IDENTIFIER_VALUE) {
        return new SmiBitOrObjectIdentifierValueImpl(node);
      }
      else if (type == BUILTIN_TYPE) {
        return new SmiBuiltinTypeImpl(node);
      }
      else if (type == BUILTIN_VALUE) {
        return new SmiBuiltinValueImpl(node);
      }
      else if (type == CHOICE_TYPE) {
        return new SmiChoiceTypeImpl(node);
      }
      else if (type == DEFINED_TYPE) {
        return new SmiDefinedTypeImpl(node);
      }
      else if (type == DEFINED_TYPE_NAME) {
        return new SmiDefinedTypeNameImpl(node);
      }
      else if (type == DEFINED_VALUE_NAME) {
        return new SmiDefinedValueNameImpl(node);
      }
      else if (type == ELEMENT_TYP) {
        return new SmiElementTypImpl(node);
      }
      else if (type == ELEMENT_TYPE_NAME) {
        return new SmiElementTypeNameImpl(node);
      }
      else if (type == EXPORT_LIST) {
        return new SmiExportListImpl(node);
      }
      else if (type == IMPORT_LIST) {
        return new SmiImportListImpl(node);
      }
      else if (type == INDEX_TYPE) {
        return new SmiIndexTypeImpl(node);
      }
      else if (type == INDEX_VALUE) {
        return new SmiIndexValueImpl(node);
      }
      else if (type == MIB_NODE) {
        return new SmiMibNodeImpl(node);
      }
      else if (type == MODULE_DEFINITION) {
        return new SmiModuleDefinitionImpl(node);
      }
      else if (type == MODULE_IDENTIFIER) {
        return new SmiModuleIdentifierImpl(node);
      }
      else if (type == MODULE_IDENTIFIER_DEFINITION) {
        return new SmiModuleIdentifierDefinitionImpl(node);
      }
      else if (type == NAMED_NUMBER) {
        return new SmiNamedNumberImpl(node);
      }
      else if (type == NAME_AND_NUMBER) {
        return new SmiNameAndNumberImpl(node);
      }
      else if (type == NAME_VALUE_INDEX) {
        return new SmiNameValueIndexImpl(node);
      }
      else if (type == NAME_VALUE_STRING) {
        return new SmiNameValueStringImpl(node);
      }
      else if (type == NUMBER) {
        return new SmiNumberImpl(node);
      }
      else if (type == SEQUENCE_OF_TYPE) {
        return new SmiSequenceOfTypeImpl(node);
      }
      else if (type == SEQUENCE_TYPE) {
        return new SmiSequenceTypeImpl(node);
      }
      else if (type == SNMP_AGENT_CAPABILITIES_MACRO_TYPE) {
        return new SmiSnmpAgentCapabilitiesMacroTypeImpl(node);
      }
      else if (type == SNMP_DEF_VAL_PART) {
        return new SmiSnmpDefValPartImpl(node);
      }
      else if (type == SNMP_DESCR_PART) {
        return new SmiSnmpDescrPartImpl(node);
      }
      else if (type == SNMP_ENTERPRISE_PART) {
        return new SmiSnmpEnterprisePartImpl(node);
      }
      else if (type == SNMP_INDEX_PART) {
        return new SmiSnmpIndexPartImpl(node);
      }
      else if (type == SNMP_MODULE_COMPLIANCE_MACRO_TYPE) {
        return new SmiSnmpModuleComplianceMacroTypeImpl(node);
      }
      else if (type == SNMP_MODULE_IDENTITY_MACRO_TYPE) {
        return new SmiSnmpModuleIdentityMacroTypeImpl(node);
      }
      else if (type == SNMP_NOTIFICATION_GROUP_MACRO_TYPE) {
        return new SmiSnmpNotificationGroupMacroTypeImpl(node);
      }
      else if (type == SNMP_NOTIFICATION_TYPE_MACRO_TYPE) {
        return new SmiSnmpNotificationTypeMacroTypeImpl(node);
      }
      else if (type == SNMP_OBJECTS_PART) {
        return new SmiSnmpObjectsPartImpl(node);
      }
      else if (type == SNMP_OBJECT_GROUP_MACRO_TYPE) {
        return new SmiSnmpObjectGroupMacroTypeImpl(node);
      }
      else if (type == SNMP_OBJECT_IDENTITY_MACRO_TYPE) {
        return new SmiSnmpObjectIdentityMacroTypeImpl(node);
      }
      else if (type == SNMP_OBJECT_TYPE_MACRO_TYPE) {
        return new SmiSnmpObjectTypeMacroTypeImpl(node);
      }
      else if (type == SNMP_SYNTAX_PART) {
        return new SmiSnmpSyntaxPartImpl(node);
      }
      else if (type == SNMP_TEXTUAL_CONVENTION_MACRO_TYPE) {
        return new SmiSnmpTextualConventionMacroTypeImpl(node);
      }
      else if (type == SNMP_TRAP_TYPE_MACRO_TYPE) {
        return new SmiSnmpTrapTypeMacroTypeImpl(node);
      }
      else if (type == SNMP_VAR_PART) {
        return new SmiSnmpVarPartImpl(node);
      }
      else if (type == SYMBOL) {
        return new SmiSymbolImpl(node);
      }
      else if (type == SYMBOLS_FROM_MODULE) {
        return new SmiSymbolsFromModuleImpl(node);
      }
      else if (type == SYMBOL_NAME) {
        return new SmiSymbolNameImpl(node);
      }
      else if (type == TYPE) {
        return new SmiTypeImpl(node);
      }
      else if (type == TYPE_ASSIGNMENT) {
        return new SmiTypeAssignmentImpl(node);
      }
      else if (type == TYPE_NAME) {
        return new SmiTypeNameImpl(node);
      }
      else if (type == VALUE) {
        return new SmiValueImpl(node);
      }
      else if (type == VALUE_ASSIGNMENT) {
        return new SmiValueAssignmentImpl(node);
      }
      else if (type == VALUE_LIST) {
        return new SmiValueListImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
