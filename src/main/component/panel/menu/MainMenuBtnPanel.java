package main.component.panel.menu;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.component.button.MenuBtn;
import main.component.button.MenuBtnEnum;
import main.controller.btn.MenuBtnClickListener;

public class MainMenuBtnPanel extends JPanel {
	
	private static final int COLOR_INT = 0xffffff;
	public static final Color COLOR = new Color(COLOR_INT);
	
	static final int GRID_ROW_NUM = 2;
	static final int GRID_COL_NUM = 3;
	static final int GRID_X_MARGIN = 10;
	static final int GRID_Y_MARGIN = 10;
	
	public MainMenuBtnPanel() {
		setDefaultConfig();
		setComponents();
	}
	
	private void setDefaultConfig() {
//		setBackground(COLOR);
		setLayout(new GridLayout(GRID_ROW_NUM, 
								 GRID_COL_NUM, 
								 GRID_X_MARGIN, 
								 GRID_Y_MARGIN));
	}
	
	private void setComponents() {
		
		for (MenuBtnEnum mbe : MenuBtnEnum.values()) {
			add(new MenuBtn(mbe));
		}
	
		for (int i = MenuBtnEnum.values().length; i < GRID_ROW_NUM * GRID_COL_NUM; i++) {
			add(new MenuBtn());
		}
	}
	
}
