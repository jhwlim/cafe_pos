package orderlist.component.panel;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OrderListBtnPanel extends JPanel {
	
	public OrderListBtnPanel() {
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton btn = new JButton("버튼");
		btn.setPreferredSize(new Dimension(80, 50));
		add(btn);
	}
}
