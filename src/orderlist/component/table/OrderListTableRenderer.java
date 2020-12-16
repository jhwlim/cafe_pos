package orderlist.component.table;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class OrderListTableRenderer extends DefaultTableCellRenderer {
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component comp = null;
		if (column == 5) {
			JCheckBox checkbox = (JCheckBox) value;
			return checkbox;
//			return new JCheckBox();
//			comp.setPreferredSize(new Dimension(10, 10));
		}
		return comp;
	}
	
}
