package main.component.panel.content;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.component.button.MenuBtnEnum;
import main.component.label.SidePanelTitleLabel;

public class SideUpPanel extends JPanel {

	static SideUpPanel sideUpPanel;
	static SidePanelTitleLabel title;
	
	public static final int PANEL_WIDTH = SidePanel.SIDEPANEL_WIDTH;
	public static final int PANEL_HEIGHT = 80;

//	public static final Color BG_COLOR = SidePanel.BG_COLOR;
	public static final Color BG_COLOR = new Color(0x663300);
	
	
	static {
		sideUpPanel = new SideUpPanel();
		
		
		
	}
	
	private SideUpPanel() {
		setDefaultConfig();
		setComponents();
	}

	private void setDefaultConfig() {
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setLayout(null);
		setBackground(BG_COLOR);
	}
	
	private void setComponents() {
		title = new SidePanelTitleLabel();
		add(title);	
		
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
