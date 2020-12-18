package store.controller.mouse.search;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import common.model.EmployeeVO;
import common.model.StoreVO;
import employee.component.frame.EmpInfoFrame;
import employee.dao.EmployeeDao;
import employee.dao.EmployeeDaoImpl;
import store.component.frame.StoreSaveChkFrame;
import store.dao.StoreDao;
import store.dao.StoreDaoImpl;

public class StoreTableMouseClickListener extends MouseAdapter {
	
	JTable table;
	
	public StoreTableMouseClickListener(JTable table) {
		this.table = table;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			int row = table.getSelectedRow();
			int col = 0;
			
			StoreDao dao = StoreDaoImpl.getInstance();
			new StoreSaveChkFrame(dao.selectOne((int) table.getValueAt(row, col)).getStoreId());
		}
		
	}
	
	

}
