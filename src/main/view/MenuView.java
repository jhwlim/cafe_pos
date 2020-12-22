package main.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import main.component.button.MenuBtn;
import main.component.button.MenuBtnEnum;
import main.component.panel.FramePanel;
import main.component.panel.FramePanelEnum;
import main.component.panel.menu.MainMenuBtnPanel;
import main.component.panel.menu.MainMenuTopPanel;
import main.component.panel.menu.side.MainMenuSidePanel;
import main.controller.btn.MenuBtnClickListener;

public class MenuView {
	
//	private static final int COLOR_INT = 0x40444a;
	private static final int COLOR_INT = 0xffffff;
	public static final Color COLOR = new Color(COLOR_INT);
	
	public static FramePanel panel;
	
	static final int MARGIN = 0;
	
	static {
		panel = FramePanel.getFramePanel(FramePanelEnum.MENU);
		panel.setLayout(new BorderLayout(MARGIN, MARGIN));
		panel.setBackground(COLOR);
	}
	
	public MenuView() {
		MainMenuTopPanel topPanel = new MainMenuTopPanel();
		panel.add(topPanel, BorderLayout.NORTH);// 웰컴 카페 그림 (탑)
		
		JPanel centerPanel = new JPanel(new CardLayout(MARGIN, MARGIN));// 센터 전체적인 
		panel.add(centerPanel, BorderLayout.CENTER);
		
		JPanel subPanel = new JPanel(new BorderLayout(MARGIN, MARGIN));
		centerPanel.add(subPanel);
		
		MainMenuBtnPanel btnPanel = new MainMenuBtnPanel();//버튼 5개있는 패널
		subPanel.add(btnPanel, BorderLayout.CENTER);
		
//		MainMenuSidePanel sidePanel = new MainMenuSidePanel();
//		subPanel.add(sidePanel, BorderLayout.EAST);
	}
}
