/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

/**
 *
 * @author i c
 */
public class TeamDetailsScreen extends javax.swing.JPanel {

    /**
     * Creates new form TeamDetailsScreen
     */
    public TeamDetailsScreen() {
        initComponents();
       txtTeamName.setVisible(false);
        updateTeamNameBtn.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTeamName = new javax.swing.JTextField();
        updateTeamNameBtn = new javax.swing.JButton();
        editTeamNamebtn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblCurrentUserName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(21, 25, 34));
        setMinimumSize(new java.awt.Dimension(1000, 720));
        setLayout(null);

        txtTeamName.setBackground(new java.awt.Color(21, 25, 34));
        txtTeamName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTeamName.setForeground(new java.awt.Color(204, 204, 204));
        txtTeamName.setText("Team Name");
        txtTeamName.setBorder(null);
        txtTeamName.setCaretColor(new java.awt.Color(255, 255, 255));
        txtTeamName.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtTeamName.setOpaque(true);
        add(txtTeamName);
        txtTeamName.setBounds(630, 140, 270, 30);

        updateTeamNameBtn.setBackground(new java.awt.Color(45, 168, 216));
        updateTeamNameBtn.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        updateTeamNameBtn.setForeground(new java.awt.Color(21, 25, 34));
        updateTeamNameBtn.setText("Update");
        updateTeamNameBtn.setBorder(null);
        updateTeamNameBtn.setMinimumSize(new java.awt.Dimension(80, 17));
        updateTeamNameBtn.setPreferredSize(new java.awt.Dimension(80, 17));
        updateTeamNameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTeamNameBtnActionPerformed(evt);
            }
        });
        add(updateTeamNameBtn);
        updateTeamNameBtn.setBounds(810, 180, 80, 23);

        editTeamNamebtn.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        editTeamNamebtn.setForeground(new java.awt.Color(45, 168, 216));
        editTeamNamebtn.setText("Edit");
        editTeamNamebtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(45, 168, 216), 1, true));
        editTeamNamebtn.setContentAreaFilled(false);
        editTeamNamebtn.setMinimumSize(new java.awt.Dimension(60, 17));
        editTeamNamebtn.setPreferredSize(new java.awt.Dimension(60, 17));
        editTeamNamebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTeamNamebtnActionPerformed(evt);
            }
        });
        add(editTeamNamebtn);
        editTeamNamebtn.setBounds(900, 180, 60, 23);

        jSeparator2.setMaximumSize(new java.awt.Dimension(32767, 2));
        jSeparator2.setMinimumSize(new java.awt.Dimension(50, 2));
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 2));
        add(jSeparator2);
        jSeparator2.setBounds(30, 170, 939, 10);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Team Name");
        add(jLabel5);
        jLabel5.setBounds(30, 140, 102, 25);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(45, 168, 216));
        jLabel2.setText("TEAM DETAILS");
        add(jLabel2);
        jLabel2.setBounds(30, 50, 250, 48);

        jSeparator1.setForeground(new java.awt.Color(45, 168, 216));
        add(jSeparator1);
        jSeparator1.setBounds(30, 100, 939, 10);

        lblCurrentUserName.setBackground(new java.awt.Color(21, 25, 34));
        lblCurrentUserName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCurrentUserName.setForeground(new java.awt.Color(204, 204, 204));
        lblCurrentUserName.setText("Team Name");
        add(lblCurrentUserName);
        lblCurrentUserName.setBounds(630, 145, 270, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(45, 168, 216));
        jLabel3.setText("TEAM MEMBERS");
        add(jLabel3);
        jLabel3.setBounds(30, 220, 330, 48);

        jSeparator3.setForeground(new java.awt.Color(45, 168, 216));
        add(jSeparator3);
        jSeparator3.setBounds(30, 270, 939, 10);

        jTable1.setBackground(new java.awt.Color(21, 25, 34));
        jTable1.setForeground(new java.awt.Color(153, 153, 153));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Member ID", "Name", "Contact", "Email"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(45, 168, 216));
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 290, 940, 402);
    }// </editor-fold>//GEN-END:initComponents

    private void updateTeamNameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateTeamNameBtnActionPerformed
        // TODO add your handling code here:

        //add a function to modify username of current logined user
        String newTeamName = txtTeamName.getText();
        //incomplete
        //set text of label again
        lblCurrentUserName.setText(newTeamName);

        //again hide update button , txtField and show edit button, label
        lblCurrentUserName.setVisible(true);
        editTeamNamebtn.setVisible(true);
        txtTeamName.setVisible(false);
        updateTeamNameBtn.setVisible(false);

    }//GEN-LAST:event_updateTeamNameBtnActionPerformed

    private void editTeamNamebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTeamNamebtnActionPerformed
        // TODO add your handling code here:
        lblCurrentUserName.setVisible(false);
        editTeamNamebtn.setVisible(false);
        txtTeamName.setVisible(true);
        updateTeamNameBtn.setVisible(true);
    }//GEN-LAST:event_editTeamNamebtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editTeamNamebtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCurrentUserName;
    private javax.swing.JTextField txtTeamName;
    private javax.swing.JButton updateTeamNameBtn;
    // End of variables declaration//GEN-END:variables
}
