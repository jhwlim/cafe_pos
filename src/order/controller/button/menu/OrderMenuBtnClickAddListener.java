package order.controller.button.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import common.model.MenuVO;

public class OrderMenuBtnClickAddListener implements ActionListener {

	DefaultTableModel dtm;
	MenuVO menu;

	public OrderMenuBtnClickAddListener(DefaultTableModel dtm, MenuVO menu) {
		this.dtm = dtm;
		this.menu = menu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean flag = false;
		int i = 0;

		// 테이블의 row를 한바퀴 돌면서 menuId가 있는지를 확인해서 있으면 flag를 true하고, break하는 코드
		// 멈추는 곳이 i = 같은 menuId가 있는 row
		for (i = 0; i < dtm.getRowCount(); i++) {
			if (menu.getMenuId() == (int) dtm.getValueAt(i, 0)) {
				flag = true;
				break;
			}
		}

		if (!flag) {
			dtm.addRow(new Object[] { menu.getMenuId(), menu.getMenuName(), menu.getMenuCost(), 1 });
		} else {
			int count = (int) dtm.getValueAt(i, 3);
			if (count >= 9) {
				JOptionPane.showMessageDialog(null, "각 수량은 9개를 초과할수 없습니다", "경고",
						JOptionPane.WARNING_MESSAGE);
			} else {
				count += 1; // 버튼 눌린 횟수
				dtm.setValueAt(count, i, 3);

			}

		}

	}
}