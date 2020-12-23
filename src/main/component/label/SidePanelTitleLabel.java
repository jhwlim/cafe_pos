package main.component.label;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import common.font.SidePanelTitleLabelFont;
import main.component.button.MenuBtnEnum;
import main.component.panel.content.SideUpPanel;

public class SidePanelTitleLabel extends JLabel {
	
	static final int PANEL_WIDTH = SideUpPanel.PANEL_WIDTH;
	static final int PANEL_HEIGHT = SideUpPanel.PANEL_HEIGHT;
	
	public static final int LABLE_WIDTH = (int) (PANEL_WIDTH * 0.8);
	public static final int LABLE_HEIGHT = (int) (PANEL_HEIGHT * 0.8);
	public static final int LABLE_X_LOCATION = (PANEL_WIDTH - LABLE_WIDTH) / 2;
	public static final int LABLE_Y_LOCATION = (PANEL_HEIGHT - LABLE_HEIGHT) / 2;
	
	static final String FONT_TYPE = "궁서";
	static final int FONT_STYLE = Font.BOLD;
	static final int FONT_SIZE = 40;
	
	public SidePanelTitleLabel() {
		super("", SwingConstants.CENTER);
		setLocation(LABLE_X_LOCATION, LABLE_Y_LOCATION);
		setBounds(LABLE_X_LOCATION, LABLE_Y_LOCATION, LABLE_WIDTH, LABLE_HEIGHT);
		setFont(new SidePanelTitleLabelFont()); 
		setForeground(Color.white);
	}
	
	public SidePanelTitleLabel(MenuBtnEnum mbe) {
		super(mbe.btnName, SwingConstants.CENTER);
		super.setLocation(LABLE_X_LOCATION, LABLE_Y_LOCATION);
		super.setBounds(LABLE_X_LOCATION, LABLE_Y_LOCATION, LABLE_WIDTH, LABLE_HEIGHT);
		
		super.setFont(new SidePanelTitleLabelFont()); 
	}
}
