package order.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class OrderBtnClose extends JButton{

	JFrame frame; 
	
	public OrderBtnClose(String btnName, JFrame frame) {
		super(btnName);
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		
	}
	
}
