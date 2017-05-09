package pl.jakubchmura.snmp.mib;

import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StandardSnmpv2Mibs {

    private static final String DIRECTORY = "/pl/jakubchmura/snmp/mib/mibs/";
    private static final List<String> FILE_NAMES = Arrays.asList("SNMPv2-SMI", "SNMPv2-TC", "SNMPv2-CONF");

    public static List<VirtualFile> getMibs() {
        return FILE_NAMES.stream()
                .map(s -> DIRECTORY + s)
                .map(StandardSnmpv2Mibs.class::getResource)
                .map(VfsUtil::findFileByURL)
                .collect(Collectors.toList());
    }

}
