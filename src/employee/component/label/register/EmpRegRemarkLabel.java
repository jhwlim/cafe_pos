package employee.component.label.register;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

import employee.common.font.EmpRegRemarkFont;

public class EmpRegRemarkLabel extends JLabel {

	static final int WIDTH = 100;
	static final int HEIGHT = 15;
	
	public EmpRegRemarkLabel() {
		super.setFont(new EmpRegRemarkFont());
		super.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		super.setForeground(Color.gray);
	}
	
	
}
