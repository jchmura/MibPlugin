package pl.jakubchmura.snmp.mib.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.MibFileType;

public class SmiElementFactory {

    private static final String DUMMY_FILE_NAME = "dummy.mib";

    public static PsiElement createElement(Project project, String name) {
        MibFile file = createFile(project, name);
        return file.getFirstChild();
    }

    public static MibFile createFile(Project project, String text) {
        return (MibFile) PsiFileFactory.getInstance(project).createFileFromText(DUMMY_FILE_NAME, MibFileType.INSTANCE, text);
    }


}
