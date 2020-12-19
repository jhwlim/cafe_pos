package main.view;

import main.component.frame.MainFrame;
import main.component.panel.FramePanel;
import main.component.panel.FramePanelEnum;

public class MainView {
	
	static MainFrame frame;
	
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
	
	public static MainFrame getMainFrame() {
		return frame;
	}
	
	
}
