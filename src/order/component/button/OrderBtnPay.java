package order.component.button;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

//import order.controller.button.bottom.OrderPayBtnClickListener;

public class OrderBtnPay extends JButton{

	public OrderBtnPay(String btnName, JPanel menu_panel) {
		super(btnName);
		setPreferredSize(new Dimension(90, 90));
	
//		addActionListener(new OrderPayBtnClickListener(menu_panel));
	}
}
