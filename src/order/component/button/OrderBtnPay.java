package order.component.button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

//import order.controller.button.bottom.OrderPayBtnClickListener;

public class OrderBtnPay extends JButton{

	public OrderBtnPay(String btnName, JPanel menu_panel) {
		super(btnName);
		
		setBackground(new Color(0x663300));
		setForeground(Color.white);
		setFocusPainted(false);
		setBorderPainted(false);

		setFont(new Font("야놀자야체", Font.BOLD, 30));
		setPreferredSize(new Dimension(105, 100));
	
//		addActionListener(new OrderPayBtnClickListener(menu_panel));
	}
}
