package order.component.button;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;

import order.controller.button.OrderMinusBtnClickListener;
import order.controller.button.OrderPlusBtnClickListener;

public class OrderBtnPlusMinus extends JButton{
	
	
	public OrderBtnPlusMinus(String btnName, JTable table) {
		super(btnName);
		setPreferredSize(new Dimension(50, 50));
		setFont(new Font("맑은고딕", Font.BOLD, 25));
	
	switch (btnName) {
	case "+":
		addActionListener(new OrderPlusBtnClickListener(table));
		break;
	case "-":
		addActionListener(new OrderMinusBtnClickListener(table));
		break;
	}
		
	}
}

