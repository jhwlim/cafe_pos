package order.controller.button;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class OrderFoodBtnClickListener implements ActionListener {

	JPanel panel;
	
	public OrderFoodBtnClickListener(JPanel panel) {
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		((CardLayout) panel.getLayout()).show(panel, "Food");
	}

}
