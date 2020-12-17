package store.component.panel.save.search;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import employee.component.button.search.EmpNameSearchBtn;
import employee.component.label.register.EmpRegUserImgLabel;
import employee.component.panel.register.EmpRegCenterPanel;
import employee.component.panel.register.EmpRegTopPanel;
import store.component.button.search.StoreAddrSearchBtn;
import store.component.panel.save.StoreSaveCenterPanel;

public class StoreSearchTopPanel extends JPanel {
	
	public static final int COLOR = StoreSaveCenterPanel.COLOR;
	
	public static final int WIDTH = 0;
	public static final int HEIGHT = 40;
	
	private JTextField textField; 
	
	public StoreSearchTopPanel() {
		setDefaultConfig();
	}
	
	private void setDefaultConfig() {
		setBackground(new Color(COLOR));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(new BorderLayout());
		
		setComponents();
	}
	
	private void setComponents() {
		JPanel SearchPanel = new JPanel();
		SearchPanel.setBackground(new Color(COLOR));
		SearchPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		add(SearchPanel, BorderLayout.SOUTH);
		
		JButton btn = new StoreAddrSearchBtn();
		SearchPanel.add(btn);
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(200, 25));
		SearchPanel.add(textField);
	}
	
	public JTextField getKeyword() {
		return textField;
	}
	
}
