package main.controller;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import main.component.panel.FramePanel;

public class TimerActionListener implements ActionListener {

	Container cardPanel;
	String cardName;
	int count = 0;
	
	public TimerActionListener(Container frame) {
		this.cardPanel = ((JFrame) frame).getContentPane();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (count < 2) {
			((CardLayout) cardPanel.getLayout()).next(cardPanel);			
		} else {
			FramePanel.getTimer().stop();			
		}
		count++;
	}
	
}
