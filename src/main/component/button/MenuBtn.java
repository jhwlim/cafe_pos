package main.component.button;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import common.font.MenuBtnFont;
import main.controller.btn.MenuBtnClickListener;

public class MenuBtn extends JButton {
	
	public MenuBtn() {
		setBackground(Color.white);
		setBorder(BorderFactory.createEmptyBorder());
	}
	
	public MenuBtn(MenuBtnEnum mbe) {
		super(mbe.btnName);
		
//		setBackground(Color.white);
		setFont(new Font("맑은 고딕", Font.BOLD, 30));
		setBorder(BorderFactory.createEmptyBorder());
		
		addActionListener(new MenuBtnClickListener(mbe));
	}
	
	
	
}
