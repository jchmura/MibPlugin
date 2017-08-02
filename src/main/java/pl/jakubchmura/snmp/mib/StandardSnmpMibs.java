package pl.jakubchmura.snmp.mib;

import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StandardSnmpMibs {

    private static final String DIRECTORY = "/pl/jakubchmura/snmp/mib/mibs/";
    private static final List<String> FILE_NAMES = Arrays.asList("SNMPv2-SMI", "SNMPv2-TC", "SNMPv2-CONF", "RFC1155-SMI");

    public static final List<VirtualFile> MIBS = FILE_NAMES.stream()
            .map(s -> DIRECTORY + s)
            .map(StandardSnmpMibs.class::getResource)
            .map(VfsUtil::findFileByURL)
            .collect(Collectors.toList());

}
