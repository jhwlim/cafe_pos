package employee.component.button.info;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import employee.common.font.EmpBtnFont;
import employee.controller.button.info.EmpInfoDropBtnClickListener;
import employee.controller.button.register.EmpRegSubmitBtnClickListener;

public class DropBtn extends JButton {

	public static final int WIDTH = 70;
	public static final int HEIGHT = 40;
	
	static final int COLOR = 0xcc5252;
	
	public DropBtn() {
		super("삭제");
		super.setFont(new EmpBtnFont());
		super.setForeground(Color.white);
		super.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		super.setBackground(new Color(COLOR));
		
		super.addActionListener(new EmpInfoDropBtnClickListener());
	}
}
