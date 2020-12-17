package store.component.panel.add.center.form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import store.component.panel.add.center.StoreAddCenterPanel;

public class StoreAddFormFieldPanel extends JPanel {
	
	private static StoreAddFormFieldPanel panel;
	
	public static final int NUM_OF_FIELDS = StoreAddFormFieldEnum.values().length;
	
	public static final int GRID_ROW = NUM_OF_FIELDS;
	public static final int GRID_COL = 1;
	public static final int GRID_X_MARGIN = 0;
	public static final int GRID_Y_MARGIN = 30;
	
	
	private static final int WIDTH = 90;
	private static final int HEIGHT = 0;
	
	static {
		panel = new StoreAddFormFieldPanel();
	}
	
	private StoreAddFormFieldPanel() {
		setDefaultConfig();
	}
	
	private void setDefaultConfig() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		setLayout(new GridLayout(GRID_ROW, GRID_COL, GRID_X_MARGIN, GRID_Y_MARGIN));
		setBackground(new Color(StoreAddCenterPanel.COLOR));
		
		setComponents();
	}
	
	private void setComponents() {
		for (StoreAddFormFieldEnum field : StoreAddFormFieldEnum.values()) {
			add(new JLabel(field.korName, SwingConstants.RIGHT));
		}
	}
	
	
	public static StoreAddFormFieldPanel getInstance() {
		if (panel == null) {
			panel = new StoreAddFormFieldPanel();
		}
		
		return panel;
	}
}
