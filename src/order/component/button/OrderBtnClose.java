package order.component.button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class OrderBtnClose extends JButton{

	JFrame frame; 
	
	public OrderBtnClose(String btnName, JFrame frame) {
		super(btnName);
		setBackground(new Color(0x663300));
		setForeground(Color.white);
		setFont(new Font("야놀자야체", Font.BOLD, 16));
		setPreferredSize(new Dimension(110, 60));
		setBorderPainted(false);

		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		
	}
	
}
