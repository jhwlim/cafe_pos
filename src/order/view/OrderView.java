package order.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

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
		menu_panel.setBackground(new Color(0x186f3d));
		
		// 중간부
		panel.add(C_panel, BorderLayout.CENTER);
		C_panel.setBackground(new Color(0x186f3d));

		JTable table = new JTable(dtm) {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
				Component comp = super.prepareRenderer(renderer, row, col);
				Color alternateColor = new Color(0xe3e3bc);
				Color whiteColor = Color.white;
				if (!comp.getBackground().equals(getSelectionBackground())) {
					Color c = (row % 2 == 0 ? alternateColor : whiteColor);
					comp.setBackground(c);
				}
				
				return comp;
			}
		};
		
		JScrollPane jsp = new JScrollPane(table);
		C_panel.add(jsp);

		jsp.getViewport().setBackground(new Color(0xFFFFE9));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);

		table.getTableHeader().setReorderingAllowed(false); // 컬럼 고정
		table.getTableHeader().setResizingAllowed(false); // 사이즈 고정
		jsp.setPreferredSize(new Dimension(900, 250));

		JTable table2 = new JTable(table.getModel());

		JScrollPane jsp2 = new JScrollPane(table2);
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(new Color(0x663300));
		tableHeader.setForeground(new Color(0xffffff));
		
		// 하단부
		panel.add(B_panel, BorderLayout.SOUTH);
		B_panel.setBackground(new Color(0x186f3d));

		
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

		btn_pay.addActionListener(new OrderPayBtnClickOpenFrameListener(table, table2, jsp2));
		
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
