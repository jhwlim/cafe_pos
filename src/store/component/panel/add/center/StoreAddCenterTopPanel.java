package store.component.panel.add.center;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JPanel;

import employee.component.label.register.EmpRegUserImgLabel;
import store.component.label.add.StoreAddStoreImgLabel;

public class StoreAddCenterTopPanel extends JPanel {
	
	private static StoreAddCenterTopPanel panel;
	
	public static final int WIDTH = 0;
	public static final int HEIGHT = 250;
	
	static {
		panel = new StoreAddCenterTopPanel();
	}
	
	private StoreAddCenterTopPanel() {
		setDefaultConfig();
	}
	
	private void setDefaultConfig() {
		setBackground(new Color(StoreAddCenterPanel.COLOR));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(new CardLayout());
		
		setComponents();
	}
	
	private void setComponents() {
		try {
			this.add(new StoreAddStoreImgLabel());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static StoreAddCenterTopPanel getInstance() {
		if (panel == null) {
			panel = new StoreAddCenterTopPanel();
		}
		return panel;
	}
}
