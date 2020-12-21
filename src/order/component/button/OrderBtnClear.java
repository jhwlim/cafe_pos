package order.component.button;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTable;

import order.controller.button.bottom.OrderClearBtnClickListener;

public class OrderBtnClear extends JButton{

	public OrderBtnClear(String btnName, JTable table) {
		super(btnName);
		setPreferredSize(new Dimension(90, 90));
		addActionListener(new OrderClearBtnClickListener(table));
	}
	
}
