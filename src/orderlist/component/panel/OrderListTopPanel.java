package orderlist.component.panel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class OrderListTopPanel extends JPanel {

	public OrderListTopPanel(String panelName) {
		
		setForeground(Color.white);
//		setBorder(BorderFactory.createTitledBorder(Border borer, panelName,50,50, Font.BOLD, new Color(0x663300)));
		setBorder(BorderFactory.createTitledBorder(panelName));
		BorderFactory.createTitledBorder(panelName).setTitleColor(new Color(0x00000));
//		setBorder(BorderFactory.createLineBorder(new Color(0x663300)));
		setBackground(new Color(0x186f3d));

		
		setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
	}

}
