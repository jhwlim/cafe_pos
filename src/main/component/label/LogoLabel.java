package main.component.label;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LogoLabel extends JLabel {
	
	public static final String LOGO_IMG_PATH = "resources/img/main/logo_java.png";
	
	private static final int LOGO_IMG_WIDTH = 500;
	private static final int LOGO_IMG_HEIGHT = 500;
	
	private static Image logoImg;
	private static ImageIcon logoImgIcon;
	
	static {
		try {
			logoImg = ImageIO.read(new File(LOGO_IMG_PATH));
			logoImgIcon = new ImageIcon(logoImg.getScaledInstance(LOGO_IMG_WIDTH, LOGO_IMG_HEIGHT, Image.SCALE_SMOOTH));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public LogoLabel() {
		super(logoImgIcon);
	}
	
	public static Image getImg() {
		return logoImg;
	}
	
	public static ImageIcon getImgIcon() {
		return logoImgIcon;
	}
	
}
