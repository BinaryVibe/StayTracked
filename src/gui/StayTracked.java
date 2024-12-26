package gui;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import db.DBConnectionManager;

public class StayTracked {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        Login LoginFrame = new Login();
        
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        LoginFrame.setVisible(true);
        
        DBConnectionManager.setConnection();
    }

}
