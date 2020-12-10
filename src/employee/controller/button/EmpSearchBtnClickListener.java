package employee.controller.button;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import common.model.EmployeeVO;
import employee.component.panel.search.EmpSearchCenterPanel;
import employee.component.panel.search.EmpSearchResultPanel;
import employee.dao.EmployeeDao;
import employee.dao.EmployeeDaoImpl;

public class EmpSearchBtnClickListener implements ActionListener {

	static Container container;
	
	static {
		container = EmpSearchCenterPanel.getResultPanel();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		EmployeeDao dao = EmployeeDaoImpl.getInstance();
		List<EmployeeVO> employees = dao.searchByName("");
		
		container = new EmpSearchResultPanel(employees);
	}

}
