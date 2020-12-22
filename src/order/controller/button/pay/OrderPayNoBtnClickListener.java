package order.controller.button.pay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class OrderPayNoBtnClickListener implements ActionListener {

	JFrame subFr;
	
	public OrderPayNoBtnClickListener(JFrame subFr) {
		this.subFr = subFr;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		subFr.dispose();
	}
}
