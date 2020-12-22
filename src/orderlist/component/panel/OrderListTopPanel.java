package orderlist.component.panel;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class OrderListTopPanel extends JPanel {

	public OrderListTopPanel(String panelName) {
		setBorder(BorderFactory.createTitledBorder(panelName));
		setBackground(Color.white);
		setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
	}

}
