package main.component.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.component.btn.SidePanelBtn;
import main.controller.btn.MainBtnClickListener;

public class SideDownPanel extends JPanel {
	
	static SideDownPanel sideDownPanel;
	
	public static final int PANEL_WIDTH = SidePanel.SIDEPANEL_WIDTH;
	public static final int PANEL_HEIGHT = 80;

	
	static {
		sideDownPanel = new SideDownPanel();
		
		sideDownPanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		sideDownPanel.setLayout(null);
	}
	
	private SideDownPanel() {
		
	}

	public static SideDownPanel getInstance() {
		if (sideDownPanel == null) {
			sideDownPanel = new SideDownPanel();
		}
		
		setComponents();
		
		return sideDownPanel;
	}

	private static void setComponents() {
		
		JButton mainBtn = new SidePanelBtn("뒤로가기");
		mainBtn.addActionListener(new MainBtnClickListener());
		
		sideDownPanel.add(mainBtn);
		
	}
	
}
