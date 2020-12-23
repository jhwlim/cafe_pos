package store.component.panel.menu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.component.panel.content.SideUpPanel;

public class StoreMenuCenterPanel extends JPanel {

	static final Color BG_COLOR = new Color(0xffffff);

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
		setLayout(new CardLayout(70, 50));
		setBackground(BG_COLOR);
		
	}
	
	private void setComponents() {	
		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new BorderLayout(X_MARGIN, Y_MARGIN));
		innerPanel.setBackground(BG_COLOR);
		
		add(innerPanel);
		
		JPanel title = StoreMenuTitlePanel.getInstance();
		innerPanel.add(title, BorderLayout.NORTH);
		
		JPanel btns = StoreMenuBtnPanel.getInstance();
		innerPanel.add(btns, BorderLayout.CENTER);
	}
	
}
