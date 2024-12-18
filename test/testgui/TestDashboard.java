/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testgui;

import gui.DashboardScreen;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author PMYLS
 */
public class TestDashboard {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame1 = new JFrame();
        DashboardScreen screen1 = new DashboardScreen();
        frame1.add(screen1);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
    
}
