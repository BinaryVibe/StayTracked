/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testgui;

import com.formdev.flatlaf.FlatDarculaLaf;
import db.DBConnectionManager;
import gui.TasksScreen;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author samtheradiant
 */
public class TestTaskScreen {

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
        JFrame frame = new JFrame();
        TasksScreen screen = new TasksScreen(2);
        frame.add(screen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
    
}
