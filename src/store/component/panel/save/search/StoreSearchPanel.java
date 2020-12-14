package store.component.panel.save.search;

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
import store.common.config.StoreConfig;
import store.component.label.add.StoreAddStoreImgLabel;
import store.component.panel.add.center.StoreAddCenterPanel;
import store.component.panel.save.StoreSaveCenterPanel;
import store.dao.StoreDao;
import store.dao.StoreDaoImpl;

public class StoreSearchPanel extends JPanel {
		
	private static StoreSearchCenterPanel centerPanel;
	
	public StoreSearchPanel() {
		setDefaultConfig();
		setComponents();
	}
	
	private void setDefaultConfig() {
		setBackground(new Color(StoreSaveCenterPanel.COLOR));
		setLayout(new CardLayout(50, 0));
	}
	
	private void setComponents() {
		centerPanel = new StoreSearchCenterPanel();
		add(centerPanel);
	}
	
	public static StoreSearchCenterPanel getSearchCenterPanel() {
		return centerPanel;
	}
	
}
