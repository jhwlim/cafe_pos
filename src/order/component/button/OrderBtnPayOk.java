package order.component.button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;


public class OrderBtnPayOk extends JButton{

	public OrderBtnPayOk(String btnName) {
		super(btnName);
		setBackground(new Color(0x663300));
		setForeground(Color.white);
		setFont(new Font("야놀자야체", Font.BOLD, 16));
		setPreferredSize(new Dimension(110, 60));
		setBorderPainted(false);
		
	}
}
