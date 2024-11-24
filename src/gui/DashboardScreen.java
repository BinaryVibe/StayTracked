/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author samtheradiant
 */
public class DashboardScreen extends JPanel {
    public DashboardScreen() {
        // Initialize components for Tab 1
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Add your components here
        JLabel label1 = new JLabel("This is Tab 1");
        this.add(label1);
    }
}
