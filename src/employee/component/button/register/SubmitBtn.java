package employee.component.button.register;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import employee.common.font.EmpBtnFont;
import employee.controller.button.EmpRegBtnClickListener;

public class SubmitBtn extends JButton {
	
	public static final int WIDTH = 70;
	public static final int HEIGHT = 40;
	
	static final int COLOR = 0x5bc987;
	
	public SubmitBtn() {
		super("등록");
		super.setFont(new EmpBtnFont());
		super.setForeground(Color.white);
		super.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		super.setBackground(new Color(COLOR));
		
		super.addActionListener(new EmpRegBtnClickListener());
	}
	
}
