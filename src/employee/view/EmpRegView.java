package employee.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;

import employee.component.button.EmpMenuBtnEnum;
import employee.component.panel.content.EmpContentPanel;
import employee.component.panel.register.EmpRegCenterPanel;

public class EmpRegView {

	public static EmpContentPanel panel;
	public static Container parentPanel;
	
	public static final int X_MARGIN = 150;
	public static final int Y_MARGIN = 120;
	
	static EmpMenuBtnEnum embe;
	
	static {
		parentPanel = EmployeeView.getContentPanel();
		embe = EmpMenuBtnEnum.INSERT;
	}
	
	public EmpRegView() {
		
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
		
		EmpRegCenterPanel centerPanel = new EmpRegCenterPanel();
		panel.add(centerPanel);
		
	}
}
