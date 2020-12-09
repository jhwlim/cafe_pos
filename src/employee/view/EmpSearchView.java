package employee.view;

import java.awt.Color;

import employee.component.button.EmpMenuBtnEnum;
import employee.component.panel.content.EmpContentPanel;

public class EmpSearchView {

	public static EmpContentPanel panel;
	
	static {
		panel = EmpContentPanel.getPanel(EmpMenuBtnEnum.SELECTALL);
	}
	
	public EmpSearchView() {
		setDefaultConfig();
	}
	
	private void setDefaultConfig() {
		
		panel.setBackground(Color.cyan);
		
		setComponents();
	}
	
	private void setComponents() {
		
	}
}
