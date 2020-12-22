package main.component.panel.content;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import main.component.button.MenuBtnEnum;

public class ContentPanel extends JPanel {

	private static Map<MenuBtnEnum, JPanel> cpMap;
	private static ContentPanel panel;
	
	
	static {
		panel = new ContentPanel();
		panel.setBackground(new Color(0x006600));
		
		panel.setLayout(new CardLayout());
		
		cpMap = new HashMap<>();
		
		for (MenuBtnEnum mbe : MenuBtnEnum.values()) {
			
			JPanel fp = new JPanel();
			
			cpMap.put(mbe, fp);
			
			panel.add(mbe.toString(), fp);
			
		}
		
	}
	
	private ContentPanel() {
	}
	
	public static ContentPanel getInstance() {
		if (panel == null) {
			panel = new ContentPanel();
		}
		return panel;
	}
	
	public static JPanel getPanel(MenuBtnEnum mbe) {
		return cpMap.get(mbe);
	}
	
	
}
