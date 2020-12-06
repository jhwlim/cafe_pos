package main.component.frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	static final int FRAME_WIDTH = 1300;
	static final int FRAME_HEIGHT = 1000;
	
	private static final int X_MARGIN = 5;
	private static final int Y_MARGIN = 5;
	
	private static final Color BG_COLOR = Color.gray;
	
	public MainFrame() {
		setTitle("Title");
		
		setLayout(new CardLayout(X_MARGIN, Y_MARGIN)); // 레이아웃 설정
		
		getContentPane().setBackground(BG_COLOR); // 백그라운드 색 지정
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocationRelativeTo(null); // 프로그램을 윈도우 가운데 위치

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

}
