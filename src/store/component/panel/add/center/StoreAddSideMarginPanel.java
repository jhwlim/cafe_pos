package store.component.panel.add.center;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class StoreAddSideMarginPanel extends JPanel {
	
	private static final int WIDTH = 90;
	private static final int HEIGHT = 0;
	
	public StoreAddSideMarginPanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(new Color(StoreAddCenterPanel.COLOR));
	}
	
	public StoreAddSideMarginPanel(int width, int height) {
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(new Color(StoreAddCenterPanel.COLOR));
	}
	
}
