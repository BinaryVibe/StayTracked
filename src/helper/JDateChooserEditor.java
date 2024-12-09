/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;

/**
 *
 * @author samtheradiant
 */
public class JDateChooserEditor extends DefaultCellEditor {
    
    public JDateChooserEditor(JCheckBox checkBox) {
        super(checkBox);
    }
    
}
