package main.component.panel.menu.side;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenuSideLabelPanel extends JPanel {

	String field;
	String info;
	
	public MainMenuSideLabelPanel(String field, String info) {
		this.field = field;
		this.info = info;
		
		setDefaultConfig();
		setComponents();
	}
	
	private void setDefaultConfig() {
		setLayout(new BorderLayout());
		setBackground(MainMenuSidePanel.COLOR);
	}
	
	private void setComponents() {
		JLabel fieldtext = new JLabel(field);
		fieldtext.setFont(new Font("맑은 고딕", Font.BOLD, 20));	
		add(fieldtext, BorderLayout.NORTH);
		
		JLabel text = new JLabel(info);
		text.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		add(text, BorderLayout.CENTER);
	}
	
	
}
