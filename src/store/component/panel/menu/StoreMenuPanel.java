package store.component.panel.menu;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class StoreMenuPanel extends JPanel {
	
	private static StoreMenuPanel panel;
	
	public static final int COLOR = 0xffffff;
	
	private static final int X_MARGIN = 300;
	private static final int Y_MARGIN = 280;
	
	static {
		panel = new StoreMenuPanel();	
	}
	
	private StoreMenuPanel() {
		setDefaultConfig();
		setComponents();
	}
	
	
	public static StoreMenuPanel getInstance() {
		if (panel == null) {
			panel = new StoreMenuPanel();
		}
		
		return panel;
	}
	
	private void setDefaultConfig() {
		setLayout(new CardLayout(X_MARGIN, Y_MARGIN));
		setBackground(new Color(COLOR));
	}
	
	private void setComponents() {
		StoreMenuCenterPanel center = StoreMenuCenterPanel.getInstance();
		add(center);
	}
}
