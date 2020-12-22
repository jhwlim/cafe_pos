package order.component.button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTable;

import order.controller.button.OrderClearBtnClickListener;

public class OrderBtnSetBasic extends JButton {
	
	public OrderBtnSetBasic(String btnName) {
		
		
		
		super(btnName);
//		setPreferredSize(new Dimension(90, 90));
		setBorderPainted(false);
		setBackground(new Color(0x663300));
		setFont(new Font("야놀자야체", Font.BOLD, 16));
		setPreferredSize(new Dimension(105, 100));
		setForeground(Color.white);
		setFocusPainted(false);
	
	}
}
