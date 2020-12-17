package orderlist.component.table;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import orderlist.common.config.OrderListConfig;

public class OrderListTableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

	JButton button;
	JTable table;

	public OrderListTableCell(JTable table) {
		this.table = table;
		button = new JButton("처리완료");

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				OrderListConfig.getList().remove(row);
				((AbstractTableModel) table.getModel()).fireTableRowsDeleted(row, row+1);
			}
		});
	}



	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		return button;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		return button;
	}

}
