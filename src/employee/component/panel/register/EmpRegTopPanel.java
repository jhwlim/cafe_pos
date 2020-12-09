package employee.component.panel.register;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class EmpRegTopPanel extends JPanel {
	
	private static EmpRegTopPanel panel;
	
	public static final int WIDTH = 0;
	public static final int HEIGHT = 100;
	
	static {
		panel = new EmpRegTopPanel();
	}
	
	private EmpRegTopPanel() {
		setDefaultConfig();
	}
	
	private void setDefaultConfig() {
		setBackground(Color.black);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		setComponents();
	}
	
	private void setComponents() {
		
	}
	
	public static EmpRegTopPanel getInstance() {
		if (panel == null) {
			panel = new EmpRegTopPanel();
		}
		return panel;
	}
}
