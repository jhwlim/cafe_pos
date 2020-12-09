package employee.view;

import java.awt.Color;

import employee.component.button.EmpMenuBtnEnum;
import employee.component.panel.content.EmpContentPanel;

public class EmpRegView {

	public static EmpContentPanel panel;
	
	static {
		panel = EmpContentPanel.getPanel(EmpMenuBtnEnum.INSERT);
	}
	
	public EmpRegView() {
		setDefaultConfig();
	}
	
	private void setDefaultConfig() {
		
		panel.setBackground(Color.blue);
		
		setComponents();
	}
	
	private void setComponents() {
		
	}
}
