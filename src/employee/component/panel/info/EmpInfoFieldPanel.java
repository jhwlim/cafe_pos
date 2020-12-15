package employee.component.panel.info;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import employee.component.panel.register.EmpRegCenterPanel;

public class EmpInfoFieldPanel extends JPanel {

	private static EmpInfoFieldPanel panel;
	
	public static final int NUM_OF_FIELDS = EmpInfoFieldEnum.values().length;
	
	public static final int GRID_ROW = NUM_OF_FIELDS;
	public static final int GRID_COL = 1;
	public static final int GRID_X_MARGIN = 0;
	public static final int GRID_Y_MARGIN = 20;
	
	
	private static final int WIDTH = 90;
	private static final int HEIGHT = 0;
	
	static {
		panel = new EmpInfoFieldPanel();
	}
	
	private EmpInfoFieldPanel() {
		setDefaultConfig();
	}
	
	private void setDefaultConfig() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		setLayout(new GridLayout(GRID_ROW, GRID_COL, GRID_X_MARGIN, GRID_Y_MARGIN));
		setBackground(new Color(EmpInfoPanel.COLOR));
		setComponents();
	}
	
	private void setComponents() {
		for (EmpInfoFieldEnum field : EmpInfoFieldEnum.values()) {
			add(new JLabel(field.korName, SwingConstants.RIGHT));
		}
	}
	
	
	public static EmpInfoFieldPanel getInstance() {
		if (panel == null) {
			panel = new EmpInfoFieldPanel();
		}
		
		return panel;
	}
}
