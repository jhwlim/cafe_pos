package employee.component.panel.register;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class EmpRegFormPanel extends JPanel {

	static EmpRegFormInputPanel centerPanel;
	
	public EmpRegFormPanel() {
		this.setDefaultConfig();
	}
	
	private void setDefaultConfig() {
		this.setLayout(new BorderLayout(10, 0));
		setBackground(new Color(EmpRegCenterPanel.COLOR));
		
		this.setCompenents();
	}
	
	private void setCompenents() {
		EmpRegFormFieldPanel leftPanel = EmpRegFormFieldPanel.getInstance();
		this.add(leftPanel, BorderLayout.WEST);
		
		centerPanel = new EmpRegFormInputPanel();
		this.add(centerPanel , BorderLayout.CENTER);
		EmpRegFormRemarkPanel rightPanel = new EmpRegFormRemarkPanel();
		this.add(rightPanel, BorderLayout.EAST);
	}
	
	public static EmpRegFormInputPanel getCenterPanel() {
		return centerPanel;
	}
}
