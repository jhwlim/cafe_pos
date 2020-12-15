package main.component.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.component.button.MenuBtn;
import main.component.button.MenuBtnEnum;
import main.component.button.SidePanelBtn;
import main.controller.btn.MenuBtnClickListener;

public class SideMenuPanel extends JPanel {

	private static SideMenuPanel sideMenuPanel;
	
	static final int GRID_ROW_NUM = 10;
	static final int GRID_COL_NUM = 1;
	
	static {
		sideMenuPanel = new SideMenuPanel();
		
		sideMenuPanel.setBackground(Color.white);
//		sideMenuPanel.setLayout(new GridLayout(GRID_ROW_NUM, GRID_COL_NUM));
		sideMenuPanel.setLayout(new FlowLayout());
//		sideMenuPanel.setLayout(null);
//		sideMenuPanel.setLayout(new BorderLayout());
		// 사이드 메뉴 패널에 버튼 추가
		setComponents();
	}
	
	private SideMenuPanel() {
	}
	
	public static SideMenuPanel getInstance() {
		if (sideMenuPanel == null) {
			sideMenuPanel = new SideMenuPanel();
		}
		
		return sideMenuPanel;
	}
	
	// 사이드 메뉴 패널에 컴포넌트 추가하기
	public static void setComponents() {
		
		// 메뉴 버튼
		for (MenuBtnEnum mbe : MenuBtnEnum.values()) {
			JPanel panel = new JPanel();
			panel.setLayout(null);
			SidePanelBtn btn = new SidePanelBtn(mbe.btnName);
			btn.addActionListener(new MenuBtnClickListener(mbe));
			
			panel.add(btn);
			panel.setPreferredSize(new Dimension(SideDownPanel.PANEL_WIDTH, (int) (SideDownPanel.PANEL_HEIGHT)));
			panel.setBackground(Color.white);
			sideMenuPanel.add(panel);
			
			
//			sideMenuPanel.add(new SidePanelBtn(mbe.btnName));
		}
		
	}
}
