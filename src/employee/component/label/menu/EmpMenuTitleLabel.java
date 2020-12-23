package employee.component.label.menu;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import common.font.ContentMenuTitleFont;
import main.component.panel.content.SideUpPanel;

public class EmpMenuTitleLabel extends JLabel {
	
	public static final int WIDTH = 340;
	public static final int HEIGHT = SideUpPanel.PANEL_HEIGHT;
	
	static final int COLOR = 0x387e9c;
	
	public EmpMenuTitleLabel() {
	}
	
	public EmpMenuTitleLabel(String label) {
		super(label, SwingConstants.CENTER);
		super.setFont(new ContentMenuTitleFont());
		super.setForeground(new Color(COLOR));
//		super.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		super.setVerticalTextPosition(CENTER);
	}
}
