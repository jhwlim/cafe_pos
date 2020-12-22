package test;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import orderlist.view.OrderListTime;

public class TimeLabelTest extends JFrame {
	
	public TimeLabelTest() {
	
		setLayout(new CardLayout());
		JLabel label = new OrderListTime();
//		label.setBounds(100, 100, 30, 30);
		add(label);
		
		setSize(500, 500);
		
		setLocationRelativeTo(null); // 프로그램을 윈도우 가운데 위치
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TimeLabelTest();
	}
}
