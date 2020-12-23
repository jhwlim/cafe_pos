package order.component.button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;

import order.controller.button.bottom.OrderDrinkBtnClickListener;

public class OrderBtnDrink extends OrderBtnSetBasic {

	public OrderBtnDrink(String btnName, JPanel menu_panel) {
		super(btnName);
		setBackground(new Color(0x663300));
		setForeground(Color.white);
		setFont(new Font("야놀자야체", Font.BOLD, 36));
		setPreferredSize(new Dimension(110, 100));
		setFocusPainted(false);
		addActionListener(new OrderDrinkBtnClickListener(menu_panel));
	}

}
