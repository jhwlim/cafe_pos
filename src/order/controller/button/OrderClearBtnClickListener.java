package order.controller.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class OrderClearBtnClickListener implements ActionListener {

	JTable table;

	public OrderClearBtnClickListener(JTable table) {
		this.table = table;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);
	};

}
