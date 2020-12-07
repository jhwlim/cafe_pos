package main.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import main.component.btn.MenuBtnEnum;
import main.component.panel.ContentPanel;
import main.component.panel.FramePanel;
import main.component.panel.FramePanelEnum;
import main.component.panel.SidePanel;

public class ContentView {
	
	public static FramePanel panel;
	
	private static final int X_MARGIN = 10;
	private static final int Y_MARGIN = 0;
	
	
	static {
		panel = FramePanel.getFramePanel(FramePanelEnum.CONTENT);
		panel.setLayout(new BorderLayout(X_MARGIN, Y_MARGIN));
	
	}
	
	public ContentView() {
	}
	
	public ContentView(MenuBtnEnum mbe) {
		
		JPanel contentPanel = ContentPanel.getInstance();
		panel.add(contentPanel, BorderLayout.CENTER);
	
		JPanel sidePanel = SidePanel.getInstance(mbe);
		panel.add(sidePanel, BorderLayout.EAST);
	}
	
	
}
