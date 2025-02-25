/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import db.DBConnectionManager;
import db.DatabaseUtils;
import db.TasksDB;
import helper.CurrentSession;
import helper.CustomTableHeader;
import helper.JDateChooserEditor;
import helper.TableCellListener;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import model.Priority;
import model.Status;
import model.Task;

/**
 *
 * @author samtheradiant
 */
public class TasksScreen extends javax.swing.JPanel {

    int projectID;

    /**
     * Creates new form TasksScreen
     */
    public TasksScreen(int projectID) {
        this.projectID = projectID;
        initComponents();
        populateTable();
    }

    public TasksScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        topPanel = new javax.swing.JPanel();
        rightBtnsPanel = new javax.swing.JPanel();
        createTaskBtn = new javax.swing.JButton();
        scanBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        centerPanel = new javax.swing.JPanel();
        hintLbl = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tasksTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(21, 25, 34));
        setLayout(new java.awt.BorderLayout());

        topPanel.setBackground(new java.awt.Color(21, 25, 34));
        topPanel.setMinimumSize(new java.awt.Dimension(20, 0));

        rightBtnsPanel.setBackground(new java.awt.Color(21, 25, 34));

        createTaskBtn.setBackground(new java.awt.Color(21, 25, 34));
        createTaskBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus.png"))); // NOI18N
        createTaskBtn.setToolTipText("Create project");
        createTaskBtn.setBorderPainted(false);
        createTaskBtn.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus-pressed.png"))); // NOI18N
        createTaskBtn.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        // createTaskBtn.putClientProperty("JButton.buttonType", "roundRect");
        createTaskBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTaskBtnActionPerformed(evt);
            }
        });

        scanBtn.setBackground(new java.awt.Color(21, 25, 34));
        scanBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/rotate-right.png"))); // NOI18N
        scanBtn.setToolTipText("Scan for projects");
        scanBtn.setBorderPainted(false);
        scanBtn.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/rotate-right-pressed.png"))); // NOI18N
        // scanBtn.putClientProperty("JButton.buttonType", "roundRect");
        scanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(21, 25, 34));
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash.png"))); // NOI18N
        deleteBtn.setToolTipText("Delete selected row(s)");
        deleteBtn.setBorderPainted(false);
        deleteBtn.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash-can-disabled-2.png"))); // NOI18N
        deleteBtn.setEnabled(false);
        deleteBtn.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash-pressed.png"))); // NOI18N
        // deleteBtn.putClientProperty("JButton.buttonType", "roundRect");
        //deleteBtn.putClientProperty("Button.borderWidth", 2);
        //deleteBtn.putClientProperty("Button.hoverBorderColor", new Color(45, 168, 216));
        //deleteBtn.putClientProperty("Button.borderColor", new Color(21, 25, 34));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rightBtnsPanelLayout = new javax.swing.GroupLayout(rightBtnsPanel);
        rightBtnsPanel.setLayout(rightBtnsPanelLayout);
        rightBtnsPanelLayout.setHorizontalGroup(
            rightBtnsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightBtnsPanelLayout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(deleteBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scanBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createTaskBtn)
                .addContainerGap())
        );
        rightBtnsPanelLayout.setVerticalGroup(
            rightBtnsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightBtnsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(rightBtnsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteBtn)
                    .addComponent(scanBtn)
                    .addComponent(createTaskBtn))
                .addContainerGap())
        );

        centerPanel.setBackground(new java.awt.Color(21, 25, 34));
        centerPanel.setLayout(new java.awt.BorderLayout());

        hintLbl.setFont(new java.awt.Font("sansserif", 2, 13)); // NOI18N
        hintLbl.setForeground(new java.awt.Color(45, 168, 216));
        hintLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hintLbl.setText("Double click to edit!");
        hintLbl.setVisible(false);
        centerPanel.add(hintLbl, java.awt.BorderLayout.CENTER);

        backBtn.setBackground(new java.awt.Color(21, 25, 34));
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        backBtn.setBorderPainted(false);
        backBtn.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back-pressed.png"))); // NOI18N
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn)
                .addGap(44, 44, 44)
                .addComponent(centerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rightBtnsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(centerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addComponent(rightBtnsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(topPanel, java.awt.BorderLayout.PAGE_START);

        tasksTable.setBackground(new java.awt.Color(21, 25, 34));
        tasksTable.setForeground(new java.awt.Color(221, 255, 255));
        tasksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Description", "Start Date", "Deadline", "Status", "Priority", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tasksTable.setFillsViewportHeight(true);
        tasksTable.setGridColor(new java.awt.Color(49, 49, 49));
        tasksTable.setRowHeight(25);
        tasksTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tasksTable.setShowGrid(false);
        tasksTable.setShowHorizontalLines(true);
        tasksTable.setTableHeader(new CustomTableHeader(tasksTable.getColumnModel()));
        // Set Enum columns' editor to be a JComboBox

        tasksTable.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(new JComboBox<>(Status.values())));
        tasksTable.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new JComboBox<>(Priority.values())));
        tasksTable.getColumnModel().getColumn(1).setCellEditor(new JDateChooserEditor(new JTextField()));
        tasksTable.getColumnModel().getColumn(2).setCellEditor(new JDateChooserEditor(new JTextField()));

        // Listener for list selection
        tasksTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent ev) {
                handleButtonsVisiblity();
            }
        });

        // Set click to start editing
        for (int i = 0; i <= 4; i++) {
            DefaultCellEditor cellEditor = (DefaultCellEditor) tasksTable.getColumnModel().getColumn(i).getCellEditor();
            try {
                cellEditor.setClickCountToStart(2);
            }
            catch (NullPointerException ex) {
                // pass
            }
        }

        TableColumnModel columnModel = tasksTable.getColumnModel();
        columnModel.removeColumn(tasksTable.getColumnModel().getColumn(5));

        JTableHeader tableHeader = tasksTable.getTableHeader();
        tableHeader.setFont(new Font(tasksTable.getFont().getFontName(), Font.BOLD, tasksTable.getFont().getSize()));

        Action action = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                TableCellListener tcl = (TableCellListener)e.getSource();
                updateCell(tcl);
                //        System.out.println("Row   : " + tcl.getRow());
                //        System.out.println("Column: " + tcl.getColumn());
                //        System.out.println("Old   : " + tcl.getOldValue());
                //        System.out.println("New   : " + tcl.getNewValue());
            }
        };

        TableCellListener tcl = new TableCellListener(tasksTable, action);
        tasksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tasksTableclickHandler(evt);
            }
        });
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jScrollPane1.setViewportView(tasksTable);
        if (tasksTable.getColumnModel().getColumnCount() > 0) {
            tasksTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            tasksTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            tasksTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
            tasksTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
            tasksTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        }

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private boolean checkPermission() {
        if (CurrentSession.getAccountType().equals("Normal")) {
            try {
                if (!(DatabaseUtils.checkPermission(projectID))) {
                    return false;
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
        return true;
    }

    private void updateCell(TableCellListener tcl) {
        int row = tcl.getRow();
        int column = tcl.getColumn();
        if (!(checkPermission())) {
            JOptionPane.showMessageDialog(this, "You are not allowed to edit task properties of this project.", "Permission Error", JOptionPane.ERROR_MESSAGE);
            tasksTable.setValueAt(tcl.getOldValue(), row, column);
        }
        int taskID = (int) tasksTable.getModel().getValueAt(row, 5);
        System.out.println("Task Id: " + taskID);
        System.out.println(tasksTable.getColumnName(column));
        switch (column) {
            // For "Description" Column
            case 0:
                String oldDesc = (String) tcl.getOldValue();
                String newDesc = (String) tcl.getNewValue();
                try {
                    TasksDB.updateDesc(taskID, newDesc);
                    System.out.println("New Description Set");
                } catch (SQLException ex) {
                    tasksTable.setValueAt(oldDesc, row, column);
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
                break;
            // For "Start Date" Column
            case 1:
                // This works but I don't know how
                // The old value's origin is LocalDate so maybe that's why
                LocalDate oldStartDate = (LocalDate) tcl.getOldValue();

                // Type-casting to LocalDate wierdly gets us a String first from getNewValue() which 
                // cannot be type-casted to LocalDate
                LocalDate newStartDate = LocalDate.parse((String) tcl.getNewValue());
                LocalDate currentEndDate = (LocalDate) tasksTable.getValueAt(row, 2);
                if (newStartDate.compareTo(currentEndDate) > 0) {
                    JOptionPane.showMessageDialog(this, "Start Date cannot be greater than deadline date", "Date Error", JOptionPane.ERROR_MESSAGE);
                    tasksTable.setValueAt(oldStartDate, row, column);
                    break;
                }
                try {
                    TasksDB.updateStartDate(taskID, newStartDate);
                    System.out.println("New Start Date Set");
                } catch (SQLException ex) {
                    tasksTable.setValueAt(oldStartDate, row, column);
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
                break;
            // For "Deadline" Column
            case 2:
                // This works but I don't know how
                // The old value's origin is LocalDate so maybe that's why
                LocalDate oldEndDate = (LocalDate) tcl.getOldValue();

                // Type-casting to LocalDate wierdly gets us a String first from getNewValue() which 
                // cannot be type-casted to LocalDate
                LocalDate newEndDate = LocalDate.parse(tcl.getNewValue().toString());
                LocalDate currentStartDate = LocalDate.parse(tasksTable.getValueAt(row, 1).toString());
                if (newEndDate.compareTo(currentStartDate) < 0) {
                    JOptionPane.showMessageDialog(this, "Deadline Date cannot be less than start date", "Date Error", JOptionPane.ERROR_MESSAGE);
                    tasksTable.setValueAt(oldEndDate, row, column);
                    break;
                }
                try {
                    TasksDB.updateEndDate(taskID, newEndDate);
                    System.out.println("New End Date Set");
                } catch (SQLException ex) {
                    tasksTable.setValueAt(oldEndDate, row, column);
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
                break;
            // For "Status" Column
            case 3:
                Status oldStatus = Status.getEnum(tcl.getOldValue().toString());
                Status newStatus = Status.getEnum(tcl.getNewValue().toString());
                try {
                    TasksDB.updateStatus(taskID, newStatus);
                    System.out.println("New Status Set");
                } catch (SQLException ex) {
                    tasksTable.setValueAt(oldStatus, row, column);
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
                break;
            case 4:
                Priority oldPriority = Priority.getEnum(tcl.getOldValue().toString());
                Priority newPriority = Priority.getEnum(tcl.getNewValue().toString());
                try {
                    TasksDB.updatePriority(taskID, newPriority);
                    System.out.println("New Status Set");
                } catch (SQLException ex) {
                    tasksTable.setValueAt(oldPriority, row, column);
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
                break;
        }
    }

    private void handleButtonsVisiblity() {
        deleteBtn.setEnabled(true);

    }

    private void tasksTableclickHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tasksTableclickHandler
        int rowIndex = tasksTable.rowAtPoint(evt.getPoint());
        if (rowIndex < 0) {
            tasksTable.clearSelection();
            hintLbl.setVisible(false);
//            showTasksBtn.setVisible(false);
            deleteBtn.setEnabled(false);
//            infoBtn.setEnabled(false);
        } else {
            hintLbl.setVisible(true);
        }
    }//GEN-LAST:event_tasksTableclickHandler

    private void createTaskBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTaskBtnActionPerformed
        if (!(checkPermission())) {
            JOptionPane.showMessageDialog(this, "You are not allowed to add tasks to this project.", "Permission Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Window parentWindow = SwingUtilities.windowForComponent(this);
        Frame parentFrame = null;
        if (parentWindow instanceof Frame frame) {
            parentFrame = frame;
        }
        CreateTask screen1 = new CreateTask(parentFrame, true, this);
        screen1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        screen1.setLocationRelativeTo(this);
        screen1.setVisible(true);
    }//GEN-LAST:event_createTaskBtnActionPerformed

    private void scanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanBtnActionPerformed
        refreshTable();
    }//GEN-LAST:event_scanBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the task(s)?", "Confirm Action", JOptionPane.YES_NO_OPTION);
        switch (option) {
            case JOptionPane.NO_OPTION:
                return;
        }
        try {
            if (!(DatabaseUtils.checkPermission(this.projectID))) {
                JOptionPane.showMessageDialog(this, "You are not allowed to delete tasks of this project.", "Permission Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ArrayList<Integer> taskIDs = new ArrayList<>();
        int[] rowIndices = tasksTable.getSelectedRows();
        for (int rowIndex : rowIndices) {
            int targetProjectID = (int) tasksTable.getModel().getValueAt(rowIndex, 5);

            taskIDs.add(targetProjectID);
        }
        try {
            TasksDB.deleteTasks(taskIDs);
            DefaultTableModel model = (DefaultTableModel) tasksTable.getModel();
            for (int i = rowIndices.length - 1; i >= 0; i--) {
                model.removeRow(rowIndices[i]);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error deleting tasks: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.setProjectID(0);
        DefaultTableModel model = (DefaultTableModel) tasksTable.getModel();
        model.setRowCount(0);
        ProjectAndTasks parentPanel = (ProjectAndTasks) this.getParent();
        CardLayout cards = (CardLayout) parentPanel.getLayout();
        cards.previous(parentPanel);
    }//GEN-LAST:event_backBtnActionPerformed

    public void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) tasksTable.getModel();
        ArrayList<Task> tasks = null;
        try {
            tasks = TasksDB.getNewTasks();
            for (Task task : tasks) {
                model.addRow(new Object[]{task.getDesc(), task.getStartDate(), task.getEndDate(), task.getStatus(), task.getPriority(), task.getId()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public void populateTable() {
        if (DBConnectionManager.getConnection() == null) {
            System.err.println("Database connection is null");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tasksTable.getModel();
        ArrayList<Task> tasks = null;
        try {
            if ((tasks = TasksDB.getTasks(getProjectID())) == null) {
                return;
            }
            for (Task task : tasks) {
                model.addRow(new Object[]{task.getDesc(), task.getStartDate(), task.getEndDate(), task.getStatus(), task.getPriority(), task.getId()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }

    }

    public int getProjectID() {
        return this.projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

//    public JPanel getPanel() {
//        return this;
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JButton createTaskBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel hintLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel rightBtnsPanel;
    private javax.swing.JButton scanBtn;
    private javax.swing.JTable tasksTable;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
