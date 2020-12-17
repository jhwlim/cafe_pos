package order.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import common.model.MenuVO;
import common.model.OrdersDetailVO;
import main.component.button.MenuBtnEnum;
import main.component.panel.ContentPanel;
import order.dao.MenuDao;
import order.dao.MenuDaoImpl;
import order.dao.OrderDao;
import order.dao.OrderDaoImpl;

public class OrderView {

	public static JPanel panel;

	static {
		panel = ContentPanel.getPanel(MenuBtnEnum.ORDER);

		panel.setBackground(Color.red);// 중앙 색

		panel.setLayout(new BorderLayout());
		JPanel menu_panel = new JPanel(new CardLayout(10, 10));// 메인 패널 위에 메뉴패널?
		JPanel D_panel = new JPanel();// 메인 패널 위에 메뉴패널
		JPanel F_panel = new JPanel();// 메인 패널 위에 메뉴패널
		JPanel M_panel = new JPanel();// 메인 패널 위에 메뉴패널

		JPanel C_panel = new JPanel();// 센터 패널(공사중)

		JPanel B_panel = new JPanel();// 하단 패널 버튼

		// 상단부
		menu_panel.setBackground(Color.WHITE);
		panel.add(menu_panel, BorderLayout.NORTH);
		menu_panel.setPreferredSize(new Dimension(0, 580));

		menu_panel.add(D_panel, "Drink");
		menu_panel.add(F_panel, "Food");
		menu_panel.add(M_panel, "MD");

		// 중간부
		C_panel.setBackground(Color.WHITE);
		panel.add(C_panel, BorderLayout.CENTER);

		// 필드 생성

		String title[] = { "번호", "메뉴", "가격", "개수" };
		String title2[] = {"메뉴", "가격", "개수"};

		DefaultTableModel dtm = new DefaultTableModel(title, 0) {
			public boolean isCellEditable(int row, int column) {
				if (column >= 0) {
					return false;
				} else {
					return true;
				}
			}
		};


		JTable table = new JTable(dtm);

		JScrollPane jsp = new JScrollPane(table);
		C_panel.add(jsp);

		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);

		table.getTableHeader().setReorderingAllowed(false); // 컬럼 고정
		table.getTableHeader().setResizingAllowed(false); // 사이즈 고정
		jsp.setPreferredSize(new Dimension(870, 200));

		JTable table2 = new JTable(table.getModel());
		
		JScrollPane jsp2 = new JScrollPane(table2);

		
		// 하단부
		B_panel.setBackground(Color.WHITE);
		panel.add(B_panel, BorderLayout.SOUTH);
		B_panel.setPreferredSize(new Dimension(0, 100));

		// panel에 작업하는게 왼쪽 영역에 표시됨.

		MenuDao dao = MenuDaoImpl.getInstance();
		List<String> drinkList = dao.selectByCategory("drink");
		List<String> mdList = dao.selectByCategory("md");
		List<String> foodList = dao.selectByCategory("food");

		List<MenuVO> drinkMenuList = dao.selectAllByCategory("drink");
		List<MenuVO> foodMenuList = dao.selectAllByCategory("food");
		List<MenuVO> mdMenuList = dao.selectAllByCategory("md");


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

		JButton btn_drink = new JButton("음료");
		btn_drink.setPreferredSize(new Dimension(90, 90));
		JButton btn_Food = new JButton("푸드");
		btn_Food.setPreferredSize(new Dimension(90, 90));
		JButton btn_M = new JButton("MD");
		btn_M.setPreferredSize(new Dimension(90, 90));
		JButton btn_tocan = new JButton("전체 취소");
		btn_tocan.setPreferredSize(new Dimension(90, 90));
		JButton btn_pickdel = new JButton("선택 취소");
		btn_pickdel.setPreferredSize(new Dimension(90, 90));
		JButton btn_plus = new JButton("+");
		btn_plus.setPreferredSize(new Dimension(50, 50));
		JButton btn_minus = new JButton("-");
		btn_minus.setPreferredSize(new Dimension(50, 50));

		// + - 크기 조절
		btn_plus.setFont(new Font("맑은고딕", Font.BOLD, 25));
		btn_minus.setFont(new Font("맑은고딕", Font.BOLD, 25));

