package employee.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import employee.component.button.menu.EmpMenuBtnEnum;
import employee.component.panel.content.EmpContentPanel;
import employee.component.panel.menu.EmpMenuPanel;
import main.component.button.MenuBtnEnum;
import main.component.panel.content.ContentPanel;

public class EmployeeView {

	private static JPanel panel;
	
	public static final String MENU_PAGE_NAME = "MENU";
	
	static {
		panel = ContentPanel.getPanel(MenuBtnEnum.EMPLOYEE);
		panel.setLayout(new CardLayout());
		panel.setBackground(Color.white);
	}
	
	public static JPanel getContentPanel() {
		return panel;
	}
	
	public EmployeeView() {
		
		// 패널 초기화
		panel.removeAll();
		
		EmpMenuPanel emp = EmpMenuPanel.getInstance();
		panel.add(MENU_PAGE_NAME, emp);
		
	}

}
