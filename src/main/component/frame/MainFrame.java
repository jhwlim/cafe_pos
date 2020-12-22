package main.component.frame;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;

import orderlist.controller.window.SystemWindowListener;

public class MainFrame extends JFrame {
	
	static final int FRAME_WIDTH = 1300;
	static final int FRAME_HEIGHT = 1000;
	
	private static final int X_MARGIN = 0;
	private static final int Y_MARGIN = 0;
	
	private static final Color BG_COLOR = new Color(0x000000);
	
	public MainFrame() {
		setTitle("STARBUCKS");
		
		setLayout(new CardLayout(X_MARGIN, Y_MARGIN)); // 레이아웃 설정
		
		getContentPane().setBackground(BG_COLOR); // 백그라운드 색 지정
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		
		setLocationRelativeTo(null); // 프로그램을 윈도우 가운데 위치
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		this.addWindowListener(new SystemWindowListener());
	}
	

}
