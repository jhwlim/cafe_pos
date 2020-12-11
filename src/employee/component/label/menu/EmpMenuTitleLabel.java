package employee.component.label.menu;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import employee.common.font.EmpMenuTitleFont;
import main.component.panel.SideUpPanel;

public class EmpMenuTitleLabel extends JLabel {
	
	public static final int WIDTH = 340;
	public static final int HEIGHT = SideUpPanel.PANEL_HEIGHT;
	
	static final int COLOR = 0x387e9c;
//	static final int COLOR = 0xffffff;
	
	public EmpMenuTitleLabel() {
	}
	
	public EmpMenuTitleLabel(String label) {
		super(label, SwingConstants.CENTER);
		super.setFont(new EmpMenuTitleFont());
		super.setForeground(new Color(COLOR));
//		super.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		super.setVerticalTextPosition(CENTER);
	}
}
