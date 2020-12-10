package employee.component.panel.search;

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

public class EmpSearchTopPanel extends JPanel {
	
	public static final int WIDTH = 0;
	public static final int HEIGHT = 100;
	
	private static EmpSearchTopPanel panel;
	
	static {
		panel = new EmpSearchTopPanel();
	}
	
	private EmpSearchTopPanel() {
		setDefaultConfig();
	}
	
	private void setDefaultConfig() {
		setBackground(new Color(EmpSearchCenterPanel.COLOR));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(new BorderLayout());
		
		setComponents();
	}
	
	private void setComponents() {
		JPanel SearchPanel = new JPanel();
		SearchPanel.setBackground(new Color(EmpSearchCenterPanel.COLOR));
		SearchPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		add(SearchPanel, BorderLayout.SOUTH);
		
		
		JButton btn = new EmpNameSearchBtn();
		SearchPanel.add(btn);
		
		JTextField textField = new JTextField();
		textField.setPreferredSize(new Dimension(200, 25));
		SearchPanel.add(textField);
	}
	
	public static EmpSearchTopPanel getInstance() {
		if (panel == null) {
			panel = new EmpSearchTopPanel();
		}
		return panel;
	}
	
	
}
