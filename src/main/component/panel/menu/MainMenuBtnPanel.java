package main.component.panel.menu;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import common.component.button.RoundedBorder;
import main.component.button.MenuBtn;
import main.component.button.MenuBtnEnum;
import main.controller.btn.MenuBtnClickListener;
import main.view.MenuView;

public class MainMenuBtnPanel extends JPanel {
	
	public static final Color COLOR = MenuView.COLOR;
	
	static final int GRID_ROW_NUM = 2;
	static final int GRID_COL_NUM = 3;
	static final int GRID_X_MARGIN = 0;
	static final int GRID_Y_MARGIN = 0;
	
	public MainMenuBtnPanel() {
		setDefaultConfig();
		setComponents();
	}
	
	private void setDefaultConfig() {
		setBackground(COLOR);
		setLayout(new GridLayout(GRID_ROW_NUM, 
								 GRID_COL_NUM, 
								 GRID_X_MARGIN, 
								 GRID_Y_MARGIN));
	}
	
	private void setComponents() {
		for (int i = 0; i < GRID_ROW_NUM * GRID_COL_NUM; i++) {
			JButton btn;
			if (i < MenuBtnEnum.values().length) {
				btn = new MenuBtn(MenuBtnEnum.values()[i]);
			} else {
				btn = new MenuBtn();
			}
			btn.setForeground(new Color(0xFFFFFF));// 버튼 폰트
			btn.setBackground(new Color(0x663300));// 버튼 배경
			btn.setBorder(BorderFactory.createLineBorder(new Color(0x663300)));
			
			
			JPanel gridInPanel = new JPanel(new CardLayout(50, 50));
			gridInPanel.setBackground(new Color(0x006600));// 밑 배경
			gridInPanel.add(btn);
			this.add(gridInPanel);
		}
			
	}
	
}
