package pl.jakubchmura.snmp.mib;

import com.intellij.openapi.fileTypes.*;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public class MibFileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer consumer) {
        consumer.consume(MibFileType.INSTANCE, filenameMatchers());
    }

    private FileNameMatcher[] filenameMatchers() {
        return Stream.concat(extensionMatchers(), wildcardMatchers()).toArray(FileNameMatcher[]::new);
    }

    private Stream<FileNameMatcher> extensionMatchers() {
        return Stream.of("mib", "my").map(ExtensionFileNameMatcher::new);
    }

    private Stream<FileNameMatcher> wildcardMatchers() {
        return Stream.of("*-MIB", "*-TC", "*-SMI", "*-CONF").map(WildcardFileNameMatcher::new);
    }
}
