/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import customexceptions.FailureException;
import db.ProjectsDB;
import javax.swing.JOptionPane;
import model.Account;

/**
 *
 * @author samtheradiant
 */
public class DashboardScreen extends javax.swing.JPanel {

    /**
     * Creates new form DashboardScreen
     */
    public DashboardScreen() {
        initComponents();
        try {
            completdProjctsSpinner.setValue(ProjectsDB.getProjectCompletion());
        } catch (FailureException ex) {
            JOptionPane.showConfirmDialog(this, ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        spinnerPanel = new javax.swing.JPanel();
        completdProjctsSpinner = new raven.spinner.SpinnerProgress();
        completedTaskSpinner = new raven.spinner.SpinnerProgress();
        spinnerProgress1 = new raven.spinner.SpinnerProgress();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(21, 25, 34));
        setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(21, 25, 34));
        jPanel3.setPreferredSize(new java.awt.Dimension(1000, 50));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(jPanel3, java.awt.BorderLayout.SOUTH);

        jPanel2.setBackground(new java.awt.Color(21, 25, 34));
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 420));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(jPanel2, java.awt.BorderLayout.WEST);

        jPanel1.setBackground(new java.awt.Color(21, 25, 34));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 420));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        add(jPanel1, java.awt.BorderLayout.EAST);

        spinnerPanel.setBackground(new java.awt.Color(21, 25, 34));
        spinnerPanel.setPreferredSize(new java.awt.Dimension(742, 320));

        completdProjctsSpinner.setValue(25);
        completdProjctsSpinner.setStringPainted(true);

        completedTaskSpinner.setValue(50);
        completedTaskSpinner.setStringPainted(true);

        spinnerProgress1.setStringPainted(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(76, 135, 200));
        jLabel1.setText("Completed Projects");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(76, 135, 200));
        jLabel2.setText("Completed Tasks");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(76, 135, 200));
        jLabel3.setText("Extra Spinner");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout spinnerPanelLayout = new javax.swing.GroupLayout(spinnerPanel);
        spinnerPanel.setLayout(spinnerPanelLayout);
        spinnerPanelLayout.setHorizontalGroup(
            spinnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(spinnerPanelLayout.createSequentialGroup()
                .addGroup(spinnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(spinnerPanelLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(completdProjctsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(completedTaskSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(spinnerProgress1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(spinnerPanelLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel1)
                        .addGap(147, 147, 147)
                        .addComponent(jLabel2)
                        .addGap(178, 178, 178)
                        .addComponent(jLabel3)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        spinnerPanelLayout.setVerticalGroup(
            spinnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(spinnerPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(spinnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerProgress1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(completedTaskSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(completdProjctsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(spinnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        add(spinnerPanel, java.awt.BorderLayout.PAGE_START);

        jTable1.setBackground(new java.awt.Color(21, 25, 34));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title Of Project", "Number Of Task", "Completed Tasks", "Completion Percentage"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(45, 168, 216));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.spinner.SpinnerProgress completdProjctsSpinner;
    private raven.spinner.SpinnerProgress completedTaskSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel spinnerPanel;
    private raven.spinner.SpinnerProgress spinnerProgress1;
    // End of variables declaration//GEN-END:variables
}
