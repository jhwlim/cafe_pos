package order.component.button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;

import order.controller.button.bottom.OrderFoodBtnClickListener;
import order.controller.button.bottom.OrderMdBtnClickListener;

public class OrderBtnMd extends OrderBtnSetBasic{

	public OrderBtnMd(String btnName, JPanel menu_panel) {
		super(btnName);
		setBackground(new Color(0x663300));
		setForeground(Color.white);
		setFont(new Font("야놀자야체", Font.BOLD, 36));
		setPreferredSize(new Dimension(110, 100));
		setBorderPainted(false);

		setFocusPainted(false);
		addActionListener(new OrderMdBtnClickListener(menu_panel));
	}
}
