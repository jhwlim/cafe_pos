package main.view;

import java.awt.CardLayout;
import java.awt.Color;

import main.component.label.LogoLabel;
import main.component.panel.FramePanel;
import main.component.panel.FramePanelEnum;

public class LogoView {
	
	public static FramePanel panel;
	
	static {
		panel = FramePanel.getFramePanel(FramePanelEnum.LOGO);
	}
	
	public LogoView() {
		panel.setBackground(Color.white);
		panel.setLayout(new CardLayout(100, 100));
	
		panel.add(new LogoLabel());
	}
}
