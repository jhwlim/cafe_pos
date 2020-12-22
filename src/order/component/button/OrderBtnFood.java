package order.component.button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;

import order.controller.button.bottom.OrderFoodBtnClickListener;

public class OrderBtnFood extends OrderBtnSetBasic {
	
	public OrderBtnFood(String btnName, JPanel menu_panel) {
		super(btnName);
		setBackground(new Color(0x663300));
		setFont(new Font("야놀자야체", Font.BOLD, 36));
		setPreferredSize(new Dimension(110, 100));
		setForeground(Color.white);
		setBorderPainted(false);

		setFocusPainted(false);
		addActionListener(new OrderFoodBtnClickListener(menu_panel));
	}
}
