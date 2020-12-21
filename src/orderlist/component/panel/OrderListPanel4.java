package orderlist.component.panel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;


public class OrderListPanel4 extends JPanel {
	
	private static final int COLOR_INT = 0x000000;
	public static final Color PANEL_COLOR = new Color(COLOR_INT);
	
	private static final int X_MARGIN = 0;
	private static final int Y_MARGIN = 0;
	
	public OrderListPanel4() {
		setDefaultConfig();
		setComponents();
	}
	
	public void setDefaultConfig() {
		setLayout(new BorderLayout(X_MARGIN, Y_MARGIN));
		setBackground(Color.pink);
	}
	
	public void setComponents() {
		OrderListTitlePanel4 titlePanel = new OrderListTitlePanel4();
		add(titlePanel, BorderLayout.NORTH);
		
		OrderListTablePanel4 centerPanel = new OrderListTablePanel4();
		add(centerPanel);
	}
	
	
}
