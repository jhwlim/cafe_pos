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
import main.component.panel.content.ContentPanel;
import order.component.button.OrderBtnSetBasic;
import order.component.button.OrderBtnSpace;
import order.component.frame.OrderPayFrame;
import order.component.button.OrderBtnPlusMinus;
import order.component.button.OrderBtnClear;
import order.component.button.OrderBtnClose;
import order.component.button.OrderBtnDrink;
import order.component.button.OrderBtnFood;
import order.component.button.OrderBtnMd;
import order.component.button.OrderBtnPay;
import order.component.panel.OrderBottomPanel;
import order.component.panel.OrderPayCenterPanel;
import order.component.panel.OrderMenuPanel;
import order.component.panel.OrderPayBottomPanel;
import order.component.panel.OrderPayTopPanel;
import order.component.panel.OrderTablePanel;
import order.controller.button.bottom.OrderPayBtnClickOpenFrameListener;
import order.controller.button.bottom.OrderPlusBtnClickListener;
import order.controller.button.bottom.OrderSelectClearBtnClickListener;
import order.dao.MenuDao;
import order.dao.MenuDaoImpl;
import order.dao.OrderDao;
import order.dao.OrderDaoImpl;
import store.common.config.StoreConfig;

// 구조
// - 상단 -> 클래스 생성 (JPanel을 상속받는)
// - 중간 -> 클래스 생성
// - 하단 -> 클래스 생성
public class OrderView {

	public static JPanel panel;

	public static JButton btn_clear;
	
	static {
		panel = ContentPanel.getPanel(MenuBtnEnum.ORDER);

		panel.setLayout(new BorderLayout());

		// 필드 생성
		String title[] = { "번호", "메뉴", "가격", "개수" };

		DefaultTableModel dtm = new DefaultTableModel(title, 0) {
			public boolean isCellEditable(int row, int column) {
				if (column >= 0) {
					return false;
				} else {
					return true;
				}
			}
		};

		JPanel menu_panel = new OrderMenuPanel(dtm);// 메인 패널 위에 메뉴패널
		JPanel C_panel = new OrderTablePanel();// 센터 패널
		JPanel B_panel = new OrderBottomPanel();// 하단 패널

		// 상단부
		panel.add(menu_panel, BorderLayout.NORTH);

		// 중간부
		panel.add(C_panel, BorderLayout.CENTER);

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
		panel.add(B_panel, BorderLayout.SOUTH);

		// 아래 패널
		JButton btn_drink = new OrderBtnDrink("음료", menu_panel);
		JButton btn_Food = new OrderBtnFood("푸드", menu_panel);
		JButton btn_M = new OrderBtnMd("MD", menu_panel);

		JButton btn_plus = new OrderBtnPlusMinus("+", table);
		JButton btn_minus = new OrderBtnPlusMinus("-", table);

		// 버튼 간격을 위한 투명 버튼
		JButton btn_space1 = new OrderBtnSpace();
		JButton btn_space2 = new OrderBtnSpace();

		btn_clear = new OrderBtnClear("전체 취소", table);
		JButton btn_selectClear = new OrderBtnSetBasic("선택 취소");
		JButton btn_pay = new OrderBtnPay("결제", menu_panel);

		// 아래패널
		btn_selectClear.addActionListener(new OrderSelectClearBtnClickListener(table, dtm));
		/*
		btn_selectClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int rowindex = table.getSelectedRow();
				if (rowindex == -1)
					return;
				dtm.removeRow(rowindex);
			}
		});*/

		btn_pay.addActionListener(new OrderPayBtnClickOpenFrameListener(table, table2, jsp2));
		/*
		btn_pay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame subFr = new OrderPayFrame("결제");

				JPanel top_panel = new OrderPayTopPanel("결제 페이지");
				JPanel bot_panel = new OrderPayBottomPanel();
				JPanel cen_panel = new OrderPayCenterPanel();

				JButton btn_ok = new JButton("결제");
				JButton btn_no = new OrderBtnClose("취소", subFr);

				int total_price = 0;
				int total_su = 0;

				for (int j = 0; j < table.getRowCount(); j++) {

					total_price += (int) table.getValueAt(j, 2) * (int) table.getValueAt(j, 3);

					total_su += (int) table.getValueAt(j, 3);

				}
				
				if (total_price == 0) {
					JOptionPane.showMessageDialog(null, "선택된 상품이 없습니다.", "경고",
							JOptionPane.WARNING_MESSAGE);
					subFr.dispose();
				}
				
				jsp2.setPreferredSize(new Dimension(400, 150));

				JLabel total_pri = new JLabel("총 금액 : " + String.valueOf(total_price));
				JLabel total_ea = new JLabel("총 갯수 : " + String.valueOf(total_su));

				subFr.add(top_panel, BorderLayout.NORTH);

				cen_panel.add(jsp2);

				cen_panel.add(total_pri);
				cen_panel.add(total_ea);
				
				

				subFr.add(cen_panel, BorderLayout.CENTER);
				subFr.add(bot_panel, BorderLayout.SOUTH);

				bot_panel.add(btn_ok);
				bot_panel.add(btn_no);

				// 결제 를 하면 넘어가는 단계 같이 해야할듯!
				btn_ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						int storeId = StoreConfig.getStoreId();
						
						if (storeId == StoreConfig.DEFAULT_STORE_ID) {
							JOptionPane.showMessageDialog(null, "매장 정보가 등록되어 있지 않습니다.", "경고",
									JOptionPane.WARNING_MESSAGE);
						} else {
							List<OrdersDetailVO> list = new ArrayList<OrdersDetailVO>();
							
							for (int i = 0; i < table2.getRowCount(); i++) {
								OrdersDetailVO detail = new OrdersDetailVO();
								detail.setMenuId((int) table2.getValueAt(i, 0));
								detail.setMenuCount((int) table2.getValueAt(i, 3));
								list.add(detail);
							
							}
							
							if (list.size() == 0) {
								JOptionPane.showMessageDialog(null, "선택된 상품이 없습니다.", "경고",
										JOptionPane.WARNING_MESSAGE);
							} else {
								OrderDao dao = OrderDaoImpl.getInstance();
								dao.insert(list);
								btn_clear.doClick();
							}
							
							subFr.dispose();
						}
						
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
		*/
		
		B_panel.add(btn_drink);
		B_panel.add(btn_Food);
		B_panel.add(btn_M);

		B_panel.add(btn_space1);

		B_panel.add(btn_plus);
		B_panel.add(btn_minus);

		B_panel.add(btn_space2);

		B_panel.add(btn_selectClear);
		B_panel.add(btn_clear);
		B_panel.add(btn_pay);

	}

	public OrderView() {

	}

}
