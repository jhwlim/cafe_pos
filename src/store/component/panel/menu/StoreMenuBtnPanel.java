package store.component.panel.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.font.SidePanelTitleLabelFont;
import store.component.button.menu.StoreMenuBtn;
import store.component.button.menu.StoreMenuBtnEnum;

public class StoreMenuBtnPanel extends JPanel {

	public static final Color BG_COLOR = new Color(0xffffff);
	
	private static StoreMenuBtnPanel panel; 
	
	static {
		panel = new StoreMenuBtnPanel();
		
	}
	
	private StoreMenuBtnPanel() {
		setDefaultConfig();
		setComponents();
	}
	
	public static StoreMenuBtnPanel getInstance() {
		if (panel == null) {
			panel = new StoreMenuBtnPanel();
		}
		
		return panel;
	}
	
	private void setDefaultConfig() {
		setLayout(new FlowLayout());
		setBackground(BG_COLOR);
	}
	
	private void setComponents() {
		
		JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labelPanel.setPreferredSize(new Dimension(200, StoreMenuBtn.BTN_HEIGHT + 30));
		labelPanel.setBackground(BG_COLOR);
		add(labelPanel);
		
		JLabel label = new JLabel("매장관리");
		label.setFont(new SidePanelTitleLabelFont()); 
		labelPanel.add(label);
		
		for (StoreMenuBtnEnum smb : StoreMenuBtnEnum.values()) {
			try {
				JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
				btnPanel.setBackground(BG_COLOR);
				btnPanel.setPreferredSize(new Dimension(200, StoreMenuBtn.BTN_HEIGHT + 10));
				add(btnPanel);
				
				JButton button = new StoreMenuBtn(smb);
				btnPanel.add(button);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		JPanel imgPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		imgPanel.setBackground(BG_COLOR);
		add(imgPanel);
		
		try {
			JLabel imglabel = new JLabel(new ImageIcon(ImageIO.read(new File("resources/img/design/img1.jpg")).getScaledInstance(220, 220, Image.SCALE_SMOOTH)));
			imgPanel.add(imglabel);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
