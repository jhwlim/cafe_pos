package employee.component.frame;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;

import common.model.EmployeeVO;
import employee.component.panel.info.EmpInfoPanel;
import employee.component.panel.register.EmpRegCenterPanel;

public class EmpInfoFrame extends JFrame {
	
	static final int FRAME_WIDTH = 650;
	static final int FRAME_HEIGHT = 700;
	
	private static final int X_MARGIN = 5;
	private static final int Y_MARGIN = 5;
	
	private static final Color BG_COLOR = Color.gray;
	
	private static EmpInfoFrame frame;
	
	public EmpInfoFrame(EmployeeVO employee) {
		frame = this;
		setDefaultConfig();
		setComponents(employee);
	}
	
	private void setDefaultConfig() {
		setTitle("EmpInfo");
		
		setLayout(new CardLayout(X_MARGIN, Y_MARGIN)); 
		
		getContentPane().setBackground(BG_COLOR); 
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		
		setLocationRelativeTo(null); 
		
		setVisible(true);
	}
	
	private void setComponents(EmployeeVO employee) {
		EmpInfoPanel panel = new EmpInfoPanel(employee);
		
		add(panel);
	}
	
}
