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
	
	public static FramePanel panel;
	
	static final int MARGIN = 10;
	
	static {
		panel = FramePanel.getFramePanel(FramePanelEnum.MENU);
		panel.setLayout(new BorderLayout(MARGIN, MARGIN));
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
