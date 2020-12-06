package main.component.panel;

import java.awt.CardLayout;
import java.awt.Color;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

/*
 	# 프레임에 붙이는 패널 (1번 패널)
 */
public class FramePanel extends JPanel {
	
	private static Map<FramePanelEnum, FramePanel> fpMap;
	
	static {
		fpMap = new HashMap<>();
		
		for (FramePanelEnum fpe : FramePanelEnum.values()) {
			FramePanel fp = new FramePanel();
			fpMap.put(fpe, fp);
		
			try {
				Class.forName(fpe.classpath).getConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
						
		}
	}
	
	private FramePanel() {
	}
	
	public static FramePanel getFramePanel(FramePanelEnum fp) {
		return fpMap.get(fp);
	}
	
}
