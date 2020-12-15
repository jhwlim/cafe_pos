package store.component.button.add;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import common.component.button.BasicBtn;
import employee.common.font.EmpBtnFont;
import employee.controller.button.register.EmpRegSubmitBtnClickListener;
import store.controller.button.add.StoreAddCancelBtnClickListener;
import store.controller.button.add.StoreAddSubmitBtnClickListener;

public class SubmitBtn extends BasicBtn {
	
	static final int COLOR = 0x5bc987;
	
	public SubmitBtn() {
		setText("등록");
		super.setForeground(Color.white);
		super.setBackground(new Color(COLOR));
		
		super.addActionListener(new StoreAddSubmitBtnClickListener());
	}
	
}
