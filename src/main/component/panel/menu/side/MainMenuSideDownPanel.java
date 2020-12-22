package main.component.panel.menu.side;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.component.frame.MainFrame;
import main.view.MainView;

public class MainMenuSideDownPanel extends JPanel {
	
	private static final int IMG_SIZE = 80;
	
	private static MainMenuSideDownPanel panel;
	
	static {
		panel = new MainMenuSideDownPanel();
	}
	
	private MainMenuSideDownPanel() {
		setDefaultConfig();
		setComponents();
	}
	
	private void setDefaultConfig() {
//		setBackground(MainMenuSidePanel.COLOR);
//		setBackground(Color.white);
		setLayout(new FlowLayout(FlowLayout.RIGHT));
	}
	
	private void setComponents() {
		try {
			JButton btn = new JButton(new ImageIcon(ImageIO.read(new File("resources/img/main/exit.png")).getScaledInstance(IMG_SIZE, IMG_SIZE, Image.SCALE_SMOOTH)));
			btn.setPreferredSize(new Dimension(IMG_SIZE, IMG_SIZE));
//			btn.setBackground(MainMenuSidePanel.COLOR);
//			btn.setBackground(Color.white);
			btn.setBorder(BorderFactory.createEmptyBorder());
			add(btn);
			
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame frame = MainView.getMainFrame();
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static MainMenuSideDownPanel getInstance() {
		if (panel == null) {
			panel = new MainMenuSideDownPanel();
		}
		
		return panel;
	}
	
	
}
