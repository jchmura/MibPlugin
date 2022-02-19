package pl.jakubchmura.snmp.mib.settings;

import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.IdeFocusManager;
import com.intellij.ui.JBColor;
import com.intellij.ui.PanelWithButtons;
import com.intellij.ui.RightAlignedLabelUI;
import com.intellij.ui.ToolbarDecorator;
import com.intellij.ui.table.JBTable;
import com.intellij.util.ui.JBUI;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class AdditionalMibsPanel extends PanelWithButtons {
    private final Project project;
    private final FileChooserDescriptor descriptor;
    private final List<AdditionalMibPath> additionalMibPathList;
    JBTable table;
    private JButton removeButton;

    public AdditionalMibsPanel(@NotNull Project project, FileChooserDescriptor descriptor,
                               List<AdditionalMibPath> additionalMibPathList) {
        this.project = project;
        this.descriptor = descriptor;
        this.additionalMibPathList = additionalMibPathList;
        initPanel();
    }

    @Override
    protected String getLabelText() {
        return null;
    }

    @Override
    protected JButton[] createButtons() {
        final JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> addPath(descriptor));

        removeButton = new JButton("Remove");
        removeButton.addActionListener(e -> removePaths());
        removeButton.setEnabled(false);
        removeButton.getModel().addChangeListener(e -> {
            if (table.getSelectedRow() == -1) {
                removeButton.setEnabled(false);
            }
        });

        return new JButton[]{/*addButton, removeButton*/};
    }

    private void addPath(FileChooserDescriptor descriptor) {
        int selected = additionalMibPathList.size();
        int savedSelected = selected;
        VirtualFile[] chosen = FileChooser.chooseFiles(descriptor, project, null);
        for (final VirtualFile chosenFile : chosen) {
            if (isPathAdded(chosenFile)) {
                continue;
            }
            AdditionalMibPath path;
            if (chosenFile.isDirectory()) {
                path = new AdditionalMibPath(chosenFile, true, false, project);
            } else {
                path = new AdditionalMibPath(chosenFile, false, true, project);
            }
            additionalMibPathList.add(selected, path);
            selected++;
        }
        if (selected > savedSelected) { // actually added something
            AbstractTableModel model = (AbstractTableModel) table.getModel();
            model.fireTableRowsInserted(savedSelected, selected - 1);
            table.setRowSelectionInterval(savedSelected, selected - 1);
        }
    }

    private boolean isPathAdded(VirtualFile file) {
        for (final AdditionalMibPath additionalMibPath : additionalMibPathList) {
            final VirtualFile descriptionFile = additionalMibPath.getVirtualFile();
            if (descriptionFile == null) {
                continue;
            }
            if (file.equals(descriptionFile)) {
                return true;
            }
        }
        return false;
    }

    private void removePaths() {
        int[] selected = table.getSelectedRows();
        if (selected == null || selected.length <= 0) {
            return;
        }
        if (table.isEditing()) {
            TableCellEditor editor = table.getCellEditor();
            if (editor != null) {
                editor.stopCellEditing();
            }
        }
        AbstractTableModel model = (AbstractTableModel) table.getModel();
        Arrays.sort(selected);
        int indexToSelect = selected[selected.length - 1];
        int removedCount = 0;
        for (int indexToRemove : selected) {
            final int row = indexToRemove - removedCount;
            AdditionalMibPath path = additionalMibPathList.get(row);
            Disposer.dispose(path);
            additionalMibPathList.remove(row);
            model.fireTableRowsDeleted(row, row);
            removedCount += 1;
        }
        if (indexToSelect >= additionalMibPathList.size()) {
            indexToSelect = additionalMibPathList.size() - 1;
        }
        if (indexToSelect >= 0) {
            table.setRowSelectionInterval(indexToSelect, indexToSelect);
        }
        IdeFocusManager.getGlobalInstance().doWhenFocusSettlesDown(() -> IdeFocusManager.getGlobalInstance().requestFocus(table, true));
    }

    @Override
    protected JComponent createMainComponent() {
        final String[] names = {"Path", "Recursively"};

        // Create a model of the data.
        TableModel dataModel = new AbstractTableModel() {
            @Override
            public int getColumnCount() {
                return names.length;
            }

            @Override
            public int getRowCount() {
                return additionalMibPathList.size();
            }

            @Override
            public Object getValueAt(int row, int col) {
                AdditionalMibPath additionalMibPath = additionalMibPathList.get(row);
                if (col == 0) {
                    return additionalMibPath.getPresentableUrl();
                }
                if (col == 1) {
                    if (!additionalMibPath.isFile()) {
                        return additionalMibPath.isIncludeSubdirectories();
                    } else {
                        return null;
                    }
                }
                return null;
            }

            @Override
            public String getColumnName(int column) {
                return names[column];
            }

            @Override
            public Class<?> getColumnClass(int c) {
                if (c == 0) {
                    return String.class;
                }
                if (c == 1) {
                    return Boolean.class;
                }
                return null;
            }

            @Override
            public boolean isCellEditable(int row, int col) {
                if (col == 1) {
                    AdditionalMibPath path = additionalMibPathList.get(row);
                    return !path.isFile();
                }
                return true;
            }

            @Override
            public void setValueAt(Object aValue, int row, int col) {
                AdditionalMibPath additionalMibPath = additionalMibPathList.get(row);
                if (col == 1) {
                    additionalMibPath.setIncludeSubdirectories(aValue.equals(Boolean.TRUE));
                } else {
                    final String path = (String) aValue;
                    additionalMibPath.setPresentableUrl(path);
                }
            }
        };

        table = new JBTable(dataModel);
        table.setShowGrid(false);
        table.setEnableAntialiasing(true);

        table.getEmptyText().setText("No additional MIBs");
        table.setPreferredScrollableViewportSize(JBUI.size(300, -1));
        table.setVisibleRowCount(6);
        table.setDefaultRenderer(Boolean.class, new BooleanRenderer());
        table.setDefaultRenderer(Object.class, new ObjectRenderer());
        table.getColumn(names[0]).setPreferredWidth(350);
        final int cbWidth = 15 + table.getTableHeader().getFontMetrics(table.getTableHeader().getFont()).stringWidth(names[1]);
        final TableColumn cbColumn = table.getColumn(names[1]);
        cbColumn.setPreferredWidth(cbWidth);
        cbColumn.setMaxWidth(cbWidth);
        table.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.getSelectionModel().addListSelectionListener(e -> removeButton.setEnabled(table.getSelectedRow() >= 0));
        TableCellEditor editor = table.getDefaultEditor(String.class);
        if (editor instanceof DefaultCellEditor) {
            ((DefaultCellEditor) editor).setClickCountToStart(1);
        }

        return ToolbarDecorator.createDecorator(table)
                .disableUpAction()
                .disableDownAction()
                .setAddAction(anActionButton -> addPath(descriptor))
                .setRemoveAction(anActionButton -> removePaths()).createPanel();
    }

    private static class BooleanRenderer extends JCheckBox implements TableCellRenderer {
        private final JPanel panel = new JPanel();

        BooleanRenderer() {
            setHorizontalAlignment(CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus,
                                                       int row, int column) {
            if (value == null) {
                if (isSelected) {
                    panel.setBackground(table.getSelectionBackground());
                } else {
                    panel.setBackground(table.getBackground());
                }
                return panel;
            }
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                super.setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(table.getBackground());
            }
            setSelected((Boolean) value);
            return this;
        }
    }

    private class ObjectRenderer extends DefaultTableCellRenderer {
        ObjectRenderer() {
            setUI(new RightAlignedLabelUI());
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            final Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            final AdditionalMibPath path = additionalMibPathList.get(row);
            component.setForeground(!path.isValid() ? JBColor.RED : isSelected ? table.getSelectionForeground() : table.getForeground());
            component.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
            return component;
        }
    }
}
