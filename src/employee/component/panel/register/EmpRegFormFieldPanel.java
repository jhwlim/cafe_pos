package employee.component.panel.register;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class EmpRegFormFieldPanel extends JPanel {
	
	private static EmpRegFormFieldPanel panel;
	
	public static final int NUM_OF_FIELDS = EmpRegFormFieldEnum.values().length;
	
	public static final int GRID_ROW = NUM_OF_FIELDS;
	public static final int GRID_COL = 1;
	public static final int GRID_X_MARGIN = 0;
	public static final int GRID_Y_MARGIN = 30;
	
	
	private static final int WIDTH = 90;
	private static final int HEIGHT = 0;
	
	static {
		panel = new EmpRegFormFieldPanel();
	}
	
	private EmpRegFormFieldPanel() {
		setDefaultConfig();
	}
	
	private void setDefaultConfig() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		setLayout(new GridLayout(GRID_ROW, GRID_COL, GRID_X_MARGIN, GRID_Y_MARGIN));
		setBackground(new Color(EmpRegCenterPanel.COLOR));
		
		setComponents();
	}
	
	private void setComponents() {
		for (EmpRegFormFieldEnum field : EmpRegFormFieldEnum.values()) {
			add(new JLabel(field.korName, SwingConstants.RIGHT));
		}
	}
	
	
	public static EmpRegFormFieldPanel getInstance() {
		if (panel == null) {
			panel = new EmpRegFormFieldPanel();
		}
		
		return panel;
	}
}
