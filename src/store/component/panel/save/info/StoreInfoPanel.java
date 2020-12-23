package store.component.panel.save.info;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;

import common.model.StoreVO;
import employee.component.label.register.EmpRegUserImgLabel;
import main.component.panel.content.SidePanel;
import store.common.config.StoreConfig;
import store.component.label.add.StoreAddStoreImgLabel;
import store.component.panel.add.center.StoreAddCenterPanel;
import store.dao.StoreDao;
import store.dao.StoreDaoImpl;

public class StoreInfoPanel extends JPanel {
		
	public static final int WIDTH = 0;
	public static final int HEIGHT = 400;
	
	public static final int X_MARGIN = 130;
	public static final int Y_MARGIN = 50;
	
//	public static final int COLOR = 0xf0e6bd;
	public static final Color BG_COLOR = new Color(0x186f3d);
	
	public StoreInfoPanel() {
		setDefaultConfig();
		setComponents();
	}
	
	private void setDefaultConfig() {
		setBackground(new Color(StoreAddCenterPanel.COLOR));
		setBackground(BG_COLOR);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
	}
	
	private void setComponents() {
		
		StoreDao dao = StoreDaoImpl.getInstance();
		StoreVO store = dao.selectOne(StoreConfig.getStoreId());
		
		if (store == null) {
			setLayout(new BorderLayout());
			JLabel label = new JLabel("매장 정보가 등록되지 않았습니다.");
			label.setFont(new Font("맑은 고딕", Font.BOLD, 40));
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setForeground(Color.white);
			add(label);
		} else {
			setLayout(new CardLayout(X_MARGIN, Y_MARGIN));
			
			JPanel infoPanel = new JPanel(new BorderLayout(0, 5));
			infoPanel.setBackground(Color.black);
			
			JLabel title = new JLabel("현재 매장 정보");
			title.setFont(new Font("맑은 고딕", Font.BOLD, 28));
			title.setHorizontalAlignment(JLabel.CENTER);
			title.setForeground(Color.white);
			
			infoPanel.add(title, BorderLayout.NORTH);
			
			StoreInfoFieldPanel fieldPanel = StoreInfoFieldPanel.getInstance();
			infoPanel.add(fieldPanel, BorderLayout.WEST);
	
			StoreInfoShowPanel showPanel = new StoreInfoShowPanel(store);
			infoPanel.add(showPanel, BorderLayout.CENTER);
			
			add(infoPanel);
		}
		
	}
	

}
