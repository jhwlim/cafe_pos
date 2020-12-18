package employee.component.button.info;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import employee.common.font.EmpBtnFont;
import employee.controller.button.info.EmpInfoGoModBtnClickListener;
import employee.controller.button.info.EmpInfoUpdateBtnClickListener;

public class UpdateBtn extends JButton {
	
	public static final int WIDTH = 70;
	public static final int HEIGHT = 40;
	
	static final int COLOR = 0x5bc987;
	
	public UpdateBtn() {
		super("수정");
		setFont(new EmpBtnFont());
		setForeground(Color.white);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(new Color(COLOR));
		
		addActionListener(new EmpInfoUpdateBtnClickListener());
	}
}
