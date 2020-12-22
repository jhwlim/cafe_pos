package main.component.panel.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.component.button.MenuBtnEnum;
import main.controller.btn.MainBtnClickListener;

public class SidePanel extends JPanel {
	
	private static SidePanel sidePanel;
	private static SideMenuPanel sideMenuPanel;
	private static SideDownPanel sideDownPanel;
	private static SideUpPanel sideUpPanel;
	
	public static final int SIDEPANEL_WIDTH = 300;
	public static final int SIDEPANEL_HEIGHT = 0;
	
	public static final Color BG_COLOR = new Color(0x186f3d);
	
	static {
		sidePanel = new SidePanel();
		
		// 사이드 패널 설정
		sidePanel.setLayout(new BorderLayout(0, 0));
		sidePanel.setPreferredSize(new Dimension(SIDEPANEL_WIDTH, SIDEPANEL_HEIGHT));
		
		// 사이드 패널 구성
		sideMenuPanel = SideMenuPanel.getInstance();
		sidePanel.add(sideMenuPanel, BorderLayout.CENTER);
		
		sideDownPanel = SideDownPanel.getInstance();
		sidePanel.add(sideDownPanel, BorderLayout.SOUTH);
		
		sideUpPanel = SideUpPanel.getInstance();
		sidePanel.add(sideUpPanel, BorderLayout.NORTH);
	}
	
	private SidePanel() {
	}
	
	public static SidePanel getInstance(MenuBtnEnum mbe) {
		if (sidePanel == null) {
			sidePanel = new SidePanel();
		}
		
		sideUpPanel.setTitle(mbe);
		
		return sidePanel;
	}
			
}
