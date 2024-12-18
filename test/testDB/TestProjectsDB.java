/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testDB;

import db.DBConnectionManager;
import gui.CreateProjectScreen;
import javax.swing.JFrame;
import helper.CurrentSession;

/**
 *
 * @author samtheradiant
 */
public class TestProjectsDB {
    
    public static void main(String[] args) {
        CurrentSession.setAccountID(1);
        DBConnectionManager.setConnection();
        JFrame testFrame = new JFrame();
        CreateProjectScreen test = new CreateProjectScreen(testFrame, true);
        //testFrame.add(test);
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testFrame.setLocationRelativeTo(null);
        testFrame.setVisible(true);
    }
    
}
