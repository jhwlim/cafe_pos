package main.view;

import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import main.component.button.MenuBtn;
import main.component.button.MenuBtnEnum;
import main.component.panel.FramePanel;
import main.component.panel.FramePanelEnum;
import main.controller.btn.MenuBtnClickListener;

public class MenuView {
	
	public static FramePanel panel;
	
	static final int X_MARGIN = 450;
	static final int Y_MARGIN = 300;
	
	static final int GRID_ROW_NUM = 4;
	static final int GRID_COL_NUM = 1;
	static final int GRID_X_MARGIN = 50;
	static final int GRID_Y_MARGIN = 50;
	
	static {
		panel = FramePanel.getFramePanel(FramePanelEnum.MENU);
	}
	
	public MenuView() {
		
		panel.setLayout(new CardLayout(X_MARGIN, Y_MARGIN));
		
		JPanel subPanel = new JPanel();

		subPanel.setLayout(new GridLayout(GRID_ROW_NUM, 
										  GRID_COL_NUM, 
										  GRID_X_MARGIN, 
										  GRID_Y_MARGIN));

		for (MenuBtnEnum mbe : MenuBtnEnum.values()) {
			MenuBtn btn = new MenuBtn(mbe);
			btn.addActionListener(new MenuBtnClickListener(mbe));
			subPanel.add(btn);
		}
		
		panel.add(subPanel);
	}
}
