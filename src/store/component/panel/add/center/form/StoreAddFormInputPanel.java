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

}
