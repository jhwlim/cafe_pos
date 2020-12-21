package order.component.button;

import javax.swing.JPanel;

import order.controller.button.bottom.OrderDrinkBtnClickListener;

public class OrderBtnDrink extends OrderBtnSetBasic {

	public OrderBtnDrink(String btnName, JPanel menu_panel) {
		super(btnName);

		addActionListener(new OrderDrinkBtnClickListener(menu_panel));
	}

}
