
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutScreen extends JFrame{
    public AboutScreen(){
        //frame properties
        setLayout(new BorderLayout(5,5));
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
        lblAboutUs.setForeground(new Color(45,168,216));
        lblAboutUs.setHorizontalAlignment(JLabel.CENTER);
        lowerPanel.add(lblAboutUs,BorderLayout.NORTH);
        
        
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
