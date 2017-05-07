package pl.jakubchmura.snmp.mib;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static pl.jakubchmura.snmp.mib.psi.SmiTypes.*;

%%

%{
  public _SmiLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _SmiLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

BINARY_LITERAL=[0-1]*(B|b)
HEXADECIMAL_LITERAL=[0-9A-Fa-f]*(H|h)
STRING_LITERAL=\"([^\"]|\"\")*\"
IDENTIFIER_STRING=[a-zA-Z][a-zA-Z0-9_-]*
NUMBER_LITERAL=[0-9]+
SPACE=[ \t\n\x0B\f\r]+
COMMENT=--.*

%%
<YYINITIAL> {
  {WHITE_SPACE}              { return WHITE_SPACE; }

  "."                        { return DOT; }
  ".."                       { return DOUBLE_DOT; }
  "..."                      { return TRIPLE_DOT; }
  ","                        { return COMMA; }
  ";"                        { return SEMI_COLON; }
  "("                        { return LEFT_PAREN; }
  ")"                        { return RIGHT_PAREN; }
  "{"                        { return LEFT_BRACE; }
  "}"                        { return RIGHT_BRACE; }
  "["                        { return LEFT_BRACKET; }
  "]"                        { return RIGHT_BRACKET; }
  "-"                        { return MINUS; }
  "<"                        { return LESS_THAN; }
  "|"                        { return VERTICAL_BAR; }
  "::="                      { return DEFINITION; }
  "PRIVATE"                  { return PRIVATE; }
  "OBJECT IDENTIFIER"        { return OBJECT_IDENTIFIER; }
  "OCTET STRING"             { return OCTET_STRING; }
  "BIT STRING"               { return BIT_STRING; }
  "PLUS-INFINITY"            { return PLUS_INFINITY; }
  "MINUS-INFINITY"           { return MINUS_INFINITY; }
  "MODULE-IDENTITY"          { return MODULE_IDENTITY; }
  "OBJECT-IDENTITY"          { return OBJECT_IDENTITY; }
  "OBJECT-TYPE"              { return OBJECT_TYPE; }
  "NOTIFICATION-TYPE"        { return NOTIFICATION_TYPE; }
  "TRAP-TYPE"                { return TRAP_TYPE; }
  "TEXTUAL-CONVENTION"       { return TEXTUAL_CONVENTION; }
  "OBJECT-GROUP"             { return OBJECT_GROUP; }
  "NOTIFICATION-GROUP"       { return NOTIFICATION_GROUP; }
  "MODULE-COMPLIANCE"        { return MODULE_COMPLIANCE; }
  "AGENT-CAPABILITIES"       { return AGENT_CAPABILITIES; }
  "LAST-UPDATED"             { return LAST_UPDATED; }
  "CONTACT-INFO"             { return CONTACT_INFO; }
  "MAX-ACCESS"               { return MAX_ACCESS; }
  "MIN-ACCESS"               { return MIN_ACCESS; }
  "DISPLAY-HINT"             { return DISPLAY_HINT; }
  "MANDATORY-GROUPS"         { return MANDATORY_GROUPS; }
  "WRITE-SYNTAX"             { return WRITE_SYNTAX; }
  "PRODUCT-RELEASE"          { return PRODUCT_RELEASE; }
  "CREATION-REQUIRES"        { return CREATION_REQUIRES; }
  "DEFINITIONS"              { return DEFINITIONS; }
  "BEGIN"                    { return BEGIN; }
  "END"                      { return END; }
  "EXPLICIT"                 { return EXPLICIT; }
  "IMPLICIT"                 { return IMPLICIT; }
  "TAGS"                     { return TAGS; }
  "EXPORTS"                  { return EXPORTS; }
  "IMPORTS"                  { return IMPORTS; }
  "FROM"                     { return FROM; }
  "MACRO"                    { return MACRO; }
  "INTEGER"                  { return INTEGER; }
  "REAL"                     { return REAL; }
  "BOOLEAN"                  { return BOOLEAN; }
  "NULL"                     { return NULL; }
  "BIT"                      { return BIT; }
  "OCTET"                    { return OCTET; }
  "STRING"                   { return STRING; }
  "OBJECT"                   { return OBJECT; }
  "IDENTIFIER"               { return IDENTIFIER; }
  "BITS"                     { return BITS; }
  "SEQUENCE"                 { return SEQUENCE; }
  "OF"                       { return OF; }
  "SET"                      { return SET; }
  "CHOICE"                   { return CHOICE; }
  "ENUMERATED"               { return ENUMERATED; }
  "ANY"                      { return ANY; }
  "DEFINED"                  { return DEFINED; }
  "BY"                       { return BY; }
  "UNIVERSAL"                { return UNIVERSAL; }
  "APPLICATION"              { return APPLICATION; }
  "COMPONENTS"               { return COMPONENTS; }
  "OPTIONAL"                 { return OPTIONAL; }
  "DEFAULT"                  { return DEFAULT; }
  "MIN"                      { return MIN; }
  "MAX"                      { return MAX; }
  "SIZE"                     { return SIZE; }
  "INCLUDES"                 { return INCLUDES; }
  "WITH"                     { return WITH; }
  "PRESENT"                  { return PRESENT; }
  "ABSENT"                   { return ABSENT; }
  "TRUE"                     { return TRUE; }
  "FALSE"                    { return FALSE; }
  "ORGANIZATION"             { return ORGANIZATION; }
  "DESCRIPTION"              { return DESCRIPTION; }
  "REVISION"                 { return REVISION; }
  "STATUS"                   { return STATUS; }
  "REFERENCE"                { return REFERENCE; }
  "SYNTAX"                   { return SYNTAX; }
  "UNITS"                    { return UNITS; }
  "ACCESS"                   { return ACCESS; }
  "INDEX"                    { return INDEX; }
  "AUGMENTS"                 { return AUGMENTS; }
  "IMPLIED"                  { return IMPLIED; }
  "DEFVAL"                   { return DEFVAL; }
  "OBJECTS"                  { return OBJECTS; }
  "ENTERPRISE"               { return ENTERPRISE; }
  "VARIABLES"                { return VARIABLES; }
  "NOTIFICATIONS"            { return NOTIFICATIONS; }
  "MODULE"                   { return MODULE; }
  "GROUP"                    { return GROUP; }
  "SUPPORTS"                 { return SUPPORTS; }
  "VARIATION"                { return VARIATION; }

  {BINARY_LITERAL}           { return BINARY_LITERAL; }
  {HEXADECIMAL_LITERAL}      { return HEXADECIMAL_LITERAL; }
  {STRING_LITERAL}           { return STRING_LITERAL; }
  {IDENTIFIER_STRING}        { return IDENTIFIER_STRING; }
  {NUMBER_LITERAL}           { return NUMBER_LITERAL; }
  {SPACE}                    { return SPACE; }
  {COMMENT}                  { return COMMENT; }

}

[^] { return BAD_CHARACTER; }
