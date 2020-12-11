package employee.component.button.info;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import employee.common.font.EmpBtnFont;
import employee.controller.button.info.EmpInfoCancelBtnClickListener;

public class CancelBtn extends JButton {
	
	public static final int WIDTH = 70;
	public static final int HEIGHT = 40;
	
	static final int COLOR = 0xcc5252;
	
	public CancelBtn() {
		super("취소");
		setFont(new EmpBtnFont());
		setForeground(Color.white);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(new Color(COLOR));
		
		super.addActionListener(new EmpInfoCancelBtnClickListener());
	}
}
