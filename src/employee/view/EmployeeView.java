package employee.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import employee.component.button.EmpMenuBtnEnum;
import employee.component.panel.menu.EmpMenuPanel;
import main.component.button.MenuBtnEnum;
import main.component.panel.ContentPanel;

public class EmployeeView {

	public static JPanel panel;
	
	static String empPageName = "MENU";
	public static Map<EmpMenuBtnEnum, JPanel> panelMap;
	
	static {
		panel = ContentPanel.getPanel(MenuBtnEnum.EMPLOYEE);
		panel.setLayout(new CardLayout());
		panel.setBackground(Color.white);
	
		panelMap = new HashMap<EmpMenuBtnEnum, JPanel>();	
	}
	
	
	public EmployeeView() {
		
		// 패널 초기화
		panel.removeAll();
		
		/////////////////////////////////////////////////
		
		EmpMenuPanel emp = EmpMenuPanel.getInstance();
		panel.add(empPageName, emp);
		
		for (EmpMenuBtnEnum embe : EmpMenuBtnEnum.values()) {
			JPanel contentPanel = new JPanel();
			contentPanel.add(new JLabel(embe.toString()));
			panel.add(embe.pageName, contentPanel);
			contentPanel.setBackground(Color.white);
		
			panelMap.put(embe, contentPanel);
		}
		
	}
	
	public static JPanel getPanel(EmpMenuBtnEnum embe) {
		return panelMap.get(embe);
	}
}
