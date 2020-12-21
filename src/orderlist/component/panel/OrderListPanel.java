package orderlist.component.panel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class OrderListPanel extends JPanel {

	private static final int COLOR_INT = 0x000000;
	public static final Color PANEL_COLOR = new Color(COLOR_INT);

	private static final int X_MARGIN = 0;
	private static final int Y_MARGIN = 0;

	int orderId;
	
	public OrderListPanel(int orderId) {
		this.orderId = orderId;
		
		System.out.println("생성");
		setDefaultConfig();
		setComponents();
	}

	public void setDefaultConfig() {
		setLayout(new BorderLayout(X_MARGIN, Y_MARGIN));
		setBackground(PANEL_COLOR);
	}

	public void setComponents() {
		OrderListTitlePanel titlePanel = new OrderListTitlePanel();
		add(titlePanel, BorderLayout.NORTH);

		OrderListTablePanel centerPanel = new OrderListTablePanel(orderId);
		add(centerPanel);
		
		OrderListBtnPanel btnPanel = new OrderListBtnPanel();
		add(btnPanel, BorderLayout.SOUTH);
	}

}
