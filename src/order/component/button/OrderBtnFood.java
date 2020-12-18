package order.component.button;

import javax.swing.JPanel;

import order.controller.button.OrderFoodBtnClickListener;

public class OrderBtnFood extends OrderBtnSetBasic {
	
	public OrderBtnFood(String btnName, JPanel menu_panel) {
		super(btnName);
		
		addActionListener(new OrderFoodBtnClickListener(menu_panel));
//		addActionListener(new OrderDrinkBtnClickListener(menu_panel));
//		addActionListener(new OrderMdBtnClickListener(menu_panel));
	}
}
