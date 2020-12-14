package store.component.panel.add.center.form;

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
import store.component.combobox.StoreTypeComboBox;
import store.component.panel.add.center.StoreAddCenterPanel;

public class StoreAddFormInputPanel extends JPanel {
	
	private static final int GRID_ROW = StoreAddFormFieldPanel.GRID_ROW;
	private static final int GRID_COL = StoreAddFormFieldPanel.GRID_COL;
	
	private static final int GRID_X_MARGIN = StoreAddFormFieldPanel.GRID_X_MARGIN;
	private static final int GRID_Y_MARGIN = StoreAddFormFieldPanel.GRID_Y_MARGIN;
	
	private Map<StoreAddFormFieldEnum, JComponent> inputMap;
	private Map<StoreAddFormFieldEnum, JLabel> labelMap;
	
	public StoreAddFormInputPanel() {
		setDefaultConfig();
		setComponents();
	}
	
	private void setDefaultConfig() {
		setLayout(new GridLayout(GRID_ROW, GRID_COL, GRID_X_MARGIN, GRID_Y_MARGIN));
		setBackground(new Color(StoreAddCenterPanel.COLOR));		
	}
	
	private void setComponents() {
		inputMap = new HashMap<>();
		labelMap = new HashMap<>();
		
		for (StoreAddFormFieldEnum field : StoreAddFormFieldEnum.values()) {
			
			
			if (field != StoreAddFormFieldEnum.TYPE) {
				JTextField input = new JTextField();
				add(input);
				inputMap.put(field, input);
			} else {
				JComboBox<String> input = new StoreTypeComboBox();
				add(input);
				inputMap.put(field, input);
			}
		}
	}

	public JComponent getComponentValue(StoreAddFormFieldEnum field) {
		return inputMap.get(field);
	}

	public JLabel getLabel(StoreAddFormFieldEnum field) {
		return labelMap.get(field);
	}

	/*
	private EmployeeVO employee;
	
	
	public StoreAddFormInputPanel(EmployeeVO employee) {
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
	*/
}
