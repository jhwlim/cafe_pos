package store.component.panel.save.info;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import common.model.EmployeeVO;
import common.model.StoreVO;

public class StoreInfoShowPanel extends JPanel {
	
	public static final Color BG_COLOR = new Color(0xf0e6bd);
	
	public static final int NUM_OF_FIELDS = StoreInfoFieldPanel.NUM_OF_FIELDS;
	
	public static final int GRID_ROW = NUM_OF_FIELDS;
	public static final int GRID_COL = 1;
	public static final int GRID_X_MARGIN = 0;
	public static final int GRID_Y_MARGIN = StoreInfoFieldPanel.GRID_Y_MARGIN;
		
	StoreVO store;
	
	public StoreInfoShowPanel(StoreVO store) {
		this.store = store;
		setDefaultConfig();
		setComponents(store);
	}
	
	private void setDefaultConfig() {
		setLayout(new GridLayout(GRID_ROW, GRID_COL, GRID_X_MARGIN, GRID_Y_MARGIN));
		setBackground(BG_COLOR);
	}
	
	private void setComponents(StoreVO store) {
		for (StoreInfoFieldEnum field : StoreInfoFieldEnum.values()) {
			JLabel input = new JLabel();
			input.setOpaque(true);
			input.setBackground(BG_COLOR);
			
			switch (field) {
			case STORE_ID :
				input.setText(String.valueOf(store.getStoreId()));
				break;
			case NAME :
				input.setText(store.getStoreName());
				break;
			case ADDR :
				input.setText(store.getStoreAddr());
				break;
			case SIZE:
				if (store.getStoreSize() == 0) {
					input.setText("");
				} else {
					input.setText(String.valueOf(store.getStoreSize()));
				}
				break;
			case TYPE :
				input.setText(String.valueOf(store.getStoreType()));
			}
			
			add(input);
			
		}
	}

}
