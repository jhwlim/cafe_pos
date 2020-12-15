package employee.controller.button.info;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import employee.component.panel.info.EmpInfoBtnPanel;
import employee.component.panel.info.EmpInfoCenterPanel;

public class EmpInfoCancelBtnClickListener implements ActionListener {

	
	@Override
	public void actionPerformed(ActionEvent e) {
		Container container = EmpInfoCenterPanel.getCurrentPanel();
		((CardLayout) container.getLayout()).show(container, "SHOW");
		
		container = EmpInfoBtnPanel.getCurrentPanel();
		((CardLayout) container.getLayout()).show(container, "SHOW");
		
	}
	
}
