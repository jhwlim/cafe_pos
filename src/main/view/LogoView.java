package main.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;

import main.component.label.LogoLabel;
import main.component.panel.FramePanel;
import main.component.panel.FramePanelEnum;

public class LogoView {
	
	public static FramePanel panel;
	
	static {
		panel = FramePanel.getFramePanel(FramePanelEnum.LOGO);
	}
	
	public LogoView() {
		panel.setBackground(Color.black);
		panel.setLayout(new BorderLayout());
		
		JLabel logoLabel = new LogoLabel();

		panel.add(logoLabel);
	}
}