		// 버튼 간격을 위한 임시
		JButton temp1 = new JButton();
		temp1.setPreferredSize(new Dimension(90, 90));
		JButton temp2 = new JButton();
		temp2.setPreferredSize(new Dimension(90, 90));

		temp1.setBorderPainted(false);
		temp1.setContentAreaFilled(false);
		temp1.setFocusPainted(false);

		temp2.setBorderPainted(false);
		temp2.setContentAreaFilled(false);
		temp2.setFocusPainted(false);

		temp1.setOpaque(false);
		temp2.setOpaque(false);

		JButton btn_pay = new JButton("결제");
		btn_pay.setPreferredSize(new Dimension(90, 90));

		btn_drink.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) menu_panel.getLayout()).show(menu_panel, "Drink");
			}
		});

		btn_Food.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) menu_panel.getLayout()).show(menu_panel, "Food");
			}
		});

		btn_M.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) menu_panel.getLayout()).show(menu_panel, "MD");
			}
		});
		btn_tocan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setNumRows(0);
			}
		});
		btn_pay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) menu_panel.getLayout()).show(menu_panel, "Pay");
			}
		});
		btn_pickdel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int rowindex = table.getSelectedRow();
				if (rowindex == -1)
					return;
				dtm.removeRow(rowindex);
			}
		});

		btn_plus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int col = 3;
				int count = (int) table.getValueAt(row, col);

				if (count < 9) {
					table.setValueAt(count + 1, row, col);
				}
			}
		});

		btn_minus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int col = 3;
				int count = (int) table.getValueAt(row, col);

				if (count > 1) {
					table.setValueAt(count - 1, row, col);
				}
			}
		});

		btn_pay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame subFr = new JFrame("결제");
				subFr.setSize(600, 300);
				subFr.setLocationRelativeTo(null);
				subFr.setVisible(true);

				JPanel top_panel = new JPanel();
				JPanel bot_panel = new JPanel();
				JPanel cen_panel = new JPanel();

				int total_price = 0;
				int total_su = 0;
				
				for (int j = 0; j < table.getRowCount(); j++) {
					
					total_price += (int)table.getValueAt(j,2) * (int)table.getValueAt(j,3);
					
					total_su += (int)table.getValueAt(j, 3);
					
				}
				
				JButton btn_ok = new JButton("결제");
				JButton btn_no = new JButton("취소");

				top_panel.setBorder(BorderFactory.createTitledBorder("결제 페이지"));
				top_panel.setBackground(Color.white);
				subFr.add(top_panel, BorderLayout.NORTH);

				cen_panel.setBackground(Color.white);

				for (int i = 0; i < table.getRowCount(); i++) {
						
				}
				
				jsp2.setPreferredSize(new Dimension(400, 150));
				
				cen_panel.add(jsp2);
				
				
				JLabel total_pri = new JLabel("총 금액 : " + String.valueOf(total_price));
				JLabel total_ea = new JLabel("총 갯수 : " + String.valueOf(total_su));
				cen_panel.add(total_pri);
				cen_panel.add(total_ea);
				
				
				subFr.add(cen_panel, BorderLayout.CENTER);
				
				
				bot_panel.setBackground(Color.white);
				subFr.add(bot_panel, BorderLayout.SOUTH);
				bot_panel.add(btn_ok);
				bot_panel.add(btn_no);

				// 결제 를 하면 넘어가는 단계 같이 해야할듯!
				btn_ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						List<OrdersDetailVO> list = new ArrayList<OrdersDetailVO>();
						
						for (int i = 0; i < table2.getRowCount(); i++) {
							OrdersDetailVO detail = new OrdersDetailVO();
							detail.setMenuId((int) table2.getValueAt(i, 0));
							detail.setMenuCount((int) table2.getValueAt(i, 3));
							list.add(detail);
						
						}
						OrderDao dao = OrderDaoImpl.getInstance();
						dao.insert(list);
						btn_tocan.doClick();
						
						subFr.dispose();
					}
				});

				btn_no.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						subFr.dispose();
					}
				});
			}
		});

		B_panel.add(btn_drink);
		B_panel.add(btn_Food);
		B_panel.add(btn_M);

		B_panel.add(temp1);

		B_panel.add(btn_plus);
		B_panel.add(btn_minus);

		B_panel.add(temp2);

		B_panel.add(btn_pickdel);
		B_panel.add(btn_tocan);
		B_panel.add(btn_pay);

	}

	public OrderView() {

	}

}
