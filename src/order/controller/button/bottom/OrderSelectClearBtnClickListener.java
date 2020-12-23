package order.controller.button.bottom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class OrderSelectClearBtnClickListener implements ActionListener {

	JTable table;
	DefaultTableModel dtm;
		
	public OrderSelectClearBtnClickListener(JTable table, DefaultTableModel dtm) {
		this.table = table;
		this.dtm = dtm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int rowindex = table.getSelectedRow();
		if (rowindex == -1)
			return;
		dtm.removeRow(rowindex);
	}

}
