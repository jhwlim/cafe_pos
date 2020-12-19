package main.view;

import java.awt.CardLayout;
import java.awt.Color;

import main.component.label.LoadingImgLabel;
import main.component.panel.FramePanel;
import main.component.panel.FramePanelEnum;

public class LoadingView {
	
	public static FramePanel panel;
	
	static {
		panel = FramePanel.getFramePanel(FramePanelEnum.LOADING);
	}
	
	public LoadingView() {
		panel.setBackground(Color.white);
		panel.setLayout(new CardLayout());

		panel.add(new LoadingImgLabel());
	}
}
