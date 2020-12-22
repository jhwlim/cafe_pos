package common.component.button;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import main.controller.btn.MenuBtnClickListener;

public class RoundImgBtn extends JButton {

	private static final int IMG_SIZE = 60;
	
	int round;
	Color bgColor;
	Color fontColor;

	public RoundImgBtn(String path, int round, Color bgColor, Color fontColor) throws IOException {
		super(new ImageIcon(ImageIO.read(new File(path)).getScaledInstance(IMG_SIZE, IMG_SIZE, Image.SCALE_SMOOTH)));
		
		this.round = round;
		this.bgColor = bgColor;
		this.fontColor = fontColor;
		
		setContentAreaFilled(false);

		setForeground(fontColor);// 버튼 폰트
		setBackground(bgColor);// 버튼 배경
		setBorder(BorderFactory.createLineBorder(bgColor));
	}

	
	public void paint(Graphics g) {
		setBackground(getParent().getBackground());
		setBorder(null);

		Graphics2D g2d = (Graphics2D)g;

		g2d.setColor(bgColor); // BG Color

		g2d.fillRoundRect(0,0,getWidth(),getHeight(),round,round);

		g2d.setColor(fontColor);

		g2d.drawRoundRect(0,0,getWidth()-1, getHeight()-1,round, round);

		FontRenderContext frc = new FontRenderContext(null, false, false);
		Rectangle2D r = getFont().getStringBounds(getText(), frc);

		float xMargin = (float)(getWidth()-r.getWidth())/2;
		float yMargin = (float)(getHeight()-getFont().getSize())/2;

		g2d.drawString(getText(), xMargin, (float)getFont().getSize() + yMargin);
	}


}
