package employee.component.panel.menu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;

import common.component.label.LogoLabel;
import common.font.SidePanelTitleLabelFont;
import employee.component.label.menu.EmpMenuTitleLabel;
import main.component.panel.content.SideUpPanel;

public class EmpMenuTitlePanel extends JPanel {
	
	public static final Color BG_COLOR = new Color(0xffffff);
	
	private static EmpMenuTitlePanel emtp; 
	
	static {
		emtp = new EmpMenuTitlePanel();
		setDefaultConfig();
	}
	
	private EmpMenuTitlePanel() {
	}
	
	public static EmpMenuTitlePanel getInstance() {
		if (emtp == null) {
			emtp = new EmpMenuTitlePanel();
			setDefaultConfig();
		}
		
		return emtp;
	}
	
	private static void setDefaultConfig() {
		emtp.setLayout(new FlowLayout(FlowLayout.CENTER));
		emtp.setBackground(BG_COLOR);
	
		setComponents();
	}
	
	private static void setComponents() {
		try {
			JLabel title = new LogoLabel();
			emtp.add(title);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
