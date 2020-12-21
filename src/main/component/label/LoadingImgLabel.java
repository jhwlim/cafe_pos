package main.component.label;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoadingImgLabel extends JLabel {
	
	private static final String IMG_PATH = "resources/img/main/loading.gif";

	private static Icon icon;
	
	static {
		icon = new ImageIcon(IMG_PATH);
	}
	
	public LoadingImgLabel() {
		super(icon);
		
	}
	
}
