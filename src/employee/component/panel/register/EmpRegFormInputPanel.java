package employee.component.panel.register;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

import employee.component.combobox.EmpRankComboBox;

public class EmpRegFormInputPanel extends JPanel {
	
	private static final int GRID_ROW = EmpRegFormFieldPanel.GRID_ROW;
	private static final int GRID_COL = EmpRegFormFieldPanel.GRID_COL;
	private static final int GRID_X_MARGIN = EmpRegFormFieldPanel.GRID_X_MARGIN;
	private static final int GRID_Y_MARGIN = EmpRegFormFieldPanel.GRID_Y_MARGIN;
	
	public EmpRegFormInputPanel() {
		this.setDefaultConfig();
	}
	
	private void setDefaultConfig() {
		setLayout(new GridLayout(GRID_ROW, GRID_COL, GRID_X_MARGIN, GRID_Y_MARGIN));
		setBackground(new Color(EmpRegCenterPanel.COLOR));
		
		setComponents();
	}
	
	private void setComponents() {
		for (EmpRegFormFieldEnum field : EmpRegFormFieldEnum.values()) {
			if (field != EmpRegFormFieldEnum.RANK) {
				add(new JTextField());								
			} else {
				add(new EmpRankComboBox());
			}
		}
	}
}
