package main.component.panel.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.component.button.MenuBtn;
import main.component.button.MenuBtnEnum;
import main.component.button.SidePanelBtn;
import main.component.label.SidePanelTitleLabel;
import main.controller.btn.MenuBtnClickListener;

public class SideMenuPanel extends JPanel {

	private static SideMenuPanel sideMenuPanel;
	
	static final int GRID_ROW_NUM = 10;
	static final int GRID_COL_NUM = 1;
	
	public static final Color BG_COLOR = SidePanel.BG_COLOR;
	
	static {
		sideMenuPanel = new SideMenuPanel();
		
		sideMenuPanel.setBackground(BG_COLOR);
		sideMenuPanel.setLayout(new FlowLayout());

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
		
		try {
			ImageIcon imgIcon = new ImageIcon(ImageIO.read(new File("resources/img/design/main/starbucks_side.png")).getScaledInstance(SideUpPanel.PANEL_WIDTH, SideUpPanel.PANEL_WIDTH, Image.SCALE_SMOOTH));
			JLabel logo = new JLabel(imgIcon);
			logo.setPreferredSize(new Dimension(SideUpPanel.PANEL_WIDTH, SideUpPanel.PANEL_WIDTH));
			sideMenuPanel.add(logo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 메뉴 버튼
		for (MenuBtnEnum mbe : MenuBtnEnum.values()) {
			JPanel panel = new JPanel();
			panel.setLayout(null);
			SidePanelBtn btn = new SidePanelBtn(mbe.btnName);
			btn.addActionListener(new MenuBtnClickListener(mbe));
			
			panel.add(btn);
			panel.setPreferredSize(new Dimension(SideDownPanel.PANEL_WIDTH, (int) (SideDownPanel.PANEL_HEIGHT)));
			panel.setBackground(BG_COLOR);
			sideMenuPanel.add(panel);
			
		}
		
	}
}
