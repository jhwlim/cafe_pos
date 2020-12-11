package employee.component.panel.info;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import common.model.EmployeeVO;

public class EmpInfoShowPanel extends JPanel {
	
	public static final int NUM_OF_FIELDS = EmpInfoFieldEnum.values().length;
	
	public static final int GRID_ROW = NUM_OF_FIELDS;
	public static final int GRID_COL = 1;
	public static final int GRID_X_MARGIN = 0;
	public static final int GRID_Y_MARGIN = EmpInfoFieldPanel.GRID_Y_MARGIN;
	
	private static EmpInfoShowPanel panel;
	
	EmployeeVO employee;
	
	public EmpInfoShowPanel(EmployeeVO employee) {
		this.employee = employee;
		panel = this;
		
		setDefaultConfig();
		setComponents(employee);
	}
	
	private void setDefaultConfig() {
		setLayout(new GridLayout(GRID_ROW, GRID_COL, GRID_X_MARGIN, GRID_Y_MARGIN));
		setBackground(new Color(EmpInfoPanel.COLOR));
	}
	
	private void setComponents(EmployeeVO employee) {
		for (EmpInfoFieldEnum field : EmpInfoFieldEnum.values()) {
			JLabel input = new JLabel();
			input.setOpaque(true);
			input.setBackground(Color.white);
			
			switch (field) {
			case EMP_ID :
				input.setText(String.valueOf(employee.getEmpId()));
				break;
			case NAME :
				input.setText(employee.getEmpName());
				break;
			case BIRTH :
				input.setText(employee.getEmpBirth());			
				break;
			case CERTIF :
				input.setText(employee.getCertifExpireDate());				
				break;
			case JOIN_DATE :
				input.setText(String.valueOf(employee.getJoinDate()));
				break;
			case NICK :
				input.setText(employee.getEmpNick());				
				break;
			case RANK :
				input.setText(String.valueOf(employee.getEmpRank()));
				break;
			case STORE_ID :
				if (employee.getStoreId() != 0) {
					input.setText(String.valueOf(employee.getStoreId()));
				} 
				break;
			}
			
			add(input);
			
		}
	}
	
	public static EmpInfoShowPanel getCurrentPanel() {
		return panel;
	}
	
	public EmployeeVO getEmployee() {
		return employee;
	}
	
}
