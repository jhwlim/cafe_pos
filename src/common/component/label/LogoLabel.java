package common.component.label;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.component.panel.content.SideUpPanel;

public class LogoLabel extends JLabel {

	private static final int IMG_SIZE = 200;
	
	public LogoLabel() throws IOException {
		super(new ImageIcon(ImageIO.read(new File("resources/img/design/main/starbucks_side.png")).getScaledInstance(IMG_SIZE, IMG_SIZE, Image.SCALE_SMOOTH)));
		setPreferredSize(new Dimension(IMG_SIZE, IMG_SIZE));
	}
	
}
