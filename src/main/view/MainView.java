package main.view;

import java.awt.CardLayout;

import javax.swing.JFrame;

import main.component.frame.MainFrame;
import main.component.panel.FramePanel;
import main.component.panel.FramePanelEnum;
import main.controller.mouse.LogoMouseClickListener;

public class MainView {
	
	static MainFrame frame;
	
	static {
		frame = new MainFrame();
	}
	
	public MainView() {
		
		for (FramePanelEnum fpe : FramePanelEnum.values()) {
			FramePanel fp = FramePanel.getFramePanel(fpe);
			frame.add(fpe.toString(), fp);
			
			switch(fpe) {
			case LOGO : 
				fp.addMouseListener(new LogoMouseClickListener(frame));				
				break;
			case MENU :
				break;
			case CONTENT :
				break;
			}
			
		}
		
		frame.setVisible(true);
	}
	
	public static MainFrame getMainFrame() {
		return frame;
	}
}
