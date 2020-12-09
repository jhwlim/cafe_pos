package employee.component.button.register;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import employee.common.font.EmpBtnFont;

public class CancelBtn extends JButton {
	
	public static final int WIDTH = 70;
	public static final int HEIGHT = 40;
	
	static final int COLOR = 0xcc5252;
	
	public CancelBtn() {
		super("취소");
		super.setFont(new EmpBtnFont());
		super.setForeground(Color.white);
		super.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		super.setBackground(new Color(COLOR));
	}
	
}
