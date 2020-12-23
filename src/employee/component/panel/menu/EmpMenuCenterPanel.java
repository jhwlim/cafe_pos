package employee.component.panel.menu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.component.panel.content.SideUpPanel;

public class EmpMenuCenterPanel extends JPanel {
		
	static final int X_MARGIN = 0;
	static final int Y_MARGIN = 20;
	
	static final Color BG_COLOR = new Color(0xffffff);
	
	private static EmpMenuCenterPanel panel; 
	
	static {
		panel = new EmpMenuCenterPanel();
		setDefaultConfig();
	}
	
	private EmpMenuCenterPanel() {
	}
	
	public static EmpMenuCenterPanel getInstance() {
		if (panel == null) {
			panel = new EmpMenuCenterPanel();
			setDefaultConfig();
		}
		
		return panel;
	}
	
	private static void setDefaultConfig() {
		panel.setLayout(new CardLayout(70, 50));
		panel.setBackground(BG_COLOR);
		setComponents();
	}
	
	private static void setComponents() {	
		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new BorderLayout(X_MARGIN, Y_MARGIN));
		innerPanel.setBackground(BG_COLOR);
		
		panel.add(innerPanel);
		
		JPanel emtp = EmpMenuTitlePanel.getInstance();
		innerPanel.add(emtp, BorderLayout.NORTH);
		
		JPanel embp = EmpMenuBtnPanel.getInstance();
		innerPanel.add(embp, BorderLayout.CENTER);
	}
	
}
