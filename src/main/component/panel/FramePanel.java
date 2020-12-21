package main.component.panel;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.Timer;

import main.controller.TimerActionListener;
import main.view.MainView;

/*
 	# 프레임에 붙이는 패널 (1번 패널)
 */
public class FramePanel extends JPanel {
	
	private static Map<FramePanelEnum, FramePanel> fpMap;
	
	static Timer timer;
	
	private static int WAITING_MILLI_SECS = 2600; 
	
	static {
		fpMap = new HashMap<>();
		
		timer = new Timer(WAITING_MILLI_SECS, new TimerActionListener(MainView.getMainFrame()));
		timer.start();
		
		for (FramePanelEnum fpe : FramePanelEnum.values()) {
			FramePanel fp = new FramePanel();
			fpMap.put(fpe, fp);
			
			try {
				Class.forName(fpe.classpath).getConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e) {
				e.printStackTrace();
			}
		
			
		}
	}
	
	private FramePanel() {
	}
	
	public static FramePanel getFramePanel(FramePanelEnum fp) {
		return fpMap.get(fp);
	}
	
	public static Timer getTimer() {
		return timer;
	}
}
