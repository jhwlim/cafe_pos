package employee.component.panel.register;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class EmpRegCenterPanel extends JPanel {

	public static final int COLOR = 0xf0f5f5;
	
	public EmpRegCenterPanel() {
		this.setDefaultConfig();
		
	}
	
	private void setDefaultConfig() {
		
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(COLOR));
		
		setComponents();
	}
	
	private void setComponents() {
		EmpRegTopPanel topPanel = EmpRegTopPanel.getInstance();
		this.add(topPanel, BorderLayout.NORTH);
		
		EmpRegBottomPanel bottomPanel = EmpRegBottomPanel.getInstance();
		this.add(bottomPanel, BorderLayout.SOUTH);
	
//		this.add(new EmgRegSidePanel(), BorderLayout.EAST);
//		this.add(new EmgRegSidePanel(), BorderLayout.WEST);
	
	}
}
