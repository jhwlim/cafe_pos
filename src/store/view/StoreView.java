package store.view;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

import main.component.button.MenuBtnEnum;
import main.component.panel.ContentPanel;
import store.component.panel.menu.StoreMenuPanel;

public class StoreView {
	
	private static JPanel panel;
	
	public static final String MENU_PAGE_NAME = "MENU";
	
	static {
		panel = ContentPanel.getPanel(MenuBtnEnum.STORE);
		panel.setLayout(new CardLayout());
		panel.setBackground(Color.white);
	}
	
	public StoreView() {
		
		panel.removeAll();
		
		StoreMenuPanel menuPanel = StoreMenuPanel.getInstance();
		panel.add(MENU_PAGE_NAME, menuPanel);
		
	}
	
	public static JPanel getContentPanel() {
		return panel;
	}
}
