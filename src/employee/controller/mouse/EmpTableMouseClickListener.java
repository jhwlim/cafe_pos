package employee.controller.mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import common.model.EmployeeVO;
import employee.component.frame.EmpInfoFrame;
import employee.dao.EmployeeDao;
import employee.dao.EmployeeDaoImpl;

public class EmpTableMouseClickListener extends MouseAdapter {
	
	JTable table;
	
	public EmpTableMouseClickListener(JTable table) {
		this.table = table;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			int row = table.getSelectedRow();
			int col = 0;
			
			EmployeeDao dao = EmployeeDaoImpl.getInstance();
			EmployeeVO employee = dao.selectOne((int) table.getValueAt(row, col));
			new EmpInfoFrame(employee);
		}
		
	}
	
	

}
