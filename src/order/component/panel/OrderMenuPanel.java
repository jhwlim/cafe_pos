package order.component.panel;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import common.model.MenuVO;
import order.dao.MenuDao;
import order.dao.MenuDaoImpl;

public class OrderMenuPanel extends JPanel {
	
	public OrderMenuPanel(DefaultTableModel dtm) {
		
		this.setLayout(new CardLayout(10, 10));
		this.setPreferredSize(new Dimension(0, 580));

		JPanel D_panel = new JPanel();// 메인 패널 위에 메뉴패널
		JPanel F_panel = new JPanel();// 메인 패널 위에 메뉴패널
		JPanel M_panel = new JPanel();// 메인 패널 위에 메뉴패널

		this.add(D_panel, "Drink");
		this.add(F_panel, "Food");
		this.add(M_panel, "MD");
		
		MenuDao dao = MenuDaoImpl.getInstance();
		List<String> drinkList = dao.selectByCategory("drink");
		List<String> mdList = dao.selectByCategory("md");
		List<String> foodList = dao.selectByCategory("food");
		
		List<MenuVO> list = dao.selectAll();
		List<MenuVO> drinkMenuList = dao.selectAllByCategory("drink");
		List<MenuVO> foodMenuList = dao.selectAllByCategory("food");
		List<MenuVO> mdMenuList = dao.selectAllByCategory("md");

		for (int i = 0; i < list.size(); i++) {
			MenuVO menu = list.get(i);
			String category = menu.getMenuCategory();
			switch (category) {
			case "drink" :
				break;
			case "food" :
				break;
			case "md" :
				break;
			}
		}
		
		for (int i = 0; i < drinkList.size(); i++) {

			Image C_D_Image = new ImageIcon(drinkList.get(i)).getImage().getScaledInstance(175, 175,
					Image.SCALE_REPLICATE);

			ImageIcon USE_D_Image = new ImageIcon(C_D_Image);

			JButton dbtn = new JButton(USE_D_Image);

			D_panel.add(dbtn).setPreferredSize(new Dimension(175, 175));

			MenuVO menu = drinkMenuList.get(i);

			dbtn.addActionListener(new ActionListener() {

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

			});
		}

		for (int i = 0; i < foodList.size(); i++) {

			Image C_F_Image = new ImageIcon(foodList.get(i)).getImage().getScaledInstance(175, 175,
					Image.SCALE_REPLICATE);

			ImageIcon USE_F_Image = new ImageIcon(C_F_Image);

			JButton fbtn = new JButton(USE_F_Image);

			F_panel.add(fbtn).setPreferredSize(new Dimension(175, 175));

			MenuVO menu = foodMenuList.get(i);

			fbtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					boolean flag = false;
					int i = 0;

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

			});
		}

		for (int i = 0; i < mdList.size(); i++) {
			Image C_M_Image = new ImageIcon(mdList.get(i)).getImage().getScaledInstance(175, 175,
					Image.SCALE_REPLICATE);

			ImageIcon USE_M_Image = new ImageIcon(C_M_Image);

			JButton mbtn = new JButton(USE_M_Image);

			M_panel.add(mbtn).setPreferredSize(new Dimension(175, 175));

			MenuVO menu = mdMenuList.get(i);

			mbtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					boolean flag = false;
					int i = 0;

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

			});
		}
	}
}
