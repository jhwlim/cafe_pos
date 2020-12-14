package store.component.panel.add.center;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import store.component.panel.add.center.form.StoreAddFormPanel;

public class StoreAddCenterPanel extends JPanel {

	public static final int COLOR = 0xe1f0e6;
	
	public StoreAddCenterPanel() {
		this.setDefaultConfig();
		
	}
	
	private void setDefaultConfig() {
		
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(COLOR));
		
		setComponents();
	}
	
	private void setComponents() {
		StoreAddCenterTopPanel topPanel = StoreAddCenterTopPanel.getInstance();
		this.add(topPanel, BorderLayout.NORTH);
		
		StoreAddFormPanel centerPanel = new StoreAddFormPanel();
		this.add(centerPanel, BorderLayout.CENTER);
		
		StoreAddCenterBottomPanel bottomPanel = StoreAddCenterBottomPanel.getInstance();
		this.add(bottomPanel, BorderLayout.SOUTH);
	
		this.add(new StoreAddSideMarginPanel(), BorderLayout.EAST);
		this.add(new StoreAddSideMarginPanel(), BorderLayout.WEST);
//	
	}
}
