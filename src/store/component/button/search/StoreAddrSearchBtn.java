package store.component.button.search;

import java.awt.Dimension;

import javax.swing.JButton;

import employee.controller.button.search.EmpSearchBtnClickListener;
import store.controller.button.search.StoreSearchBtnClickListener;

public class StoreAddrSearchBtn extends JButton {
	
	public StoreAddrSearchBtn() {
		super("검색");
		setPreferredSize(new Dimension(60, 25));
	
		addActionListener(new StoreSearchBtnClickListener());
	}
	
	
}
