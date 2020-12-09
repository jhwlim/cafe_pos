package employee.component.panel.register;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import employee.common.font.EmpRegRemarkFont;
import employee.component.combobox.EmpRankComboBox;
import employee.component.label.register.EmpRegRemarkLabel;

public class EmpRegFormRemarkPanel extends JPanel {
	
	private static final int GRID_ROW = EmpRegFormFieldPanel.GRID_ROW;
	private static final int GRID_COL = EmpRegFormFieldPanel.GRID_COL;
	private static final int GRID_X_MARGIN = EmpRegFormFieldPanel.GRID_X_MARGIN;
	private static final int GRID_Y_MARGIN = EmpRegFormFieldPanel.GRID_Y_MARGIN;
	
	public EmpRegFormRemarkPanel() {
		this.setDefaultConfig();
	}
	
	private void setDefaultConfig() {
		setLayout(new GridLayout(GRID_ROW, GRID_COL, GRID_X_MARGIN, GRID_Y_MARGIN));
		setBackground(new Color(EmpRegCenterPanel.COLOR));
		
		setComponents();
	}
	
	private void setComponents() {
		for (EmpRegFormFieldEnum field : EmpRegFormFieldEnum.values()) {
			JLabel remark = new EmpRegRemarkLabel();
			switch (field) {
			case BIRTH :
				remark.setText("ex) 950123");
				break;
			case CERTIF :
				remark.setText("ex) 210102");
				break;
			default :
				break;	
			}
			add(remark);
		}
	}
	
	
}
