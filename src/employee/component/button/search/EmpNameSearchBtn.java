package employee.component.button.search;

import java.awt.Dimension;

import javax.swing.JButton;

import employee.controller.button.search.EmpSearchBtnClickListener;

public class EmpNameSearchBtn extends JButton {
	
	public EmpNameSearchBtn() {
		super("검색");
		setPreferredSize(new Dimension(60, 25));
	
		addActionListener(new EmpSearchBtnClickListener());
	}
	
	
}
