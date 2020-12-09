package employee.component.panel.register;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class EmpRegFormPanel extends JPanel {

	public EmpRegFormPanel() {
		this.setDefaultConfig();
	}
	
	
	private void setDefaultConfig() {
		this.setLayout(new BorderLayout(10, 0));
		setBackground(new Color(EmpRegCenterPanel.COLOR));
		
		this.setCompenents();
	}
	
	private void setCompenents() {
		JPanel leftPanel = EmpRegFormFieldPanel.getInstance();
		this.add(leftPanel, BorderLayout.WEST);
		
		JPanel centerPanel = new EmpRegFormInputPanel();
		this.add(centerPanel , BorderLayout.CENTER);
		
		JPanel rightPanel = new EmpRegFormRemarkPanel();
		this.add(rightPanel, BorderLayout.EAST);
	}
}
