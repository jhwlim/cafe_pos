package store.component.panel.menu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.component.panel.SideUpPanel;

public class StoreMenuCenterPanel extends JPanel {
	
	static final int X_MARGIN = 0;
	static final int Y_MARGIN = 20;
	
	private static StoreMenuCenterPanel panel; 
	
	static {
		panel = new StoreMenuCenterPanel();
		
	}
	
	private StoreMenuCenterPanel() {
		setDefaultConfig();
		setComponents();
	}
	
	public static StoreMenuCenterPanel getInstance() {
		if (panel == null) {
			panel = new StoreMenuCenterPanel();
		}
		
		return panel;
	}
	
	private void setDefaultConfig() {
		setLayout(new BorderLayout(X_MARGIN, Y_MARGIN));
		setBackground(new Color(StoreMenuPanel.COLOR));
		
	}
	
	private void setComponents() {	
		JPanel title = StoreMenuTitlePanel.getInstance();
		add(title, BorderLayout.NORTH);
		
		JPanel btns = StoreMenuBtnPanel.getInstance();
		add(btns, BorderLayout.CENTER);
	}
	
}
