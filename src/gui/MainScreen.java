/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.formdev.flatlaf.FlatLightLaf;
import db.DBConnectionManager;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author samtheradiant
 */
public class MainScreen extends javax.swing.JFrame {

    /**
     * Creates new form MainScreen
     */
    CardLayout cardLayout;

    public MainScreen() {
        initComponents();
        ProfileScreen profile = new ProfileScreen(this);
        cardPanel.add(teams, "Teams");
        cardPanel.add(profile, "Profile");
        cardPanel.add(dashboard, "Dashbord");
        cardPanel.add(projectsScreen1, "Projects");

        /* 
        //we will use this incase to use basic button look and feel
        
       Component [] components = this.getContentPane().getComponents();
       for(Component component : components){
           if(component instanceof JButton){
               ((JButton) component).setUI(new BasicButtonUI());
           }
       }
         */
        
        cardLayout = (CardLayout) cardPanel.getLayout();
        
        //initially show dashboard when open mainscreen, Duhh!
        cardLayout.show(cardPanel, "Dashbord");
        setButtonsNotSelected();
        btnDashboard.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        tabsButtonPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        profileIcon = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JButton();
        btnProjects = new javax.swing.JButton();
        btnProfile = new javax.swing.JButton();
        btnTeams = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        cardPanel = new javax.swing.JPanel();
        teams = new gui.TeamDetailsScreen();
        projectsScreen1 = new gui.ProjectsScreen();
        dashboard = new gui.DashboardScreen();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        helpMenu = new javax.swing.JMenu();
        aboutUs = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 743));

        mainPanel.setBackground(new java.awt.Color(21, 25, 34));
        mainPanel.setMinimumSize(new java.awt.Dimension(1280, 720));
        mainPanel.setPreferredSize(new java.awt.Dimension(1280, 720));
        mainPanel.setLayout(new java.awt.BorderLayout());

        tabsButtonPanel.setBackground(new java.awt.Color(45, 168, 216));
        tabsButtonPanel.setMinimumSize(new java.awt.Dimension(280, 720));
        tabsButtonPanel.setPreferredSize(new java.awt.Dimension(280, 720));

        jPanel1.setBackground(new java.awt.Color(45, 168, 216));

        profileIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/boy.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(profileIcon)
                .addGap(51, 51, 51))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(profileIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        btnDashboard.setBackground(new java.awt.Color(45, 168, 216));
        btnDashboard.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonicons/DefaultButton.png"))); // NOI18N
        btnDashboard.setText("Dashboard");
        btnDashboard.setBorder(null);
        btnDashboard.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDashboard.setMaximumSize(new java.awt.Dimension(200, 50));
        btnDashboard.setMinimumSize(new java.awt.Dimension(200, 50));
        btnDashboard.setPreferredSize(new java.awt.Dimension(200, 50));
        btnDashboard.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonicons/HooverButton.png"))); // NOI18N
        btnDashboard.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonicons/SelectedButton.png"))); // NOI18N
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });

        btnProjects.setBackground(new java.awt.Color(45, 168, 216));
        btnProjects.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnProjects.setForeground(new java.awt.Color(255, 255, 255));
        btnProjects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonicons/DefaultButton.png"))); // NOI18N
        btnProjects.setText("Projects");
        btnProjects.setBorder(null);
        btnProjects.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProjects.setMaximumSize(new java.awt.Dimension(200, 50));
        btnProjects.setMinimumSize(new java.awt.Dimension(200, 50));
        btnProjects.setPreferredSize(new java.awt.Dimension(200, 50));
        btnProjects.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonicons/HooverButton.png"))); // NOI18N
        btnProjects.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonicons/SelectedButton.png"))); // NOI18N
        btnProjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProjectsActionPerformed(evt);
            }
        });

        btnProfile.setBackground(new java.awt.Color(45, 168, 216));
        btnProfile.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonicons/DefaultButton.png"))); // NOI18N
        btnProfile.setText("Profile");
        btnProfile.setBorder(null);
        btnProfile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProfile.setMaximumSize(new java.awt.Dimension(200, 50));
        btnProfile.setMinimumSize(new java.awt.Dimension(200, 50));
        btnProfile.setPreferredSize(new java.awt.Dimension(200, 50));
        btnProfile.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonicons/HooverButton.png"))); // NOI18N
        btnProfile.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonicons/SelectedButton.png"))); // NOI18N
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });

        btnTeams.setBackground(new java.awt.Color(45, 168, 216));
        btnTeams.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTeams.setForeground(new java.awt.Color(255, 255, 255));
        btnTeams.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonicons/DefaultButton.png"))); // NOI18N
        btnTeams.setText("Teams");
        btnTeams.setBorder(null);
        btnTeams.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTeams.setMaximumSize(new java.awt.Dimension(200, 50));
        btnTeams.setMinimumSize(new java.awt.Dimension(200, 50));
        btnTeams.setPreferredSize(new java.awt.Dimension(200, 50));
        btnTeams.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonicons/HooverButton.png"))); // NOI18N
        btnTeams.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonicons/SelectedButton.png"))); // NOI18N
        btnTeams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeamsActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 0, 0));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png"))); // NOI18N
        btnLogout.setText(" Logout");
        btnLogout.setBorder(null);
        btnLogout.setContentAreaFilled(false);
        btnLogout.setMaximumSize(new java.awt.Dimension(200, 50));
        btnLogout.setMinimumSize(new java.awt.Dimension(200, 50));
        btnLogout.setPreferredSize(new java.awt.Dimension(200, 50));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabsButtonPanelLayout = new javax.swing.GroupLayout(tabsButtonPanel);
        tabsButtonPanel.setLayout(tabsButtonPanelLayout);
        tabsButtonPanelLayout.setHorizontalGroup(
            tabsButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabsButtonPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(tabsButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabsButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnLogout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDashboard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnProjects, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnProfile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTeams, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        tabsButtonPanelLayout.setVerticalGroup(
            tabsButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabsButtonPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProjects, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTeams, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainPanel.add(tabsButtonPanel, java.awt.BorderLayout.LINE_START);

        cardPanel.setBackground(new java.awt.Color(21, 25, 34));
        cardPanel.setLayout(new java.awt.CardLayout());
        cardPanel.add(teams, "card3");
        cardPanel.add(projectsScreen1, "card3");
        cardPanel.add(dashboard, "card4");

        mainPanel.add(cardPanel, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        helpMenu.setText("Help");
        helpMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuActionPerformed(evt);
            }
        });

        aboutUs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        aboutUs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/information.png"))); // NOI18N
        aboutUs.setText("About");
        aboutUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutUsActionPerformed(evt);
            }
        });
        helpMenu.add(aboutUs);

        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        // TODO add your handling code here:
        cardLayout.show(cardPanel, "Dashbord");
        setButtonsNotSelected();
        btnDashboard.setSelected(true);
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnProjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProjectsActionPerformed
        // TODO add your handling code here:
        cardLayout.show(cardPanel, "Projects");
        setButtonsNotSelected();
        btnProjects.setSelected(true);
    }//GEN-LAST:event_btnProjectsActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        // TODO add your handling code here:
        cardLayout.show(cardPanel, "Profile");
        setButtonsNotSelected();
        btnProfile.setSelected(true);
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnTeamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeamsActionPerformed
        // TODO add your handling code here:
        cardLayout.show(cardPanel, "Teams");
        setButtonsNotSelected();
        btnTeams.setSelected(true);
    }//GEN-LAST:event_btnTeamsActionPerformed

    private void helpMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuActionPerformed
        // TODO add your handling code here:
        // not using it //not doing what i expectedS
    }//GEN-LAST:event_helpMenuActionPerformed

    private void aboutUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutUsActionPerformed
        // TODO add your handling code here:
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        AboutScreen AboutUsFrame = new AboutScreen();
        
        AboutUsFrame.pack();
        AboutUsFrame.setLocationRelativeTo(null);
        AboutUsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        AboutUsFrame.setVisible(true);
        
    }//GEN-LAST:event_aboutUsActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        //open login screen
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        Login LoginFrame = new Login();
        
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        LoginFrame.setVisible(true);
        
        //close database connection
        DBConnectionManager.closeConnection();
        
        //close this screen
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainScreen().setVisible(true);
//            }
//        });
//    }
    
    //set All Buttons False
    private void setButtonsNotSelected() {
        btnDashboard.setSelected(false);
        btnProfile.setSelected(false);
        btnProjects.setSelected(false);
        btnTeams.setSelected(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutUs;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnProjects;
    private javax.swing.JButton btnTeams;
    private javax.swing.JPanel cardPanel;
    private gui.DashboardScreen dashboard;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel profileIcon;
    private gui.ProjectsScreen projectsScreen1;
    private javax.swing.JPanel tabsButtonPanel;
    private gui.TeamDetailsScreen teams;
    // End of variables declaration//GEN-END:variables
}
