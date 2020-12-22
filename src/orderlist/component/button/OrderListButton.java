package orderlist.component.button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class OrderListButton extends JButton{

	public OrderListButton(String btnName) {
		super(btnName);
		setBackground(new Color(0x663300));
		setForeground(Color.white);
		setFont(new Font("야놀자야체", Font.BOLD, 30));
		setPreferredSize(new Dimension(160, 70));
	}
	
}
