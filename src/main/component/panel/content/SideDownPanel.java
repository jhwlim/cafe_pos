package main.component.panel.content;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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

import common.component.button.RoundImgBtn;
import main.component.button.SidePanelBtn;
import main.controller.btn.MainBtnClickListener;
import main.view.MainView;

public class SideDownPanel extends JPanel {
	
	static SideDownPanel sideDownPanel;
	
	public static final int PANEL_WIDTH = SidePanel.SIDEPANEL_WIDTH;
	public static final int PANEL_HEIGHT = 80;
	
//	public static final Color BG_COLOR = SidePanel.BG_COLOR;
	public static final Color BG_COLOR = new Color(0x663300);
	
	private static final int IMG_SIZE = 60;
	
	static {
		sideDownPanel = new SideDownPanel();
		
		sideDownPanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		sideDownPanel.setLayout(new CardLayout(10, 10));
		sideDownPanel.setBackground(BG_COLOR);
		
		setComponents();
	}
	
	private SideDownPanel() {
	}

	public static SideDownPanel getInstance() {
		if (sideDownPanel == null) {
			sideDownPanel = new SideDownPanel();
			setComponents();
			
		}
		
		
		return sideDownPanel;
	}

	private static void setComponents() {
		JPanel subPanel = new JPanel(new BorderLayout());
		subPanel.setBackground(BG_COLOR);
		sideDownPanel.add(subPanel);
		try {
			JButton backBtn = new JButton(new ImageIcon(ImageIO.read(new File("resources/img/main/back.png")).getScaledInstance(IMG_SIZE, IMG_SIZE, Image.SCALE_SMOOTH)));
			backBtn.setPreferredSize(new Dimension(IMG_SIZE, IMG_SIZE));
			backBtn.setBackground(Color.white);
			backBtn.setBorder(BorderFactory.createEmptyBorder());
			subPanel.add(backBtn, BorderLayout.WEST);
			
			backBtn.addActionListener(new MainBtnClickListener());
			
			JButton btn = new JButton(new ImageIcon(ImageIO.read(new File("resources/img/main/exit.png")).getScaledInstance(IMG_SIZE, IMG_SIZE, Image.SCALE_SMOOTH)));
			btn.setPreferredSize(new Dimension(IMG_SIZE, IMG_SIZE));
			btn.setBackground(Color.white);
			btn.setBorder(BorderFactory.createEmptyBorder());
			subPanel.add(btn, BorderLayout.EAST);
			
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
//		JButton mainBtn = new SidePanelBtn("뒤로가기");
//		mainBtn.addActionListener(new MainBtnClickListener());
//		
//		sideDownPanel.add(mainBtn);
//		
	}
	
}
