package order.component.Label;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class OrderLbBasic extends JLabel{

	public OrderLbBasic(String lbName) {
		super(lbName);
		setBackground(new Color(0x663300));
		setForeground(Color.white);
		setFont(new Font("야놀자야체", Font.BOLD, 40));

		
	}
}
