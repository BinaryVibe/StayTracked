package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AboutScreen extends JFrame {
    String aboutText =
       """
           Group Members:
            - Malik Haris Ali (FA23-BS-004)
            - Muhammad Talal (FA23-BCS-028)
            - Ayaan Ahmed Khan (FA23-BCS-112)

           STAY TRACKED:
              This Project Tracking System is a tool designed to help manage multiple projects, tasks, 
              and teams in a collaborative environment.
              This system will allow users to store and manage project information, track task progress,
              and manage team member roles and permissions.
       
              Given the beginner level of the development team and the limited time, the project focuses
              on implementing minimal functionality to achieve the core objectives of each module.
        """
        ;

    public AboutScreen() {
        //frame properties
        setLayout(new BorderLayout(5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(680, 800);
        setResizable(false);
        setTitle("About Us");

        //Add image to be shown
        ImageIcon myImage = new ImageIcon(getClass().getResource("/icons/pgmanage.jpg"));

        //Setting Upper Panels 
        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());
        upperPanel.setPreferredSize(new Dimension(680, 340));
        upperPanel.setBackground(new Color(21, 25, 34));
        upperPanel.add(new JLabel(myImage));

        //Setting Lower Panel
        JPanel lowerPanel = new JPanel(new BorderLayout());
        lowerPanel.setBackground(new Color(21, 25, 34));
        lowerPanel.setPreferredSize(new Dimension(680, 400));
        JLabel lblAboutUs = new JLabel("ABOUT US");
        lblAboutUs.setFont(new Font("Segoe UI", 1, 34));
        lblAboutUs.setForeground(new Color(45, 168, 216));
        lblAboutUs.setHorizontalAlignment(JLabel.CENTER);

        //text area paragraph k leay 
        JTextArea aboutTextArea = new JTextArea(aboutText);
        aboutTextArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        aboutTextArea.setForeground(new Color(255, 255, 255));
        aboutTextArea.setBackground(new Color(21, 25, 34));
        aboutTextArea.setLineWrap(true);
        aboutTextArea.setWrapStyleWord(true);
        aboutTextArea.setEditable(false);
        lowerPanel.add(lblAboutUs, BorderLayout.NORTH);
        lowerPanel.add(aboutTextArea, BorderLayout.CENTER);

        //add panels
        add(upperPanel, BorderLayout.NORTH);
        add(lowerPanel, BorderLayout.CENTER);

    }
}

class main {

    public static void main(String[] args) {
        AboutScreen frameAB = new AboutScreen();
        frameAB.pack();
        frameAB.setLocationRelativeTo(null);
        frameAB.setVisible(true);
    }
}
