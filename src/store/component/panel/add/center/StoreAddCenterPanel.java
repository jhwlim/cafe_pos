package store.component.panel.add.center;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import store.component.panel.add.center.form.StoreAddFormPanel;

public class StoreAddCenterPanel extends JPanel {

	public static final int COLOR = 0xe1f0e6;
	
	public StoreAddCenterPanel() {
		setDefaultConfig();
		setComponents();
	}
	
	private void setDefaultConfig() {	
		setLayout(new BorderLayout());
		setBackground(new Color(COLOR));
	}
	
	private void setComponents() {
		StoreAddCenterTopPanel topPanel = StoreAddCenterTopPanel.getInstance();
		add(topPanel, BorderLayout.NORTH);
		
		StoreAddFormPanel centerPanel = new StoreAddFormPanel();
		add(centerPanel, BorderLayout.CENTER);
		
		StoreAddCenterBottomPanel bottomPanel = StoreAddCenterBottomPanel.getInstance();
		add(bottomPanel, BorderLayout.SOUTH);
	
		add(new StoreAddSideMarginPanel(), BorderLayout.EAST);
		add(new StoreAddSideMarginPanel(), BorderLayout.WEST);
	
	}
	
	
}
