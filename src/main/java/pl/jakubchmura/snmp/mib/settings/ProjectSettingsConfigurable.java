package pl.jakubchmura.snmp.mib.settings;

import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Comparing;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.vcs.FileStatusManager;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ProjectSettingsConfigurable implements Configurable, Configurable.NoScroll {

    private final Project project;
    private final List<AdditionalMibPath> additionalMibPathList = new ArrayList<>();
    private final FileChooserDescriptor descriptor;
    private final ProjectSettingsState state;
    private AdditionalMibsPanel panel;

    @SuppressWarnings("unused")
    public ProjectSettingsConfigurable(Project project) {
        this(project, new FileChooserDescriptor(true, true, false, false, false, true),
                ProjectSettingsState.getInstance(project));
    }

    public ProjectSettingsConfigurable(Project project, FileChooserDescriptor descriptor, ProjectSettingsState state) {
        this.project = project;
        this.descriptor = descriptor;
        this.state = state;
    }

    @Override
    public void reset() {
        AdditionalMibPath[] mibPaths = state.getAdditionalMibPaths();
        disposeMibPaths();
        for (AdditionalMibPath mibPath : mibPaths) {
            additionalMibPathList.add(mibPath.copy(project));
        }
        ((AbstractTableModel) panel.table.getModel()).fireTableDataChanged();
    }

    public void addEntry(AdditionalMibPath mibPath) {
        additionalMibPathList.add(mibPath);
        ((AbstractTableModel) panel.table.getModel()).fireTableDataChanged();
    }

    private void disposeMibPaths() {
        for (AdditionalMibPath mibPath : additionalMibPathList) {
            Disposer.dispose(mibPath);
        }
        additionalMibPathList.clear();
    }

    @Override
    public void apply() {
        state.removeAllAdditionalMibPaths();
        for (AdditionalMibPath mibPath : additionalMibPathList) {
            state.addAdditionalMibPath(mibPath.copy(project));
        }
        FileStatusManager.getInstance(project).fileStatusesChanged(); // refresh exclude from compile status
    }

    @Override
    public boolean isModified() {
        AdditionalMibPath[] mibPaths = state.getAdditionalMibPaths();
        if (mibPaths.length != additionalMibPathList.size()) {
            return true;
        }
        for (int i = 0; i < mibPaths.length; i++) {
            AdditionalMibPath mibPath = mibPaths[i];
            if (!Comparing.equal(mibPath, additionalMibPathList.get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public JComponent createComponent() {
        if (panel == null) {
            panel = new AdditionalMibsPanel(project, descriptor, additionalMibPathList);
        }
        return panel;
    }

    @Override
    public void disposeUIResources() {
        panel = null;
    }

    @Override
    public String getDisplayName() {
        return "Additional MIB Paths";
    }
}
