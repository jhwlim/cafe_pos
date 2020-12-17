package employee.component.panel.register;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class EmgRegLeftMarginPanel extends JPanel {
	
	private static final int WIDTH = 125;
	private static final int HEIGHT = 0;
	
	public EmgRegLeftMarginPanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(new Color(EmpRegCenterPanel.COLOR));
	}
	
	
}
