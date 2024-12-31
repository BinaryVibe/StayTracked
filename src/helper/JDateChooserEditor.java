/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author samtheradiant
 */
public class JDateChooserEditor extends DefaultCellEditor {

    private JDateChooser dateChooser;
    private final String dateFormat = "yyyy-MM-dd";

    public JDateChooserEditor(JTextField textField) {
        super(textField);
        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString(dateFormat);
        dateChooser.setForeground(new Color(255, 255, 255));
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return dateChooser;
    }

    @Override
    public Object getCellEditorValue() {
        DateFormat temp = new SimpleDateFormat(this.dateFormat);
        try {
            return temp.format(dateChooser.getDate());
        } catch (NullPointerException ex) {
            return null; 
        }
    }

    @Override
    public boolean stopCellEditing() {
        if (dateChooser.getDate() == null) {
            cancelCellEditing();
            return false;
        }
        return super.stopCellEditing(); 
    }

    
}
