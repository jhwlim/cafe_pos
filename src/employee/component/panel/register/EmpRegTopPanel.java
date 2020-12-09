package employee.component.panel.register;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JPanel;

import employee.component.label.register.EmpRegIUsermgLabel;

public class EmpRegTopPanel extends JPanel {
	
	private static EmpRegTopPanel panel;
	
	public static final int WIDTH = 0;
	public static final int HEIGHT = 250;
	
	static {
		panel = new EmpRegTopPanel();
	}
	
	private EmpRegTopPanel() {
		setDefaultConfig();
	}
	
	private void setDefaultConfig() {
		setBackground(new Color(EmpRegCenterPanel.COLOR));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(new CardLayout());
		
		setComponents();
	}
	
	private void setComponents() {
		try {
			this.add(new EmpRegIUsermgLabel());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static EmpRegTopPanel getInstance() {
		if (panel == null) {
			panel = new EmpRegTopPanel();
		}
		return panel;
	}
}
