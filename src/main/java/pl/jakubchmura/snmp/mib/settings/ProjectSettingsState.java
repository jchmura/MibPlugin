package pl.jakubchmura.snmp.mib.settings;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Disposer;
import org.jdom.Element;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

@State(
        name = "pl.jakubchmura.snmp.mib.settings.ProjectSettingsState",
        storages = @Storage("MibSupportPlugin.xml")
)
public class ProjectSettingsState implements PersistentStateComponent<Element>, Disposable {

    @NonNls
    private static final String FILE = "file";
    @NonNls
    private static final String DIRECTORY = "directory";
    @NonNls
    private static final String URL = "url";
    @NonNls
    private static final String INCLUDE_SUBDIRECTORIES = "includeSubdirectories";

    public List<AdditionalMibPath> additionalMibPathList = new ArrayList<>();
    private AdditionalMibPath[] cachedPaths = null;

    public static ProjectSettingsState getInstance(Project project) {
        return project.getService(ProjectSettingsState.class);
    }

    public synchronized AdditionalMibPath[] getAdditionalMibPaths() {
        if (cachedPaths == null) {
            cachedPaths = additionalMibPathList.toArray(new AdditionalMibPath[0]);
        }
        return cachedPaths;
    }

    public synchronized void addAdditionalMibPath(AdditionalMibPath mibPath) {
        additionalMibPathList.add(mibPath);
        cachedPaths = null;
    }

    public synchronized void removeAllAdditionalMibPaths() {
        additionalMibPathList.clear();
        cachedPaths = null;
    }

    @Override
    public @Nullable Element getState() {
        Element root = new Element("root");
        for (AdditionalMibPath additionalMibPath : additionalMibPathList) {
            Element entry;
            if (additionalMibPath.isFile()) {
                entry = new Element(FILE);
            } else {
                entry = new Element(DIRECTORY);
                entry.setAttribute(INCLUDE_SUBDIRECTORIES,
                        Boolean.toString(additionalMibPath.isIncludeSubdirectories()));
            }
            entry.setAttribute(URL, additionalMibPath.getUrl());
            root.addContent(entry);
        }
        return root;
    }

    @Override
    public void loadState(@NotNull Element state) {
        removeAllAdditionalMibPaths();
        for (Element element : state.getChildren()) {
            String url = element.getAttributeValue(URL);
            if (url == null) {
                continue;
            }
            if (FILE.equals(element.getName())) {
                AdditionalMibPath mibPath = new AdditionalMibPath(url, false, true, this);
                additionalMibPathList.add(mibPath);
            }
            if (DIRECTORY.equals(element.getName())) {
                boolean includeSubdirectories = Boolean.parseBoolean(element.getAttributeValue(INCLUDE_SUBDIRECTORIES));
                AdditionalMibPath mibPath = new AdditionalMibPath(url, includeSubdirectories, false, this);
                additionalMibPathList.add(mibPath);
            }
        }
    }

    @Override
    public void dispose() {
        for (AdditionalMibPath additionalMibPath : additionalMibPathList) {
            Disposer.dispose(additionalMibPath);
        }
    }
}
