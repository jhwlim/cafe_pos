package employee.component.label.register;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import employee.component.panel.register.EmpRegTopPanel;

public class EmpRegUserImgLabel extends JLabel {
	
	static String imgPath;
	
	static final int HEIGHT = (int) (EmpRegTopPanel.HEIGHT * 0.8);
	static final int WIDTH = HEIGHT;
	
	
	static {
		imgPath = "resources/img/employee/register/user.png";
	}
	
	public EmpRegUserImgLabel() throws IOException {
		super(new ImageIcon(ImageIO.read(new File(imgPath)).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH)));
	}
	
}
