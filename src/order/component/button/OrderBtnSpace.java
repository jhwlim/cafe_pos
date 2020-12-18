package order.component.button;

import java.awt.Dimension;

import javax.swing.JButton;

public class OrderBtnSpace extends JButton{

	public OrderBtnSpace(){
		super();
		setPreferredSize(new Dimension(90, 90));
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
	}
	
}
