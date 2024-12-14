/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import customexceptions.FailureException;
import db.ProjectsDB;
import helper.JDateChooserEditor;
import java.awt.Frame;
import java.awt.Window;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Status;
import model.Priority;
import model.Project;

/**
 *
 * @author samtheradiant
 */
public class ProjectsScreen extends javax.swing.JPanel {

    /**
     * Creates new form ProjectsScreen
     */
    public ProjectsScreen() {
        initComponents();
        populateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        createProjectBtn = new javax.swing.JButton();
        scanBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectsTable = new javax.swing.JTable();

        jFormattedTextField1.setText("jFormattedTextField1");

        setBackground(new java.awt.Color(21, 25, 34));
        setMinimumSize(new java.awt.Dimension(500, 300));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(21, 25, 34));

        createProjectBtn.setBackground(new java.awt.Color(40, 40, 39));
        createProjectBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        createProjectBtn.setToolTipText("Create project");
        createProjectBtn.setContentAreaFilled(false);
        createProjectBtn.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        createProjectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProjectBtnActionPerformed(evt);
            }
        });

        scanBtn.setBackground(new java.awt.Color(40, 40, 39));
        scanBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reload.png"))); // NOI18N
        scanBtn.setToolTipText("Scan for projects");
        scanBtn.setContentAreaFilled(false);
        scanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(1080, Short.MAX_VALUE)
                .addComponent(createProjectBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scanBtn)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scanBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createProjectBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        projectsTable.setBackground(new java.awt.Color(40, 40, 39));
        projectsTable.setForeground(new java.awt.Color(221, 255, 255));
        projectsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title ", "Start Date", "Deadline", "Status", "Priority", "Tasks", "Details"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        projectsTable.setFillsViewportHeight(true);
        projectsTable.setRowHeight(25);
        projectsTable.getTableHeader().setReorderingAllowed(false);
        // Set Enum columns' editor to be a JComboBox
        projectsTable.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(new JComboBox<>(Status.values())));
        projectsTable.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(new JComboBox<>(Priority.values())));
        //jTable1.getColumnModel().getColumn(1).setCellEditor(new JDateChooserEditor(new JTextField()));
        projectsTable.getColumnModel().getColumn(1).setCellEditor(new JDateChooserEditor(new JTextField()));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jScrollPane1.setViewportView(projectsTable);
        if (projectsTable.getColumnModel().getColumnCount() > 0) {
            projectsTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            projectsTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            projectsTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer );
            projectsTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
            projectsTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer );
            projectsTable.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
            projectsTable.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        }

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void scanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanBtnActionPerformed
        
        
    }//GEN-LAST:event_scanBtnActionPerformed

    private void createProjectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createProjectBtnActionPerformed
        Window parentWindow = SwingUtilities.windowForComponent(this);
        Frame parentFrame = null;
        if (parentWindow instanceof Frame frame) {
            parentFrame = frame;
        }
        CreateProjectScreen screen1 = new CreateProjectScreen(parentFrame, true);
        screen1.pack();
        screen1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        screen1.setVisible(true);
    }//GEN-LAST:event_createProjectBtnActionPerformed

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) projectsTable.getModel();
        ArrayList<Project> projects = null;
        try {
            projects = ProjectsDB.getProjects();
        } catch (FailureException ex) {
            JOptionPane.showMessageDialog(createProjectBtn, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }

        for (Project project : projects) {
            model.addRow(new Object[]{project.getTitle(), project.getStartDate(), project.getEndDate(), project.getStatus(), project.getPriority(), "View", "View"});
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createProjectBtn;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable projectsTable;
    private javax.swing.JButton scanBtn;
    // End of variables declaration//GEN-END:variables
}
