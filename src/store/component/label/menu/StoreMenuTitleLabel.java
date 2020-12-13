package store.component.label.menu;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import employee.common.font.EmpMenuTitleFont;
import main.component.panel.SideUpPanel;

public class StoreMenuTitleLabel extends JLabel {
	
	public static final int WIDTH = 340;
	public static final int HEIGHT = SideUpPanel.PANEL_HEIGHT;
	
	static final int COLOR = 0x508a63;
	
	public StoreMenuTitleLabel() {
	}
	
	public StoreMenuTitleLabel(String label) {
		super(label, SwingConstants.CENTER);
		setFont(new EmpMenuTitleFont());
		setForeground(new Color(COLOR));
		super.setVerticalTextPosition(CENTER);
	}
}
