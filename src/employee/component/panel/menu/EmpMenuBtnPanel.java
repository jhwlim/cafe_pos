package employee.component.panel.menu;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;


import javax.swing.JButton;
import javax.swing.JPanel;

import employee.component.button.EmpMenuBtn;
import employee.component.button.EmpMenuBtnEnum;

public class EmpMenuBtnPanel extends JPanel {

	private static EmpMenuBtnPanel panel; 
	
	private static final int X_MARGIN = 50;
	private static final int Y_MARGIN = 50;
	
	private static final int GRID_ROW = 2;
	private static final int GRID_COL = 2;
	
	static {
		panel = new EmpMenuBtnPanel();
		setDefaultConfig();
	}
	
	private EmpMenuBtnPanel() {
	}
	
	public static EmpMenuBtnPanel getInstance() {
		if (panel == null) {
			panel = new EmpMenuBtnPanel();
			setDefaultConfig();
		}
		
		return panel;
	}
	
	private static void setDefaultConfig() {
		panel.setLayout(new GridLayout(GRID_ROW, GRID_COL, X_MARGIN, Y_MARGIN));
		panel.setBackground(new Color(EmpMenuPanel.COLOR));
		setComponents();
	}
	
	private static void setComponents() {
		
		int count = 0;
		
		for (EmpMenuBtnEnum embe : EmpMenuBtnEnum.values()) {
			try {
				JButton button = new EmpMenuBtn(embe);
				panel.add(button);
			} catch (IOException e) {
				e.printStackTrace();
			}
			count++;
		}
		
		for (int i = count; i < GRID_ROW * GRID_COL; i++) {
			panel.add(new EmpMenuBtn());
		}
		
		
	}
	
	
	
}
