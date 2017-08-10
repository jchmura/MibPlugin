package pl.jakubchmura.snmp.mib;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StandardSnmpMibs {

    private static final String DIRECTORY = "/pl/jakubchmura/snmp/mib/mibs/";
    private static final List<String> FILE_NAMES = Arrays.asList("SNMPv2-SMI", "SNMPv2-TC", "SNMPv2-CONF", "RFC1155-SMI");

    public static final List<VirtualFile> MIBS = FILE_NAMES.stream()
            .map(s -> DIRECTORY + s)
            .map(StandardSnmpMibs.class::getResource)
            .map(VfsUtil::findFileByURL)
            .collect(Collectors.toList());

    private static List<PsiFile> PSI_FILES;

    public static Stream<MibFile> getMibFiles(@NotNull Project project) {
        return MIBS.stream()
                .map(virtualFile -> PsiManager.getInstance(project).findFile(virtualFile))
                .filter(psiFile -> psiFile instanceof MibFile)
                .map(MibFile.class::cast);
    }

}
