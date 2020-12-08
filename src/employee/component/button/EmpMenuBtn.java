package employee.component.button;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import employee.controller.button.EmpMenuClickListener;

public class EmpMenuBtn extends JButton {
	
	private static final int IMG_WIDTH = 70;
	private static final int IMG_HEIGHT = 70;
	private static final int COLOR = 0xedf2f2;
	
	public EmpMenuBtn(EmpMenuBtnEnum embe) throws IOException {
		super(new ImageIcon(ImageIO.read(new File(embe.imgPath)).getScaledInstance(IMG_WIDTH, IMG_HEIGHT, Image.SCALE_SMOOTH)));
		super.setBackground(new Color(COLOR));
		super.addActionListener(new EmpMenuClickListener(embe));
	}
	
	public EmpMenuBtn() {
		super.setBackground(new Color(COLOR));
	}
	
}
