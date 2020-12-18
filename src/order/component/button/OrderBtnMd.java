package order.component.button;

import javax.swing.JPanel;

import order.controller.button.OrderFoodBtnClickListener;
import order.controller.button.OrderMdBtnClickListener;

public class OrderBtnMd extends OrderBtnSetBasic{

	public OrderBtnMd(String btnName, JPanel menu_panel) {
		super(btnName);
		
		addActionListener(new OrderMdBtnClickListener(menu_panel));
	}
}
