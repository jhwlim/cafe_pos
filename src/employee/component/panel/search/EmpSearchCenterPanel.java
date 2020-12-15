package employee.component.panel.search;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;


public class EmpSearchCenterPanel extends JPanel {

	public static final int COLOR = 0xf0f5f5;
	
	public EmpSearchTopPanel topPanel;
	public EmpSearchResultPanel resultPanel;
	
	public EmpSearchCenterPanel() {
		this.setDefaultConfig();
	}
	
	private void setDefaultConfig() {
		
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(COLOR));
		
		setComponents();
	}
	
	private void setComponents() {
		topPanel = new EmpSearchTopPanel();
		this.add(topPanel, BorderLayout.NORTH);
		
		if (resultPanel == null) {
			resultPanel = new EmpSearchResultPanel(null);
			this.add(resultPanel, BorderLayout.CENTER);				
		}
	}
	
	public EmpSearchResultPanel getResultPanel() {
		return resultPanel;
	}
	
	public EmpSearchTopPanel getTopPanel() {
		return topPanel;
	}
	
	public void setResultPanel(EmpSearchResultPanel panel) {
		resultPanel = panel;
	}
}
