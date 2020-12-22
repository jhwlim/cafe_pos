package order.component.button;

import java.awt.Dimension;

import javax.swing.JButton;

public class OrderBtnSpace extends JButton{

	public OrderBtnSpace(){
		super();
		setPreferredSize(new Dimension(75, 90));
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
	}
	
}
