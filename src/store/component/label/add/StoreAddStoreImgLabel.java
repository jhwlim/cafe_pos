package store.component.label.add;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import employee.component.panel.register.EmpRegTopPanel;
import store.component.panel.add.center.StoreAddCenterTopPanel;

public class StoreAddStoreImgLabel extends JLabel {
	
	static String imgPath;
	
	static final int HEIGHT = (int) (StoreAddCenterTopPanel.HEIGHT * 0.8);
	static final int WIDTH = HEIGHT;
	
	
	static {
		imgPath = "resources/img/store/add/store.png";
	}
	
	public StoreAddStoreImgLabel() throws IOException {
		super(new ImageIcon(ImageIO.read(new File(imgPath)).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH)));
	}
	
}
