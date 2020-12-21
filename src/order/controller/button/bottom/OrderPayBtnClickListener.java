package order.controller.button.bottom;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class OrderPayBtnClickListener implements ActionListener {

	JPanel panel;

	public OrderPayBtnClickListener(JPanel panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((CardLayout) panel.getLayout()).show(panel, "Pay");
	}
}
