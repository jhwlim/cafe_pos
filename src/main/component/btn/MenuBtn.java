package main.component.btn;

import javax.swing.JButton;

public class MenuBtn extends JButton {
	
	public MenuBtn(MenuBtnEnum mbe) {
		super(mbe.btnName);
	}
}
