package order.component.button;

import javax.swing.JPanel;

import order.controller.button.OrderFoodBtnClickListener;

public class OrderFoodBtn extends OrderBtn1 {
	
	public OrderFoodBtn(String btnName, JPanel menu_panel) {
		super(btnName);
		
		addActionListener(new OrderFoodBtnClickListener(menu_panel));
	}
}
