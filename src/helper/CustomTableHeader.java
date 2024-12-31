/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author samtheradiant
 */
public class CustomTableHeader extends JTableHeader {
    
    public CustomTableHeader(TableColumnModel cm) {
        super(cm);
        setBackground(new Color(16, 17, 25));
        setForeground(new Color(240, 242, 239));
        setResizingAllowed(true);
        setReorderingAllowed(false);
    }
    
    @Override
    public Dimension getPreferredSize() {
        Dimension dimension = super.getPreferredSize();
        dimension.height = 35;
        return dimension;
    }
    
}
