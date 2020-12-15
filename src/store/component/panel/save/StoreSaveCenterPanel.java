package store.component.panel.save;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import employee.component.panel.search.EmpSearchCenterPanel;
import store.component.panel.add.center.form.StoreAddFormPanel;
import store.component.panel.save.info.StoreInfoPanel;
import store.component.panel.save.search.StoreSearchPanel;

public class StoreSaveCenterPanel extends JPanel {

	public static final int COLOR = 0xe1f0e6;
	
	
	public StoreSaveCenterPanel() {
		setDefaultConfig();
		setComponents();
	}
	
	private void setDefaultConfig() {	
		setLayout(new BorderLayout());
		setBackground(new Color(COLOR));
	}
	
	private void setComponents() {
		StoreInfoPanel topPanel = new StoreInfoPanel();
		add(topPanel, BorderLayout.NORTH);
		
		StoreSearchPanel centerPanel = new StoreSearchPanel();
		add(centerPanel, BorderLayout.CENTER);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(0, 100));
		bottomPanel.setBackground(new Color(COLOR));
		add(bottomPanel, BorderLayout.SOUTH);
//	
//		add(new StoreAddSideMarginPanel(), BorderLayout.EAST);
//		add(new StoreAddSideMarginPanel(), BorderLayout.WEST);
//	
	}
	
}
