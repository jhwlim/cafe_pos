package employee.component.panel.menu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.component.panel.SideUpPanel;

public class EmpMenuCenterPanel extends JPanel {
	
//	public static final int WIDTH = 0;
//	public static final int HEIGHT = SideUpPanel.PANEL_HEIGHT;
	
	static final int X_MARGIN = 0;
	static final int Y_MARGIN = 20;
	
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
		panel.setLayout(new BorderLayout(X_MARGIN, Y_MARGIN));
		panel.setBackground(new Color(EmpMenuPanel.COLOR));
		setComponents();
	}
	
	private static void setComponents() {	
		JPanel emtp = EmpMenuTitlePanel.getInstance();
		panel.add(emtp, BorderLayout.NORTH);
		
		JPanel embp = EmpMenuBtnPanel.getInstance();
		panel.add(embp, BorderLayout.CENTER);
	}
	
}
