/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testgui;

import com.formdev.flatlaf.FlatDarculaLaf;
import db.DBConnectionManager;
import gui.ProjectAndTasks;
import helper.CurrentSession;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author samtheradiant
 */
public class TestProjectAndTasks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception ex) { // TODO: Find all exceptions thrown
            System.err.println("Failed to initialize LaF");
        }
        DBConnectionManager.setConnection();
        CurrentSession.setAccountID(1);
        JFrame frame1 = new JFrame();
        ProjectAndTasks screen = new ProjectAndTasks();
        frame1.add(screen);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocationRelativeTo(null);
        frame1.pack();
        frame1.setVisible(true);
    }
    
}
