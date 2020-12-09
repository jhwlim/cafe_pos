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

public class EmpRegFormInputPanel extends JPanel {
	
	private static final int GRID_ROW = 11;
	private static final int GRID_COL = EmpRegFormFieldPanel.GRID_COL;
	
	private Map<EmpRegFormFieldEnum, JComponent> inputMap;
	private Map<EmpRegFormFieldEnum, JLabel> labelMap;
	
	public EmpRegFormInputPanel() {
		this.setDefaultConfig();
	}
	
	private void setDefaultConfig() {
		setLayout(new GridLayout(GRID_ROW, GRID_COL));
		setBackground(new Color(EmpRegCenterPanel.COLOR));
		
		setComponents();
	}
	
	private void setComponents() {
		inputMap = new HashMap<EmpRegFormFieldEnum, JComponent>();
		labelMap = new HashMap<EmpRegFormFieldEnum, JLabel>();
		for (EmpRegFormFieldEnum field : EmpRegFormFieldEnum.values()) {
			if (field != EmpRegFormFieldEnum.RANK) {
				JTextField input = new JTextField();
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

	public JComponent getComponentValue(EmpRegFormFieldEnum field) {
		return inputMap.get(field);
	}

	public JLabel getLabel(EmpRegFormFieldEnum field) {
		return labelMap.get(field);
	}

	
}
