package employee.component.panel.search;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import common.model.EmployeeVO;
import employee.component.table.EmpSearchResultTable;

public class EmpSearchResultPanel extends JPanel {
	
	List<EmployeeVO> list;
	
	
	public EmpSearchResultPanel(List<EmployeeVO> employeeList) {
		this.list = employeeList;
		
		setDefaultConfig();
		setComponents(employeeList);
	}
	
	private void setDefaultConfig() {
		setBackground(Color.white);
		setLayout(new CardLayout());
	}
	
	private void setComponents(List<EmployeeVO> list) {
		if (list == null) {
			list = new ArrayList<EmployeeVO>();
		}
		
		JTable table = new JTable(new EmpSearchResultTable(list));
		add(new JScrollPane(table));
		
	}
	
}
