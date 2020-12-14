package store.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;

import store.component.button.menu.StoreMenuBtnEnum;
import store.component.panel.content.StoreContentPanel;
import store.component.panel.save.StoreSaveCenterPanel;

public class StoreSaveView {

	public static StoreContentPanel panel;
	public static Container parentPanel;
	
	public static final int X_MARGIN = 150;
	public static final int Y_MARGIN = 120;
	
	static StoreMenuBtnEnum smb;
	
	static {
		parentPanel = StoreView.getContentPanel();
		smb = StoreMenuBtnEnum.REGISTER;
	}
	
	public StoreSaveView() {
		panel = new StoreContentPanel(smb);
		parentPanel.add(smb.pageName, panel);
		
		setDefaultConfig();
		setComponents();
	}
	
	private static void setDefaultConfig() {
		panel.setLayout(new CardLayout(X_MARGIN, Y_MARGIN));
		panel.setBackground(Color.white);
	
	}
	
	private static void setComponents() {
		
		StoreSaveCenterPanel centerPanel = new StoreSaveCenterPanel();
		panel.add(centerPanel);
		
	}
}
