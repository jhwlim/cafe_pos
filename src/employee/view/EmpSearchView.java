package employee.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;

import employee.component.button.menu.EmpMenuBtnEnum;
import employee.component.panel.content.EmpContentPanel;
import employee.component.panel.register.EmpRegCenterPanel;
import employee.component.panel.search.EmpSearchCenterPanel;

public class EmpSearchView {

	private static EmpContentPanel panel;
	private static Container parentPanel;
	
	private static EmpSearchCenterPanel centerPanel;
	
	static EmpMenuBtnEnum embe;
	
	public static final int X_MARGIN = 150;
	public static final int Y_MARGIN = 120;
	
	static {
		parentPanel = EmployeeView.getContentPanel();
		embe = EmpMenuBtnEnum.SELECTALL;
	}
	
	public EmpSearchView() {
		
		panel = new EmpContentPanel(embe);
		parentPanel.add(embe.pageName, panel);
		
		
		setDefaultConfig();
		
	}
	
	private static void setDefaultConfig() {
		panel.setLayout(new CardLayout(X_MARGIN, Y_MARGIN));
		panel.setBackground(Color.white);
		
		setComponents();
	}
	
	private static void setComponents() {
		
		centerPanel = new EmpSearchCenterPanel();
		panel.add(centerPanel);
		
	}
	
	public static EmpSearchCenterPanel getSearchCenterPanel() {
		return centerPanel;
	}
}
