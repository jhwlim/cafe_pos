package store.component.panel.menu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;

import common.component.label.LogoLabel;
import common.font.SidePanelTitleLabelFont;
import employee.component.label.menu.EmpMenuTitleLabel;
import main.component.panel.content.SideUpPanel;
import store.component.label.menu.StoreMenuTitleLabel;

public class StoreMenuTitlePanel extends JPanel {
		
	public static final Color BG_COLOR = new Color(0xffffff);
	
	private static StoreMenuTitlePanel panel; 
	
	static {
		panel = new StoreMenuTitlePanel();
		
	}
	
	private StoreMenuTitlePanel() {
		setDefaultConfig();
		setComponents();
	}
	
	public static StoreMenuTitlePanel getInstance() {
		if (panel == null) {
			panel = new StoreMenuTitlePanel();
		}
		
		return panel;
	}
	
	private void setDefaultConfig() {		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setBackground(BG_COLOR);
	}
	
	private void setComponents() {
		try {
			JLabel title = new LogoLabel();
			add(title);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
