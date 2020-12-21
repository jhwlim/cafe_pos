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
	int index;
	
	public OrderListPanel(int orderId, int index) {
		this.orderId = orderId;
		this.index = index;
		setDefaultConfig();
		setComponents();
	}

	public void setDefaultConfig() {
		setLayout(new BorderLayout(X_MARGIN, Y_MARGIN));
		setBackground(PANEL_COLOR);
	}

	public void setComponents() {
		OrderListTitlePanel titlePanel = new OrderListTitlePanel(orderId);
		add(titlePanel, BorderLayout.NORTH);

		OrderListTablePanel centerPanel = new OrderListTablePanel(orderId);
		add(centerPanel);
		
		OrderListBtnPanel btnPanel = new OrderListBtnPanel(index);
		add(btnPanel, BorderLayout.SOUTH);
	}

}
