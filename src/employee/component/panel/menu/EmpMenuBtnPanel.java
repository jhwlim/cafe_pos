package employee.component.panel.menu;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.font.SidePanelTitleLabelFont;
import employee.component.button.menu.EmpMenuBtn;
import employee.component.button.menu.EmpMenuBtnEnum;

public class EmpMenuBtnPanel extends JPanel {

	public static final Color BG_COLOR = new Color(0xffffff);
	
	private static EmpMenuBtnPanel panel; 
	
	static {
		panel = new EmpMenuBtnPanel();
	}
	
	private EmpMenuBtnPanel() {
		setDefaultConfig();
		setComponents();
	}
	
	public static EmpMenuBtnPanel getInstance() {
		if (panel == null) {
			panel = new EmpMenuBtnPanel();
			
		}
		
		return panel;
	}
	
	private void setDefaultConfig() {
		setLayout(new FlowLayout());
		setBackground(BG_COLOR);
	}
	
	private void setComponents() {
		JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labelPanel.setPreferredSize(new Dimension(200, EmpMenuBtn.BTN_HEIGHT + 30));
		labelPanel.setBackground(BG_COLOR);
		add(labelPanel);
		
		JLabel label = new JLabel("직원 관리");
		label.setFont(new SidePanelTitleLabelFont()); 
		labelPanel.add(label);
		
		for (EmpMenuBtnEnum embe : EmpMenuBtnEnum.values()) {
			try {
				JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
				btnPanel.setBackground(BG_COLOR);
				btnPanel.setPreferredSize(new Dimension(200, EmpMenuBtn.BTN_HEIGHT + 10));
				add(btnPanel);
				
				JButton button = new EmpMenuBtn(embe);
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
