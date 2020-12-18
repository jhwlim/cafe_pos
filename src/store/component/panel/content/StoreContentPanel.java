package store.component.panel.content;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import employee.component.button.menu.EmpMenuBtnEnum;
import store.component.button.menu.StoreMenuBtnEnum;

public class StoreContentPanel extends JPanel {

	private static Map<StoreMenuBtnEnum, StoreContentPanel> panelMap;
	
	static {
		panelMap = new HashMap<>();	
	}
	
	public StoreContentPanel(StoreMenuBtnEnum smb) {
		panelMap.put(smb, this);
	}
	
	public static StoreContentPanel getPanel(StoreMenuBtnEnum smb) {
		return panelMap.get(smb);
	}
}
