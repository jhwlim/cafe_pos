package order.controller.button.bottom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import order.dao.StockDao;
import order.dao.StockDaoImpl;

public class OrderPlusBtnClickListener implements ActionListener {

	JTable table;

	public OrderPlusBtnClickListener(JTable table) {
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		
		int row = table.getSelectedRow();
		int col = 3;
		int count = (int) table.getValueAt(row, col);

		StockDao stockDao = StockDaoImpl.getInstance();
		int totalAmount = stockDao.selectAmountOfMenu((int) table.getValueAt(row, 0));
		
		if (totalAmount - count > 0) {
			if (count < 9) {
				table.setValueAt(count + 1, row, col);
			} else {
				JOptionPane.showMessageDialog(null, "각 수량은 9개를 초과할수 없습니다", "경고",
						JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "재고 부족", "재고 현황", JOptionPane.ERROR_MESSAGE);
		}
		

	};
}
