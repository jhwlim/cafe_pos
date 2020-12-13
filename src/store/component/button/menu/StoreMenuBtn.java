package store.component.button.menu;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import employee.controller.button.menu.EmpMenuClickListener;
import store.controller.button.menu.StoreMenuClickListener;

public class StoreMenuBtn extends JButton {
	
	private static final int IMG_WIDTH = 70;
	private static final int IMG_HEIGHT = 70;
	private static final int COLOR = 0xe1f0e6;
	
	public StoreMenuBtn(StoreMenuBtnEnum smb) throws IOException {
		super(new ImageIcon(ImageIO.read(new File(smb.imgPath)).getScaledInstance(IMG_WIDTH, IMG_HEIGHT, Image.SCALE_SMOOTH)));
		super.setBackground(new Color(COLOR));
		super.addActionListener(new StoreMenuClickListener(smb));
	}
	
	public StoreMenuBtn() {
		super.setBackground(new Color(COLOR));
	}
	
}
