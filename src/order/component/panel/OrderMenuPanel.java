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
import order.controller.button.menu.OrderMenuBtnClickAddListener;
import order.dao.MenuDao;
import order.dao.MenuDaoImpl;

public class OrderMenuPanel extends JPanel {
	
	public OrderMenuPanel(DefaultTableModel dtm) {
		
		this.setLayout(new CardLayout(10, 10));
		this.setPreferredSize(new Dimension(0, 580));

		JPanel drinkPanel = new JPanel();// 메인 패널 위에 메뉴패널
		JPanel foodPanel = new JPanel();// 메인 패널 위에 메뉴패널
		JPanel mdPanel = new JPanel();// 메인 패널 위에 메뉴패널

		this.add(drinkPanel, "Drink");
		this.add(foodPanel, "Food");
		this.add(mdPanel, "MD");
		
		MenuDao dao = MenuDaoImpl.getInstance();
//		List<String> drinkList = dao.selectByCategory("drink");
//		List<String> mdList = dao.selectByCategory("md");
//		List<String> foodList = dao.selectByCategory("food");
		
		List<MenuVO> list = dao.selectAll();
//		List<MenuVO> drinkMenuList = dao.selectAllByCategory("drink");
//		List<MenuVO> foodMenuList = dao.selectAllByCategory("food");
//		List<MenuVO> mdMenuList = dao.selectAllByCategory("md");

		for (int i = 0; i < list.size(); i++) {
			MenuVO menu = list.get(i);
			String imgPath = menu.getMenuImg();
			String category = menu.getMenuCategory();
			
			Image image = new ImageIcon(imgPath).getImage()
												 .getScaledInstance(175, 175, Image.SCALE_REPLICATE);

			ImageIcon imageIcon = new ImageIcon(image);

			JButton btn = new JButton(imageIcon);

			btn.addActionListener(new OrderMenuBtnClickAddListener(dtm, menu));
			
			switch (category) {
			case "drink" :
				drinkPanel.add(btn).setPreferredSize(new Dimension(175, 175));
				break;
			case "food" :
				foodPanel.add(btn).setPreferredSize(new Dimension(175, 175));
				break;
			case "md" :
				mdPanel.add(btn).setPreferredSize(new Dimension(175, 175));
				break;
			}
		}
		
		/*
		for (int i = 0; i < drinkList.size(); i++) {

			Image C_D_Image = new ImageIcon(drinkList.get(i)).getImage().getScaledInstance(175, 175,
					Image.SCALE_REPLICATE);

			ImageIcon USE_D_Image = new ImageIcon(C_D_Image);

			JButton dbtn = new JButton(USE_D_Image);

			D_panel.add(dbtn).setPreferredSize(new Dimension(175, 175));

			MenuVO menu = drinkMenuList.get(i);

			dbtn.addActionListener(new OrderMenuBtnClickAddListener(dtm, menu));
			
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
		}*/
	}
}
