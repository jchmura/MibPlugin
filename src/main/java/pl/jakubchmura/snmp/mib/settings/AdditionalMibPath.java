package pl.jakubchmura.snmp.mib.settings;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.VfsUtilCore;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.pointers.VirtualFilePointer;
import com.intellij.openapi.vfs.pointers.VirtualFilePointerManager;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class AdditionalMibPath implements Disposable {
    private final Disposable parentDisposable;
    private boolean isFile;
    private boolean includeSubdirectories;
    private VirtualFilePointer filePointer;

    public AdditionalMibPath(String url, boolean includeSubdirectories, boolean isFile, Disposable parent) {
        parentDisposable = parent;
        filePointer = VirtualFilePointerManager.getInstance().create(url, parent, null);
        this.includeSubdirectories = includeSubdirectories;
        this.isFile = isFile;
    }

    public AdditionalMibPath(VirtualFile virtualFile, boolean includeSubdirectories, boolean isFile, Disposable parent) {
        this(virtualFile.getUrl(), includeSubdirectories, isFile, parent);
    }

    public AdditionalMibPath copy(Disposable parent) {
        return new AdditionalMibPath(getUrl(), includeSubdirectories, isFile, parent);
    }

    public boolean isFile() {
        return isFile;
    }

    public String getUrl() {
        return filePointer.getUrl();
    }

    public String getPresentableUrl() {
        return filePointer.getPresentableUrl();
    }

    void setPresentableUrl(String newUrl) {
        filePointer = VirtualFilePointerManager.getInstance().create(VfsUtilCore.pathToUrl(FileUtil.toSystemIndependentName(newUrl)), parentDisposable, null);
        final VirtualFile file = getVirtualFile();
        if (file != null) {
            isFile = !file.isDirectory();
        }
    }

    public boolean isIncludeSubdirectories() {
        return includeSubdirectories;
    }

    void setIncludeSubdirectories(boolean includeSubdirectories) {
        this.includeSubdirectories = includeSubdirectories;
    }

    @Nullable
    public VirtualFile getVirtualFile() {
        return filePointer.getFile();
    }

    public boolean isValid() {
        return filePointer.isValid();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AdditionalMibPath)) {
            return false;
        }
        AdditionalMibPath additionalMibPath = (AdditionalMibPath) obj;
        if (additionalMibPath.isFile != isFile) {
            return false;
        }
        if (additionalMibPath.includeSubdirectories != includeSubdirectories) {
            return false;
        }
        return Objects.equals(additionalMibPath.getUrl(), getUrl());
    }

    public int hashCode() {
        int result = (isFile ? 1 : 0);
        result = 31 * result + (includeSubdirectories ? 1 : 0);
        result = 31 * result + getUrl().hashCode();
        return result;
    }

    @Override
    public void dispose() {
    }
}