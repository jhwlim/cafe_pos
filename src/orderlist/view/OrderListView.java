package orderlist.view;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.component.button.MenuBtnEnum;
import main.component.panel.ContentPanel;
import orderlist.component.panel.OrderListPanel;

public class OrderListView {

	public static JPanel panel;
	
	static final int X_MARGIN = 100;
	static final int Y_MARGIN = 100;
	
	static {
		panel = ContentPanel.getPanel(MenuBtnEnum.ORDERLIST);
		panel.setLayout(new CardLayout(X_MARGIN, Y_MARGIN));
		panel.setBackground(Color.white);
	}
	
	public OrderListView() {
		
		// 패널 초기화
		panel.removeAll();
		
		OrderListPanel orderListPanel = new OrderListPanel();
		panel.add(orderListPanel);
		
	}
	
	public static JPanel getContentPanel() {
		return panel;
	}
}