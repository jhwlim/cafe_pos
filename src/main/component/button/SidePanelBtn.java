package main.component.button;

import javax.swing.JButton;

import common.font.MenuBtnFont;
import main.component.panel.SideDownPanel;
import main.component.panel.SidePanel;

public class SidePanelBtn extends JButton {

	static final int PANEL_WIDTH = SideDownPanel.PANEL_WIDTH;
	static final int PANEL_HEIGHT = SideDownPanel.PANEL_HEIGHT;
	
	public static final int BTN_WIDTH = (int) (PANEL_WIDTH * 0.65);
	public static final int BTN_HEIGHT = (int) (PANEL_HEIGHT * 0.55);
	public static final int BTN_X_LOCATION = (PANEL_WIDTH - BTN_WIDTH) / 2;
	public static final int BTN_Y_LOCATION = (PANEL_HEIGHT - BTN_HEIGHT) / 2;
	
	public SidePanelBtn(String btnName) {
		super(btnName);
		super.setBounds(BTN_X_LOCATION, BTN_Y_LOCATION, BTN_WIDTH, BTN_HEIGHT);
		super.setFont(new MenuBtnFont());
	}
}
