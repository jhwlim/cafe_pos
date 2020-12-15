package employee.component.panel.info;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

import common.model.EmployeeVO;
import employee.component.panel.register.EmpRegCenterPanel;
import employee.component.panel.register.EmpRegFormFieldPanel;
import employee.component.panel.register.EmpRegFormInputPanel;
import employee.component.panel.register.EmpRegFormPanel;

public class EmpInfoCenterPanel extends JPanel {

	static EmpInfoCenterPanel panel;
	
	static final int X_MARGIN = 20;
	static final int Y_MARGIN = 0;
	
	private EmpRegFormInputPanel centerPanel2;
	private EmpInfoShowPanel centerPanel;
	private JPanel showPanel, inputPanel;
	
	public EmpInfoCenterPanel(EmployeeVO employee) {
		panel = this;
		
		this.setDefaultConfig();
		this.setCompenents(employee);
	}
	
	private void setDefaultConfig() {
		this.setLayout(new CardLayout());
		setBackground(new Color(EmpInfoPanel.COLOR));
	}
	
	private void setCompenents(EmployeeVO employee) {
		
		showPanel = new JPanel();
		showPanel.setBackground(new Color(EmpInfoPanel.COLOR));
		showPanel.setLayout(new BorderLayout(X_MARGIN, Y_MARGIN));
		
		EmpInfoFieldPanel leftPanel = EmpInfoFieldPanel.getInstance();
		showPanel.add(leftPanel, BorderLayout.WEST);
		
		centerPanel = new EmpInfoShowPanel(employee);
		showPanel.add(centerPanel , BorderLayout.CENTER);
	
		this.add("SHOW", showPanel);
		
		inputPanel = new JPanel();
		inputPanel.setBackground(new Color(EmpInfoPanel.COLOR));
		inputPanel.setLayout(new BorderLayout(X_MARGIN, Y_MARGIN));
		
		EmpRegFormFieldPanel leftPanel2 = EmpRegFormFieldPanel.getInstance();
		inputPanel.add(leftPanel2, BorderLayout.WEST);
		centerPanel2 = new EmpRegFormInputPanel(employee);
		inputPanel.add(centerPanel2, BorderLayout.CENTER);
		
		this.add("MOD", inputPanel);
	}
	
	public static EmpInfoCenterPanel getCurrentPanel() {
		return panel;
	}
	
	public EmpRegFormInputPanel getFormPanel() {
		return centerPanel2;
	}
	
	public EmpInfoShowPanel getShowPanel() {
		return centerPanel;
	}
	
	public void setShowPanel(EmployeeVO employee) {
		showPanel.remove(centerPanel);
		centerPanel = new EmpInfoShowPanel(employee);
		showPanel.add(centerPanel, BorderLayout.CENTER);
	}
}
