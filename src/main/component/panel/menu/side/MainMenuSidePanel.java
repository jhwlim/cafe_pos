package main.component.panel.menu.side;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class MainMenuSidePanel extends JPanel {
	
	public static final Color COLOR = new Color(0x663300);
	
	public static final int WIDTH = 300;
	public static final int HEIGHT = 0;
	
	public MainMenuSidePanel() {
		setDefaultConfig();
		setComponents();
	}
	
	private void setDefaultConfig() {
//		setBackground(COLOR);
//		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(new BorderLayout(0, 10));
	}
	
	private void setComponents() {
		add(MainMenuSideCenterPanel.getInstance(), BorderLayout.CENTER);
		
		add(MainMenuSideDownPanel.getInstance(), BorderLayout.SOUTH);
	}
	
}
