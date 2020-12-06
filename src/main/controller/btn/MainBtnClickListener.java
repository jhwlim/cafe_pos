package main.controller.btn;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import main.component.panel.FramePanelEnum;
import main.view.MainView;

public class MainBtnClickListener implements ActionListener {

	Container cardPanel;
	
	public MainBtnClickListener() {
		this.cardPanel = MainView.getMainFrame().getContentPane();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		((CardLayout) cardPanel.getLayout()).show(cardPanel, FramePanelEnum.MENU.toString());;
	}
	
}
