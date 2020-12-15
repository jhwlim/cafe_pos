package employee.controller.button.info;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import common.model.EmployeeVO;
import employee.component.panel.info.EmpInfoShowPanel;
import employee.dao.EmployeeDao;
import employee.dao.EmployeeDaoImpl;

public class EmpInfoDropBtnClickListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Container container = EmpInfoShowPanel.getCurrentPanel();
		int empId = ((EmpInfoShowPanel) container).getEmployee().getEmpId();
		
		EmployeeDao dao = EmployeeDaoImpl.getInstance();
		dao.delete(empId);
		
		((JFrame) container.getParent().getParent().getParent().getParent().getParent().getParent().getParent()).dispose();
	}
	
}
