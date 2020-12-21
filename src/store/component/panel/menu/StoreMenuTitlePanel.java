package store.component.panel.menu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import common.font.SidePanelTitleLabelFont;
import employee.component.label.menu.EmpMenuTitleLabel;
import main.component.panel.content.SideUpPanel;
import store.component.label.menu.StoreMenuTitleLabel;

public class StoreMenuTitlePanel extends JPanel {
		
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
		setBackground(new Color(StoreMenuPanel.COLOR));
	}
	
	private void setComponents() {
		JLabel title = new StoreMenuTitleLabel("Store Info. Management");
		add(title);
	}
	
	
}
