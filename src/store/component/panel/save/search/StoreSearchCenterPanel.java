package store.component.panel.save.search;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import store.component.panel.save.StoreSaveCenterPanel;


public class StoreSearchCenterPanel extends JPanel {

	public static final int COLOR = StoreSaveCenterPanel.COLOR;
	
	public StoreSearchTopPanel topPanel;
	public StoreSearchResultPanel resultPanel;
	
	public StoreSearchCenterPanel() {
		setDefaultConfig();
		setComponents();
	}
	
	private void setDefaultConfig() {		
		setLayout(new BorderLayout());
		setBackground(new Color(COLOR));		
	}
	
	private void setComponents() {
		topPanel = new StoreSearchTopPanel();
		this.add(topPanel, BorderLayout.NORTH);
		
		if (resultPanel == null) {
			resultPanel = new StoreSearchResultPanel(null);
			this.add(resultPanel, BorderLayout.CENTER);				
		}
	}
	
	public StoreSearchResultPanel getResultPanel() {
		return resultPanel;
	}
	
	public StoreSearchTopPanel getTopPanel() {
		return topPanel;
	}
	
	public void setResultPanel(StoreSearchResultPanel panel) {
		resultPanel = panel;
	}
	
}
