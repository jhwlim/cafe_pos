package order.controller.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;

public class OrderMinusBtnClickListener implements ActionListener {

	JTable table;

	public OrderMinusBtnClickListener(JTable table) {
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int row = table.getSelectedRow();
		int col = 3;
		int count = (int) table.getValueAt(row, col);

		if (count > 1) {
			table.setValueAt(count - 1, row, col);
		}
	};
}
