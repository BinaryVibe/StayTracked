package gui;

import model.ManagerAccount;
import model.NormalAccount;
import model.Team;

public class SignUp extends javax.swing.JFrame {

    private int currentPanelIndex = 0;
    private int totalPanels = 4;
    private String firstName, lastName, userName, contactNum, email, password;
    private String teamName;
            

    public SignUp() {
        initComponents();
        slider.init(signupPanel, personalDetailsPanel, accountTypePanel, teamDetails);
        slider.setAnimate(10);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        accTypeBtnGrp = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        backSlide = new javax.swing.JButton();
        nextSlide = new javax.swing.JButton();
        rightPanel = new javax.swing.JPanel();
        slider = new mySwing.PanelSlide();
        left = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        teamDetails = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblTeamName = new javax.swing.JLabel();
        txtTeamName = new javax.swing.JTextField();
        personalDetailsPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblContact = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        accountTypePanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnPersonal = new javax.swing.JRadioButton();
        btnManager = new javax.swing.JRadioButton();
        signupPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPass = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        btnGoToLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIGN UP");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(21, 25, 34));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        backSlide.setBackground(new java.awt.Color(45, 168, 216));
        backSlide.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backSlide.setForeground(new java.awt.Color(255, 255, 255));
        backSlide.setText("Back");
        backSlide.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backSlide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backSlideActionPerformed(evt);
            }
        });
        jPanel1.add(backSlide);
        backSlide.setBounds(620, 460, 70, 20);

        nextSlide.setBackground(new java.awt.Color(45, 168, 216));
        nextSlide.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nextSlide.setForeground(new java.awt.Color(255, 255, 255));
        nextSlide.setText("Next");
        nextSlide.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nextSlide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextSlideActionPerformed(evt);
            }
        });
        jPanel1.add(nextSlide);
        nextSlide.setBounds(700, 460, 70, 20);

        rightPanel.setBackground(new java.awt.Color(255, 255, 255));

        slider.setBackground(new java.awt.Color(21, 25, 34));

        javax.swing.GroupLayout sliderLayout = new javax.swing.GroupLayout(slider);
        slider.setLayout(sliderLayout);
        sliderLayout.setHorizontalGroup(
            sliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        sliderLayout.setVerticalGroup(
            sliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(rightPanel);
        rightPanel.setBounds(410, 10, 380, 440);

        left.setBackground(new java.awt.Color(45, 168, 216));
        left.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/metrics.png"))); // NOI18N

        jLabel5.setBackground(new java.awt.Color(21, 25, 34));
        jLabel5.setFont(new java.awt.Font("Open Sans", 3, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(21, 25, 34));
        jLabel5.setText("  STAY TRACKED");

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
            .addGroup(leftLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        jPanel1.add(left);
        left.setBounds(0, 0, 400, 500);

        teamDetails.setBackground(new java.awt.Color(21, 25, 34));
        teamDetails.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(45, 168, 216));
        jLabel10.setText("TEAM DETAILS");

        lblTeamName.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblTeamName.setForeground(new java.awt.Color(204, 204, 204));
        lblTeamName.setText("Team Name");

        txtTeamName.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtTeamName.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout teamDetailsLayout = new javax.swing.GroupLayout(teamDetails);
        teamDetails.setLayout(teamDetailsLayout);
        teamDetailsLayout.setHorizontalGroup(
            teamDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teamDetailsLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(teamDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTeamName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTeamName))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, teamDetailsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(81, 81, 81))
        );
        teamDetailsLayout.setVerticalGroup(
            teamDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teamDetailsLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel10)
                .addGap(30, 30, 30)
                .addComponent(lblTeamName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTeamName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(320, Short.MAX_VALUE))
        );

        jPanel1.add(teamDetails);
        teamDetails.setBounds(0, 0, 400, 500);

        personalDetailsPanel.setBackground(new java.awt.Color(21, 25, 34));
        personalDetailsPanel.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(45, 168, 216));
        jLabel9.setText("PERSONAL DETAILS");

        lblFirstName.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblFirstName.setForeground(new java.awt.Color(204, 204, 204));
        lblFirstName.setText("First Name");

        txtFirstName.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtFirstName.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblLastName.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblLastName.setForeground(new java.awt.Color(204, 204, 204));
        lblLastName.setText("Last Name");

        txtLastName.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtLastName.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(204, 204, 204));
        lblEmail.setText("Email");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblContact.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblContact.setForeground(new java.awt.Color(204, 204, 204));
        lblContact.setText("Contact Number");

        txtContact.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtContact.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout personalDetailsPanelLayout = new javax.swing.GroupLayout(personalDetailsPanel);
        personalDetailsPanel.setLayout(personalDetailsPanelLayout);
        personalDetailsPanelLayout.setHorizontalGroup(
            personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalDetailsPanelLayout.createSequentialGroup()
                .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalDetailsPanelLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFirstName)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLastName)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail)
                            .addComponent(lblContact)
                            .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(personalDetailsPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel9)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        personalDetailsPanelLayout.setVerticalGroup(
            personalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalDetailsPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel9)
                .addGap(31, 31, 31)
                .addComponent(lblFirstName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblLastName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblContact)
                .addGap(4, 4, 4)
                .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        jPanel1.add(personalDetailsPanel);
        personalDetailsPanel.setBounds(0, 0, 400, 500);

        accountTypePanel.setBackground(new java.awt.Color(21, 25, 34));
        accountTypePanel.setMinimumSize(new java.awt.Dimension(400, 500));
        accountTypePanel.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(45, 168, 216));
        jLabel4.setText("MANAGER ACCOUNT");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(45, 168, 216));
        jLabel8.setText("ACCOUNT TYPE");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(45, 168, 216));
        jLabel14.setText("PERSONAL ACCOUNT");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("A standard account designed for individual users to manage");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("their tasks and access team features.");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("Ideal for team members collaborating on projects.");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("A specialized account for team leaders, providing tools to");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("create and manage teams, add or remove members. and ");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 204, 204));
        jLabel20.setText("oversee project progress.");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 204, 204));
        jLabel21.setText("Perfect for those in leadership roles.");

        btnPersonal.setBackground(new java.awt.Color(45, 168, 216));
        accTypeBtnGrp.add(btnPersonal);
        btnPersonal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPersonal.setForeground(new java.awt.Color(45, 168, 216));
        btnPersonal.setText("Personal");
        btnPersonal.setToolTipText("");
        btnPersonal.setBorderPainted(true);
        btnPersonal.setContentAreaFilled(false);
        btnPersonal.setName(""); // NOI18N
        btnPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonalActionPerformed(evt);
            }
        });

        btnManager.setBackground(new java.awt.Color(45, 168, 216));
        accTypeBtnGrp.add(btnManager);
        btnManager.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnManager.setForeground(new java.awt.Color(45, 168, 216));
        btnManager.setText("Manager");
        btnManager.setToolTipText("");
        btnManager.setBorderPainted(true);
        btnManager.setContentAreaFilled(false);
        btnManager.setName(""); // NOI18N
        btnManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout accountTypePanelLayout = new javax.swing.GroupLayout(accountTypePanel);
        accountTypePanel.setLayout(accountTypePanelLayout);
        accountTypePanelLayout.setHorizontalGroup(
            accountTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountTypePanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(accountTypePanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(accountTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(accountTypePanelLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addContainerGap())
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(accountTypePanelLayout.createSequentialGroup()
                        .addGroup(accountTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnManager)
                            .addComponent(btnPersonal)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        accountTypePanelLayout.setVerticalGroup(
            accountTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountTypePanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPersonal)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnManager)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jPanel1.add(accountTypePanel);
        accountTypePanel.setBounds(0, 0, 400, 500);

        signupPanel.setBackground(new java.awt.Color(21, 25, 34));
        signupPanel.setMinimumSize(new java.awt.Dimension(400, 500));
        signupPanel.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(45, 168, 216));
        jLabel1.setText("SIGN UP");

        lblUsername.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(204, 204, 204));
        lblUsername.setText("Username");

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtUsername.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblPass.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblPass.setForeground(new java.awt.Color(204, 204, 204));
        lblPass.setText("Password");

        txtPass.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel7.setForeground(new java.awt.Color(45, 168, 216));
        jLabel7.setText("i already have an account");

        btnGoToLogin.setBackground(new java.awt.Color(45, 168, 216));
        btnGoToLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGoToLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnGoToLogin.setText("Loign");
        btnGoToLogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGoToLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoToLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout signupPanelLayout = new javax.swing.GroupLayout(signupPanel);
        signupPanel.setLayout(signupPanelLayout);
        signupPanelLayout.setHorizontalGroup(
            signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupPanelLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername)
                    .addComponent(lblPass)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(signupPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGoToLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
            .addGroup(signupPanelLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        signupPanelLayout.setVerticalGroup(
            signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signupPanelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addComponent(lblUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btnGoToLogin))
                .addContainerGap(194, Short.MAX_VALUE))
        );

        jPanel1.add(signupPanel);
        signupPanel.setBounds(400, 0, 400, 450);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoToLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoToLoginActionPerformed
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnGoToLoginActionPerformed

    private void backSlideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backSlideActionPerformed
        // TODO add your handling code here:
        
        if (currentPanelIndex > 0) {
        currentPanelIndex--; // Move to the previous panel
        slider.show(currentPanelIndex);
       
        
    }
    }//GEN-LAST:event_backSlideActionPerformed

    private void nextSlideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextSlideActionPerformed
        // TODO add your handling code here:
      
        //if it's 2nd last panel then save the values and make an object of account and pass that to database
        if (currentPanelIndex == totalPanels - 2){ 
            if(btnPersonal.isSelected()){
               firstName = txtFirstName.getText();
            lastName = txtLastName.getText();
            userName = txtUsername.getText();
            contactNum = txtContact.getText();
            email = txtEmail.getText();
            password = txtPass.getText();
            
            NormalAccount user = new NormalAccount(false, firstName, lastName, userName, contactNum, email, password);
            AccountCreatedDialog dialog = new AccountCreatedDialog(this, true);
            dialog.setVisible(true);
            this.dispose();
            
                //System.out.println(user.getUserName());
            }
                   
        }
        //if it's last panel then save the values and make an object of manager account and pass that to database
        if (currentPanelIndex == totalPanels -1){
            if(btnManager.isSelected()){
                firstName = txtFirstName.getText();
            lastName = txtLastName.getText();
            userName = txtUsername.getText();
            contactNum = txtContact.getText();
            email = txtEmail.getText();
            password = txtPass.getText();
            teamName = txtTeamName.getText();
            Team managedTeam = new Team(teamName);
            
            ManagerAccount manager = new ManagerAccount(managedTeam, firstName, lastName, userName, contactNum, email, password);
            }
        }
          if (currentPanelIndex < totalPanels - 1) {
        currentPanelIndex++; // Move to the next panel
        slider.show(currentPanelIndex);
    }
    }//GEN-LAST:event_nextSlideActionPerformed

    private void btnPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPersonalActionPerformed

    private void btnManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnManagerActionPerformed

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
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup accTypeBtnGrp;
    private javax.swing.JPanel accountTypePanel;
    private javax.swing.JButton backSlide;
    private javax.swing.JButton btnGoToLogin;
    private javax.swing.JRadioButton btnManager;
    private javax.swing.JRadioButton btnPersonal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblContact;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblTeamName;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel left;
    private javax.swing.JButton nextSlide;
    private javax.swing.JPanel personalDetailsPanel;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JPanel signupPanel;
    private mySwing.PanelSlide slider;
    private javax.swing.JPanel teamDetails;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtTeamName;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
