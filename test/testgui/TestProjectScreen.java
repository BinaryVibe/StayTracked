/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testgui;

import com.formdev.flatlaf.FlatDarculaLaf;
import db.DBConnectionManager;
import gui.ProjectsScreen;
import javax.swing.JFrame;
import javax.swing.UIManager;
import helper.CurrentSession;

/**
 *
 * @author samtheradiant
 */
public class TestProjectScreen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CurrentSession.setAccountID(1);
        DBConnectionManager.setConnection();
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception ex) { // TODO: Find all exceptions thrown
            System.err.println("Failed to initialize LaF");
        }
        JFrame frame1 = new JFrame("TestProjects");
        ProjectsScreen screen1 = new ProjectsScreen();
        frame1.add(screen1);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setVisible(true);
    }
}
