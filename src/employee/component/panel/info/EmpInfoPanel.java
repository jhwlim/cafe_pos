package employee.component.panel.info;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import common.model.EmployeeVO;
import employee.component.panel.register.EmgRegLeftMarginPanel;
import employee.component.panel.register.EmgRegRightMarginPanel;
import employee.component.panel.register.EmpRegBottomPanel;
import employee.component.panel.register.EmpRegFormPanel;
import employee.component.panel.register.EmpRegTopPanel;

public class EmpInfoPanel extends JPanel {
	
	public static final int COLOR = 0xf0f5f5;
	
	public EmpInfoPanel(EmployeeVO employee) {
		setDefaultConfig();
		setComponents(employee);
	}
	
	private void setDefaultConfig() {
		
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(COLOR));
		
	}
	
	private void setComponents(EmployeeVO employee) {
		EmpRegTopPanel topPanel = EmpRegTopPanel.getInstance();
		this.add(topPanel, BorderLayout.NORTH);
		
		EmpInfoCenterPanel centerPanel = new EmpInfoCenterPanel(employee);
		this.add(centerPanel, BorderLayout.CENTER);
			
		EmpInfoBtnPanel bottomPanel = new EmpInfoBtnPanel();
		this.add(bottomPanel, BorderLayout.SOUTH);
	
		this.add(new EmpInfoSideMarginPanel(), BorderLayout.EAST);
		this.add(new EmpInfoSideMarginPanel(), BorderLayout.WEST);
	
	}
}
