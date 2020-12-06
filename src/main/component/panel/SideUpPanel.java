package main.component.panel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.component.btn.MenuBtnEnum;
import main.component.label.SidePanelTitleLabel;

public class SideUpPanel extends JPanel {

	static SideUpPanel sideUpPanel;
	static SidePanelTitleLabel title;
	
	public static final int PANEL_WIDTH = SidePanel.SIDEPANEL_WIDTH;
	public static final int PANEL_HEIGHT = 80;

	
	
	static {
		sideUpPanel = new SideUpPanel();
		
		sideUpPanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		sideUpPanel.setLayout(null);
		
		// 라벨 추가
		title = new SidePanelTitleLabel();
		sideUpPanel.add(title);
		
	}
	
	private SideUpPanel() {
		
	}

	public static SideUpPanel getInstance() {
		if (sideUpPanel == null) {
			sideUpPanel = new SideUpPanel();
		}
		
		return sideUpPanel;
	}
	
	
	public void setTitle(MenuBtnEnum mbe) {
		title.setText(mbe.btnName);
	}
}
