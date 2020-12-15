package store.component.panel.add.center.form;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import store.component.panel.add.center.StoreAddCenterPanel;
import store.component.panel.add.center.StoreAddSideMarginPanel;

public class StoreAddFormPanel extends JPanel {

	static StoreAddFormInputPanel centerPanel;
	
	public StoreAddFormPanel() {
		setDefaultConfig();
		setCompenents();
	}
	
	private void setDefaultConfig() {
		setLayout(new BorderLayout(10, 0));
		setBackground(new Color(StoreAddCenterPanel.COLOR));
	}
	
	private void setCompenents() {
		StoreAddFormFieldPanel leftPanel = StoreAddFormFieldPanel.getInstance();
		add(leftPanel, BorderLayout.WEST);
		
		centerPanel = new StoreAddFormInputPanel();
		add(centerPanel , BorderLayout.CENTER);
		
		add(new StoreAddSideMarginPanel(50, 0), BorderLayout.EAST);
	}
	
	public static StoreAddFormInputPanel getCenterPanel() {
		return centerPanel;
	}
}
