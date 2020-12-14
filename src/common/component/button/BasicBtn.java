package common.component.button;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import common.font.BasicBtnFont;
import employee.common.font.EmpBtnFont;
import employee.controller.button.register.EmpRegSubmitBtnClickListener;

public class BasicBtn extends JButton {
	
	public static final int WIDTH = 70;
	public static final int HEIGHT = 40;
	
	public BasicBtn() {
		setFont(new BasicBtnFont());
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}
	
}
