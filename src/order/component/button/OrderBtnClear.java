package order.component.button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTable;

import order.controller.button.bottom.OrderClearBtnClickListener;

public class OrderBtnClear extends JButton{

	public OrderBtnClear(String btnName, JTable table) {
		super(btnName);
		setBackground(new Color(0x663300));
		setForeground(Color.white);
		setFont(new Font("야놀자야체", Font.BOLD, 16));
		setPreferredSize(new Dimension(110, 100));
		setBorderPainted(false);

		setFocusPainted(false);
		addActionListener(new OrderClearBtnClickListener(table));
	}
	
}
