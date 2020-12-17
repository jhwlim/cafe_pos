package orderlist.component.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class OrderListTitlePanel extends JPanel {

	public static final Color PANEL_COLOR = OrderListPanel.PANEL_COLOR;
	
	public static final int WIDHT = 0;
	public static final int HEIGHT = 80;
	
	public OrderListTitlePanel() {
		setDefaultConfig();
		setComponents();
	}
	
	public void setDefaultConfig() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setBackground(PANEL_COLOR);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}
	
	public void setComponents() {
		JLabel label = new JLabel();
		label.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		label.setText("대기 주문 목록");
		label.setForeground(Color.white);
		label.setVerticalAlignment(JLabel.CENTER);
		add(label);
	}
}
