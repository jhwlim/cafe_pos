package main.component.panel.menu.side;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import common.model.StoreVO;
import main.component.button.MenuBtn;
import store.common.config.StoreConfig;
import store.dao.StoreDao;
import store.dao.StoreDaoImpl;

public class MainMenuSideCenterPanel extends JPanel {
	
	private static MainMenuSideCenterPanel panel;
	
	private static final int GRID_ROW_NUM = 4;
	private static final int GRID_COL_NUM = 1;
	
	static {
		panel = new MainMenuSideCenterPanel();
	}
	
	private MainMenuSideCenterPanel() {
		setDefaultConfig();
		setComponents();
	}
	
	private void setDefaultConfig() {
		setLayout(new GridLayout(GRID_ROW_NUM, GRID_COL_NUM, 0, 5));		
		setBackground(Color.white);
	}
	
	private void setComponents() {
		StoreDao dao = StoreDaoImpl.getInstance();
		StoreVO store = dao.selectOne(StoreConfig.getStoreId());
		
		add(new MainMenuSideLabelPanel("매장번호", String.valueOf(store.getStoreId())));
		add(new MainMenuSideLabelPanel("매장명", store.getStoreName()));
		add(new MainMenuSideLabelPanel("매장주소", store.getStoreAddr()));
		
	}
	
	public void update() {
		removeAll();
		setComponents();
	}
	
	public static MainMenuSideCenterPanel getInstance() {
		return panel;
	}
}
