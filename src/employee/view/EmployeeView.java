package employee.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import employee.component.button.EmpMenuBtnEnum;
import employee.component.panel.content.EmpContentPanel;
import employee.component.panel.menu.EmpMenuPanel;
import main.component.button.MenuBtnEnum;
import main.component.panel.ContentPanel;

public class EmployeeView {

	public static JPanel panel;
	
	static String empPageName = "MENU";
	
	static {
		panel = ContentPanel.getPanel(MenuBtnEnum.EMPLOYEE);
		panel.setLayout(new CardLayout());
		panel.setBackground(Color.white);
	
	}
	
	
	public EmployeeView() {
		
		// 패널 초기화
		panel.removeAll();
		
		/////////////////////////////////////////////////
		
		EmpMenuPanel emp = EmpMenuPanel.getInstance();
		panel.add(empPageName, emp);
		
		for (EmpMenuBtnEnum embe : EmpMenuBtnEnum.values()) {
			JPanel contentPanel = new EmpContentPanel(embe);
			panel.add(embe.pageName, contentPanel);
			
			
		}
		
	}

}
