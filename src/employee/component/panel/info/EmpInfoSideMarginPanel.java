package employee.component.panel.info;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class EmpInfoSideMarginPanel extends JPanel {

	private static final int WIDTH = 170;
	private static final int HEIGHT = 0;
	
	public EmpInfoSideMarginPanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(new Color(EmpInfoPanel.COLOR));
	}
	
}
