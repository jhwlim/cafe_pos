package order.component.button;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class OrderBtn2 extends JButton {
	
	public OrderBtn2(String btnName) {
		super(btnName);
		setPreferredSize(new Dimension(50, 50));
		setFont(new Font("맑은고딕", Font.BOLD, 25));
	}
}
