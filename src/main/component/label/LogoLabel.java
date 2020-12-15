package main.component.label;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LogoLabel extends JLabel {
	
	private static final String LOGO_IMG_PATH = "resources/img/main/logo.png";
	
	private static final int LOGO_IMG_WIDTH = 300;
	private static final int LOGO_IMG_HEIGHT = 300;
	
	private static Image logoImg;
	
	static {
		try {
			logoImg = ImageIO.read(new File(LOGO_IMG_PATH));			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public LogoLabel() {
		super(new ImageIcon(logoImg.getScaledInstance(LOGO_IMG_WIDTH, LOGO_IMG_HEIGHT, Image.SCALE_SMOOTH)));
	}
	
}
