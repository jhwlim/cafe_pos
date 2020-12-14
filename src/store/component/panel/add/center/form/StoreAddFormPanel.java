package store.component.panel.add.center.form;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import store.component.panel.add.center.StoreAddCenterPanel;
import store.component.panel.add.center.StoreAddSideMarginPanel;

public class StoreAddFormPanel extends JPanel {

	static StoreAddFormPanel panel;
	
	public StoreAddFormPanel() {
		this.setDefaultConfig();
	}
	
	private void setDefaultConfig() {
		this.setLayout(new BorderLayout(10, 0));
		setBackground(new Color(StoreAddCenterPanel.COLOR));
		
		this.setCompenents();
	}
	
	private void setCompenents() {
		StoreAddFormFieldPanel leftPanel = StoreAddFormFieldPanel.getInstance();
		this.add(leftPanel, BorderLayout.WEST);
		
		StoreAddFormInputPanel centerPanel = new StoreAddFormInputPanel();
		this.add(centerPanel , BorderLayout.CENTER);
		
		add(new StoreAddSideMarginPanel(50, 0), BorderLayout.EAST);
	}
	
	public static StoreAddFormPanel getCenterPanel() {
		return panel;
	}
}
