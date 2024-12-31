/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui;

import customexceptions.FailureException;
import customexceptions.InvalidInputException;
import db.AccountsDb;
import helper.CurrentSession;
import java.sql.SQLException;

/**
 *
 * @author i c
 */
public class ChangePasswordDialog extends javax.swing.JDialog {

    /**
     * Creates new form ChangePasswordDialog
     */
    public ChangePasswordDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setResizable(false);
        initComponents();
        setLocationRelativeTo(parent); // Center the dialog

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PassPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblCurrentPassword = new javax.swing.JLabel();
        lblNewPass = new javax.swing.JLabel();
        txtNewPass = new javax.swing.JPasswordField();
        lblConfirmPass = new javax.swing.JLabel();
        txtConfirmPass = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        txtCurrentPassword = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        lblError = new javax.swing.JLabel();
        lblSucces = new javax.swing.JLabel();
        updatePassBtn = new javax.swing.JButton();
        BackToProfileBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 500));

        PassPanel.setBackground(new java.awt.Color(21, 25, 34));
        PassPanel.setMinimumSize(new java.awt.Dimension(400, 500));
        PassPanel.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(45, 168, 216));
        jLabel1.setText("CHANGE PASSWORD");

        lblCurrentPassword.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblCurrentPassword.setForeground(new java.awt.Color(204, 204, 204));
        lblCurrentPassword.setText("Current Password");

        lblNewPass.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblNewPass.setForeground(new java.awt.Color(204, 204, 204));
        lblNewPass.setText("New Password");

        txtNewPass.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblConfirmPass.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblConfirmPass.setForeground(new java.awt.Color(204, 204, 204));
        lblConfirmPass.setText("Confirm New Password");

        txtConfirmPass.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtCurrentPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblError.setForeground(new java.awt.Color(255, 51, 51));

        lblSucces.setForeground(new java.awt.Color(45, 168, 216));

        updatePassBtn.setBackground(new java.awt.Color(45, 168, 216));
        updatePassBtn.setForeground(new java.awt.Color(21, 25, 34));
        updatePassBtn.setText("Update");
        updatePassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePassBtnActionPerformed(evt);
            }
        });

        BackToProfileBtn.setBackground(new java.awt.Color(45, 168, 216));
        BackToProfileBtn.setForeground(new java.awt.Color(21, 25, 34));
        BackToProfileBtn.setText("Back to Profile");
        BackToProfileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToProfileBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PassPanelLayout = new javax.swing.GroupLayout(PassPanel);
        PassPanel.setLayout(PassPanelLayout);
        PassPanelLayout.setHorizontalGroup(
            PassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PassPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(PassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(lblCurrentPassword)
                    .addComponent(lblConfirmPass)
                    .addComponent(txtConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNewPass)
                    .addComponent(txtNewPass, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(txtCurrentPassword)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                    .addGroup(PassPanelLayout.createSequentialGroup()
                        .addComponent(updatePassBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BackToProfileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(lblSucces, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        PassPanelLayout.setVerticalGroup(
            PassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PassPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(lblCurrentPassword)
                .addGap(8, 8, 8)
                .addComponent(txtCurrentPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNewPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblConfirmPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSucces)
                .addGap(56, 56, 56)
                .addGroup(PassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updatePassBtn)
                    .addComponent(BackToProfileBtn))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(PassPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PassPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackToProfileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToProfileBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BackToProfileBtnActionPerformed

    private void updatePassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePassBtnActionPerformed
        // TODO add your handling code here:
        String confirmNewPass = new String(txtConfirmPass.getPassword());
        String newPass = new String(txtNewPass.getPassword());
        String currentPass = new String(txtCurrentPassword.getPassword());

        try {

            if (confirmNewPass.isEmpty() || newPass.isEmpty() || currentPass.isEmpty()) {

                lblError.setText("No text fields should be empty");

            } else if (!confirmNewPass.equals(newPass)) {

                lblError.setText("Password doesn't match");

            } else {
                //Check if pass is valid
                AccountsDb.validatePassword(newPass);
                //call method to update pass
                AccountsDb.updatePass(CurrentSession.getAccountID(), currentPass, newPass);
                lblError.setText("");
                lblSucces.setText("Password successfuly updated! Go back to profile...");
                updatePassBtn.setVisible(false);

                txtCurrentPassword.setEnabled(false);
                txtNewPass.setEnabled(false);
                txtConfirmPass.setEnabled(false);
            }

        } catch (FailureException fe) {
            lblError.setText(fe.getMessage());
        } catch (SQLException se) {
            lblError.setText(se.getMessage());
        } catch (InvalidInputException ie) {
            lblError.setText(ie.getMessage());
        }
    }//GEN-LAST:event_updatePassBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChangePasswordDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePasswordDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePasswordDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePasswordDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChangePasswordDialog dialog = new ChangePasswordDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackToProfileBtn;
    private javax.swing.JPanel PassPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblConfirmPass;
    private javax.swing.JLabel lblCurrentPassword;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblNewPass;
    private javax.swing.JLabel lblSucces;
    private javax.swing.JPasswordField txtConfirmPass;
    private javax.swing.JPasswordField txtCurrentPassword;
    private javax.swing.JPasswordField txtNewPass;
    private javax.swing.JButton updatePassBtn;
    // End of variables declaration//GEN-END:variables
}
