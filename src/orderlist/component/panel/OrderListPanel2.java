package orderlist.component.panel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class OrderListPanel2 extends JPanel {

	private static final int COLOR_INT = 0x000000;
	public static final Color PANEL_COLOR = new Color(COLOR_INT);

	private static final int X_MARGIN = 0;
	private static final int Y_MARGIN = 0;

	public OrderListPanel2() {
		setDefaultConfig();
		setComponents();
	}

	public void setDefaultConfig() {
		setLayout(new BorderLayout(X_MARGIN, Y_MARGIN));
		setBackground(Color.blue);
	}

	public void setComponents() {
		OrderListTitlePanel2 titlePanel = new OrderListTitlePanel2();
		add(titlePanel, BorderLayout.NORTH);

		OrderListTablePanel2 centerPanel = new OrderListTablePanel2();
		add(centerPanel);
	}

}
