package orderlist.component.button;

import java.awt.Dimension;

import javax.swing.JButton;

public class OrderListButton extends JButton{

	public OrderListButton(String btnName) {
		super(btnName);
		setPreferredSize(new Dimension(90, 90));
	}
	
}
