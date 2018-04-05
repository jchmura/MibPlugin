// This is a generated file. Not intended for manual editing.
package pl.jakubchmura.snmp.mib.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;
import com.intellij.navigation.ItemPresentation;

public interface SmiTypeName extends SmiReferenceableElement, StubBasedPsiElement<TextualConventionStub> {

  @NotNull
  PsiElement getIdentifierString();

  @NotNull
  String getName();

  PsiElement setName(String name);

  ItemPresentation getPresentation();

  SmiTypeAssignment getParentAssignment();

}
