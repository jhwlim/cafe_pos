package order.component.table;

import javax.swing.table.DefaultTableModel;

public class OrderTable {

	public OrderTable() {
		String title[] = { "번호", "메뉴", "가격", "개수" };

		new DefaultTableModel(title, 0) {
			public boolean isCellEditable(int row, int column) {
				if (column >= 0) {
					return false;
				} else {
					return true;
				}
			}
		};
		//

	}
}
