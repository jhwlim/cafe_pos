package stock.component;

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

public class StockMenuTitlePanel extends JPanel {
	
	public static final Color BG_COLOR = new Color(0xffffff);
	
	private static StockMenuTitlePanel emtp; 
	
	static {
		emtp = new StockMenuTitlePanel();
	}
	
	public StockMenuTitlePanel() {
		setDefaultConfig();
		setComponents();
	}
	
	public static StockMenuTitlePanel getInstance() {
		if (emtp == null) {
			emtp = new StockMenuTitlePanel();
		}
		
		return emtp;
	}
	
	private void setDefaultConfig() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setBackground(BG_COLOR);		
	}
	
	private void setComponents() {
		try {
			JLabel title = new LogoLabel();
			add(title);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
