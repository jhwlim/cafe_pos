package store.component.panel.save.info;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import store.component.panel.add.center.StoreAddCenterPanel;

public class StoreInfoFieldPanel extends JPanel {
	
	public static final Color BG_COLOR = new Color(0xf0e6bd);
	
	private static StoreInfoFieldPanel panel;
	
	public static final int NUM_OF_FIELDS = StoreInfoFieldEnum.values().length;
	
	public static final int GRID_ROW = NUM_OF_FIELDS;
	public static final int GRID_COL = 1;
	public static final int GRID_X_MARGIN = 0;
	public static final int GRID_Y_MARGIN = 10;
	
	
	private static final int WIDTH = 130;
	private static final int HEIGHT = 0;
	
	static {
		panel = new StoreInfoFieldPanel();
	}
	
	private StoreInfoFieldPanel() {
		setDefaultConfig();
	}
	
	private void setDefaultConfig() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		setLayout(new GridLayout(GRID_ROW, GRID_COL, GRID_X_MARGIN, GRID_Y_MARGIN));
		setBackground(BG_COLOR);
		
		setComponents();
	}
	
	private void setComponents() {
		for (StoreInfoFieldEnum field : StoreInfoFieldEnum.values()) {
			add(new JLabel(field.korName, SwingConstants.RIGHT));
		}
	}
	
	
	public static StoreInfoFieldPanel getInstance() {
		if (panel == null) {
			panel = new StoreInfoFieldPanel();
		}
		
		return panel;
	}
}
