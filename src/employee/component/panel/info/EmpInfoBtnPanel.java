package employee.component.panel.info;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import employee.component.button.info.CancelBtn;
import employee.component.button.info.DropBtn;
import employee.component.button.info.GoModBtn;
import employee.component.button.info.UpdateBtn;


public class EmpInfoBtnPanel extends JPanel{
	
	private static EmpInfoBtnPanel panel;
	
	public static final int WIDTH = 0;
	public static final int HEIGHT = 100;
	
	public static final int BTN_GAP = 50;
	
	public EmpInfoBtnPanel() {
		panel = this;
		setDefaultConfig();
		setComponents();
	}
	
	private void setDefaultConfig() {
		setBackground(new Color(EmpInfoPanel.COLOR));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		setLayout(new CardLayout(50, (HEIGHT-GoModBtn.HEIGHT)/2));
	}
	
	private void setComponents() {
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, BTN_GAP, 0));
		btnPanel.setBackground(new Color(EmpInfoPanel.COLOR));
		
		JButton dropBtn = new DropBtn();
		btnPanel.add(dropBtn);
		
		JButton modBtn = new GoModBtn();
		btnPanel.add(modBtn);
		
		add("SHOW", btnPanel);
		
		JPanel btnPanel2 = new JPanel();
		btnPanel2.setLayout(new FlowLayout(FlowLayout.CENTER, BTN_GAP, 0));
		btnPanel2.setBackground(new Color(EmpInfoPanel.COLOR));
		
		JButton cancelBtn = new CancelBtn();
		btnPanel2.add(cancelBtn);
		
		JButton updatebtn = new UpdateBtn();
		btnPanel2.add(updatebtn);
		
		add("MOD", btnPanel2);
		
	}
	
	public static EmpInfoBtnPanel getCurrentPanel() {
		return panel;
	}
	
}