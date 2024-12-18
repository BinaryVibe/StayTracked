/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        setClickCountToStart(2);
        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString(dateFormat);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//        if (value instanceof Date date) {
//            dateChooser.setDate(date);
//        }
        return dateChooser;
    }

    @Override
    public Object getCellEditorValue() {
        DateFormat temp = new SimpleDateFormat(this.dateFormat);
        return temp.format(dateChooser.getDate());
    }
    
   
    
}
