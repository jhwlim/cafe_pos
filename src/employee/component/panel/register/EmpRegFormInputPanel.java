package employee.component.panel.register;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.InputMap;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import common.model.EmployeeVO;
import employee.component.combobox.EmpRankComboBox;
import employee.component.label.register.EmpRegErrorLabel;
import store.common.config.StoreConfig;

public class EmpRegFormInputPanel extends JPanel {
	
	private static final int GRID_ROW = 11;
	private static final int GRID_COL = EmpRegFormFieldPanel.GRID_COL;
	
	private Map<EmpRegFormFieldEnum, JComponent> inputMap;
	private Map<EmpRegFormFieldEnum, JLabel> labelMap;
	
	public EmpRegFormInputPanel() {
		setDefaultConfig();
		setComponents();
	}
	
	private void setDefaultConfig() {
		setLayout(new GridLayout(GRID_ROW, GRID_COL));
		setBackground(new Color(EmpRegCenterPanel.COLOR));		
	}
	
	private void setComponents() {
		inputMap = new HashMap<EmpRegFormFieldEnum, JComponent>();
		labelMap = new HashMap<EmpRegFormFieldEnum, JLabel>();
		for (EmpRegFormFieldEnum field : EmpRegFormFieldEnum.values()) {
			if (field != EmpRegFormFieldEnum.RANK) {
				JTextField input = new JTextField();
				add(input);
				inputMap.put(field, input);
				if (field == EmpRegFormFieldEnum.STORE_ID) {
					input.setText(String.valueOf(StoreConfig.getStoreId()));
				}
				
				EmpRegErrorLabel label = new EmpRegErrorLabel();
				add(label);
				labelMap.put(field, label);
			} else {
				JComboBox<String> input = new EmpRankComboBox();
				add(input);
				inputMap.put(field, input);
			}
		}
	}

	public JComponent getComponentValue(EmpRegFormFieldEnum field) {
		return inputMap.get(field);
	}

	public JLabel getLabel(EmpRegFormFieldEnum field) {
		return labelMap.get(field);
	}

	private EmployeeVO employee;
	
	public EmpRegFormInputPanel(EmployeeVO employee) {
		this.employee = employee;
		setDefaultConfig();
		setComponents(employee);
	}
	private void setComponents(EmployeeVO employee) {
		inputMap = new HashMap<EmpRegFormFieldEnum, JComponent>();
		labelMap = new HashMap<EmpRegFormFieldEnum, JLabel>();
		for (EmpRegFormFieldEnum field : EmpRegFormFieldEnum.values()) {
			if (field != EmpRegFormFieldEnum.RANK) {
				JTextField input = new JTextField();
				switch (field) {
				case NAME:
					input.setText(employee.getEmpName());
					break;
				case NICK:
					input.setText(employee.getEmpNick());
					break;
				case BIRTH:
					input.setText(employee.getEmpBirth());
					break;
				case CERTIF:
					input.setText(employee.getCertifExpireDate());
					break;
				case STORE_ID:
					if (employee.getStoreId() != 0) {
						input.setText(String.valueOf(employee.getStoreId()));
					}
					break;
				}
				
				add(input);
				inputMap.put(field, input);
				
				EmpRegErrorLabel label = new EmpRegErrorLabel();
				add(label);
				labelMap.put(field, label);
			} else {
				JComboBox<String> input = new EmpRankComboBox();
				add(input);
				inputMap.put(field, input);
			}
		}
	}
	
	public EmployeeVO getEmployee() {
		return employee;
	}
}
