package employee.component.button.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import employee.controller.button.menu.EmpMenuClickListener;

public class EmpMenuBtn extends JButton {
	
	public static final int BTN_WIDTH = 130;
	public static final int BTN_HEIGHT = 60;
	
	private static final int IMG_WIDTH = 40;
	private static final int IMG_HEIGHT = 40;
	private static final int COLOR = 0xedf2f2;
	
	public EmpMenuBtn(EmpMenuBtnEnum embe) throws IOException {
		super(new ImageIcon(ImageIO.read(new File(embe.imgPath)).getScaledInstance(IMG_WIDTH, IMG_HEIGHT, Image.SCALE_SMOOTH)));
		setBackground(new Color(COLOR));
		addActionListener(new EmpMenuClickListener(embe));
		setPreferredSize(new Dimension(BTN_WIDTH, BTN_HEIGHT));
	}
	
	public EmpMenuBtn() {
		super.setBackground(new Color(COLOR));
	}
	
}
