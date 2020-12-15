package store.component.panel.menu;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;


import javax.swing.JButton;
import javax.swing.JPanel;

import employee.component.button.menu.EmpMenuBtn;
import employee.component.button.menu.EmpMenuBtnEnum;
import store.component.button.menu.StoreMenuBtn;
import store.component.button.menu.StoreMenuBtnEnum;

public class StoreMenuBtnPanel extends JPanel {

	private static StoreMenuBtnPanel panel; 
	
	private static final int X_MARGIN = 50;
	private static final int Y_MARGIN = 50;
	
	private static final int GRID_ROW = 2;
	private static final int GRID_COL = 2;
	
	static {
		panel = new StoreMenuBtnPanel();
		
	}
	
	private StoreMenuBtnPanel() {
		setDefaultConfig();
		setComponents();
	}
	
	public static StoreMenuBtnPanel getInstance() {
		if (panel == null) {
			panel = new StoreMenuBtnPanel();
		}
		
		return panel;
	}
	
	private void setDefaultConfig() {
		setLayout(new GridLayout(GRID_ROW, GRID_COL, X_MARGIN, Y_MARGIN));
		setBackground(new Color(StoreMenuPanel.COLOR));
	}
	
	private void setComponents() {
		
		int count = 0;
		
		for (StoreMenuBtnEnum smb : StoreMenuBtnEnum.values()) {
			try {
				JButton button = new StoreMenuBtn(smb);
				add(button);
			} catch (IOException e) {
				e.printStackTrace();
			}
			count++;
		}
		
		for (int i = count; i < GRID_ROW * GRID_COL; i++) {
			add(new StoreMenuBtn());
		}
		
		
	}
	
	
	
}
