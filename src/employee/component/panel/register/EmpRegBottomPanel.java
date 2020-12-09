package employee.component.panel.register;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class EmpRegBottomPanel extends JPanel {
	
	private static EmpRegBottomPanel panel;
	
	public static final int WIDTH = 0;
	public static final int HEIGHT = 200;
	
	static {
		panel = new EmpRegBottomPanel();
	}
	
	private EmpRegBottomPanel() {
		setDefaultConfig();
	}
	
	private void setDefaultConfig() {
		setBackground(Color.black);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		setComponents();
	}
	
	private void setComponents() {
		
	}
	
	public static EmpRegBottomPanel getInstance() {
		if (panel == null) {
			panel = new EmpRegBottomPanel();
		}
		return panel;
	}
}
