package employee.controller.button.search;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import common.model.EmployeeVO;
import employee.component.panel.search.EmpSearchCenterPanel;
import employee.component.panel.search.EmpSearchResultPanel;
import employee.component.panel.search.EmpSearchTopPanel;
import employee.dao.EmployeeDao;
import employee.dao.EmployeeDaoImpl;
import employee.view.EmpSearchView;

public class EmpSearchBtnClickListener implements ActionListener {

	static EmpSearchResultPanel container;
	static EmpSearchCenterPanel parentContainer;
	static EmpSearchTopPanel topPanel;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		parentContainer = EmpSearchView.getSearchCenterPanel();
		container = parentContainer.getResultPanel();
		topPanel = parentContainer.getTopPanel();
		
		container.setVisible(false);
		parentContainer.remove(container);
		
		EmployeeDao dao = EmployeeDaoImpl.getInstance();
		List<EmployeeVO> employees = dao.searchByName(topPanel.getKeyword().getText());
		
		EmpSearchResultPanel newPanel = new EmpSearchResultPanel(employees);
		parentContainer.setResultPanel(newPanel);
		
		parentContainer.add(newPanel, BorderLayout.CENTER);
		
	}

}
