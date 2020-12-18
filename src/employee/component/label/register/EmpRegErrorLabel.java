package employee.component.label.register;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

import employee.common.font.EmpRegErrorFont;
import employee.common.font.EmpRegRemarkFont;

public class EmpRegErrorLabel extends JLabel {
	
	
	public EmpRegErrorLabel() {
		super.setFont(new EmpRegErrorFont());
		super.setForeground(Color.red);
	}
}
