package employee.component.panel.menu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import common.font.SidePanelTitleLabelFont;
import employee.component.label.menu.EmpMenuTitleLabel;
import main.component.panel.SideUpPanel;

public class EmpMenuTitlePanel extends JPanel {
	
//	public static final int WIDTH = 0;
//	public static final int HEIGHT = 50;
	
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
//		emtp.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		emtp.setLayout(new FlowLayout(FlowLayout.CENTER));
		emtp.setBackground(new Color(EmpMenuPanel.COLOR));
	
		setComponents();
	}
	
	private static void setComponents() {
		JLabel title = new EmpMenuTitleLabel("Employee Management");
		emtp.add(title);
	}
	
	
}
