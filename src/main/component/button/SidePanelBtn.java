package main.component.button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import common.font.MenuBtnFont;
import main.component.panel.content.SideDownPanel;

public class SidePanelBtn extends JButton {

	static final Color FONT_COLOR = new Color(0xFFFFFF);
	static final Color BG_COLOR = new Color(0x663300);
	
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
		
		setContentAreaFilled(false);
		setForeground(FONT_COLOR);// 버튼 폰트
		setBackground(BG_COLOR);// 버튼 배경
		setBorder(BorderFactory.createLineBorder(BG_COLOR));
	}
	
	static int round = 20;

	public void paint(Graphics g) {
		setBackground(getParent().getBackground());
		setBorder(null);

		Graphics2D g2d = (Graphics2D)g;

		g2d.setColor(BG_COLOR); // BG Color

		g2d.fillRoundRect(0,0,getWidth(),getHeight(),round,round);

		g2d.setColor(FONT_COLOR);

		g2d.drawRoundRect(0,0,getWidth()-1, getHeight()-1,round, round);

		FontRenderContext frc = new FontRenderContext(null, false, false);
		Rectangle2D r = getFont().getStringBounds(getText(), frc);

		float xMargin = (float)(getWidth()-r.getWidth())/2;
		float yMargin = (float)(getHeight()-getFont().getSize())/2;

		g2d.drawString(getText(), xMargin, (float)getFont().getSize() + yMargin);
	}
}
