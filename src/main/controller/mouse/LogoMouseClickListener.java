package main.controller.mouse;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import main.component.panel.FramePanelEnum;

/*
 	# 
 */
public class LogoMouseClickListener extends MouseAdapter {
	
	Container cardPanel;
	String cardName;

	public LogoMouseClickListener(Container frame) {
		this.cardPanel = ((JFrame) frame).getContentPane();
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 1) {
			((CardLayout) cardPanel.getLayout()).next(cardPanel);
		}
		
	}
}
