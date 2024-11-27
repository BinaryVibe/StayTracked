/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testgui;
import gui.ProjectsScreen;
import javax.swing.JFrame;
/**
 *
 * @author samtheradiant
 */
public class TestProjectScreen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("TestProjects");
        ProjectsScreen screen1 = new ProjectsScreen();
        frame1.add(screen1);
        frame1.pack();
        frame1.setVisible(true);
    }
    
}
