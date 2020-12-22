package main.view;

import javax.swing.JFrame;

import main.component.frame.MainFrame;
import main.component.panel.FramePanel;
import main.component.panel.FramePanelEnum;

public class MainView {
	
	static JFrame frame;
	
	static {
		frame = new MainFrame();
	}
	
	public MainView() {
		
		for (FramePanelEnum fpe : FramePanelEnum.values()) {
			FramePanel fp = FramePanel.getFramePanel(fpe);
			frame.add(fpe.toString(), fp);			
		}
		
		frame.setVisible(true);
	}
	
	public static JFrame getMainFrame() {
		return frame;
	}
	
	
}
