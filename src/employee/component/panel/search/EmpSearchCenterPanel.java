package employee.component.panel.search;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;


public class EmpSearchCenterPanel extends JPanel {

	public static final int COLOR = 0xf0f5f5;
	
	public static EmpSearchTopPanel topPanel;
	public static EmpSearchResultPanel resultPanel;
	
	public EmpSearchCenterPanel() {
		this.setDefaultConfig();
	}
	
	private void setDefaultConfig() {
		
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(COLOR));
		
		setComponents();
	}
	
	private void setComponents() {
		topPanel = EmpSearchTopPanel.getInstance();
		this.add(topPanel, BorderLayout.NORTH);
		
		resultPanel = new EmpSearchResultPanel(null);
		this.add(resultPanel, BorderLayout.CENTER);	
	}
	
	public static EmpSearchResultPanel getResultPanel() {
		return resultPanel;
	}
	
}
