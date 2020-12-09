package employee.component.panel.content;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import employee.component.button.EmpMenuBtnEnum;

public class EmpContentPanel extends JPanel {

	private static Map<EmpMenuBtnEnum, EmpContentPanel> panelMap;
	
	static {
		panelMap = new HashMap<EmpMenuBtnEnum, EmpContentPanel>();	
	}
	
	public EmpContentPanel(EmpMenuBtnEnum embe) {
		panelMap.put(embe, this);
	}
	
	public static EmpContentPanel getPanel(EmpMenuBtnEnum embe) {
		return panelMap.get(embe);
	}
}
