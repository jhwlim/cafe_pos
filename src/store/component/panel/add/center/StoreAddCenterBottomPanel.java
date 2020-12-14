package store.component.panel.add.center;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import employee.component.button.register.CancelBtn;
import employee.component.button.register.SubmitBtn;

public class StoreAddCenterBottomPanel extends JPanel {
	
	private static StoreAddCenterBottomPanel panel;
	
	public static final int WIDTH = 0;
	public static final int HEIGHT = 100;
	
	public static final int BTN_GAP = 50;
	
	static {
		panel = new StoreAddCenterBottomPanel();
	}
	
	private StoreAddCenterBottomPanel() {
		setDefaultConfig();
	}
	
	private void setDefaultConfig() {
		setBackground(new Color(StoreAddCenterPanel.COLOR));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		setLayout(new CardLayout(50, (HEIGHT-SubmitBtn.HEIGHT)/2));
		
		setComponents();
	}
	
	private void setComponents() {
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, BTN_GAP, 0));
		btnPanel.setBackground(new Color(StoreAddCenterPanel.COLOR));
		
		JButton cancelBtn = new CancelBtn();
		btnPanel.add(cancelBtn);
		
		JButton submitBtn = new SubmitBtn();
		btnPanel.add(submitBtn);
		
		add(btnPanel);
	}
	
	public static StoreAddCenterBottomPanel getInstance() {
		if (panel == null) {
			panel = new StoreAddCenterBottomPanel();
		}
		return panel;
	}
}
