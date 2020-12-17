package store.controller.button.search;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import common.model.EmployeeVO;
import common.model.StoreVO;
import employee.component.panel.search.EmpSearchCenterPanel;
import employee.component.panel.search.EmpSearchResultPanel;
import employee.component.panel.search.EmpSearchTopPanel;
import employee.dao.EmployeeDao;
import employee.dao.EmployeeDaoImpl;
import employee.view.EmpSearchView;
import store.component.panel.save.search.StoreSearchCenterPanel;
import store.component.panel.save.search.StoreSearchPanel;
import store.component.panel.save.search.StoreSearchResultPanel;
import store.component.panel.save.search.StoreSearchTopPanel;
import store.dao.StoreDao;
import store.dao.StoreDaoImpl;

public class StoreSearchBtnClickListener implements ActionListener {

	static StoreSearchResultPanel container;
	static StoreSearchCenterPanel parentContainer;
	static StoreSearchTopPanel topPanel;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		parentContainer = StoreSearchPanel.getSearchCenterPanel();
		container = parentContainer.getResultPanel();
		topPanel = parentContainer.getTopPanel();
		
		container.setVisible(false);
		parentContainer.remove(container);
		
		StoreDao dao = StoreDaoImpl.getInstance();
		List<StoreVO> stores = dao.searchByAddr(topPanel.getKeyword().getText());
		
		StoreSearchResultPanel newPanel = new StoreSearchResultPanel(stores);
		parentContainer.setResultPanel(newPanel);
		
		parentContainer.add(newPanel, BorderLayout.CENTER);
		
	}

}
