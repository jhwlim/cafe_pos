package order.component.panel;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class OrderPayTopPanel extends JPanel {

	public OrderPayTopPanel(String panelName) {
		setBorder(BorderFactory.createTitledBorder(panelName));
		setBackground(Color.white);
	}
	
}
