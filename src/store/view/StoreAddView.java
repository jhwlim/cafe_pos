package store.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;

import employee.component.button.menu.EmpMenuBtnEnum;
import employee.component.panel.content.EmpContentPanel;
import employee.component.panel.register.EmpRegCenterPanel;
import employee.view.EmployeeView;
import store.component.button.menu.StoreMenuBtnEnum;
import store.component.panel.add.center.StoreAddCenterPanel;
import store.component.panel.content.StoreContentPanel;

public class StoreAddView {
	
	public static StoreContentPanel panel;
	public static Container parentPanel;
	
	public static final int X_MARGIN = 200;
	public static final int Y_MARGIN = 190;
	
	static StoreMenuBtnEnum smb;
	
	static {
		parentPanel = StoreView.getContentPanel();
		smb = StoreMenuBtnEnum.ADD;
	}
	
	public StoreAddView() {
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
		StoreAddCenterPanel centerPanel = new StoreAddCenterPanel();
		panel.add(centerPanel);
	}
}
