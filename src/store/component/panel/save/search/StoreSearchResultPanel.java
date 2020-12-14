package store.component.panel.save.search;

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
import common.model.StoreVO;
import employee.component.table.EmpSearchResultTable;
import employee.controller.mouse.EmpTableMouseClickListener;
import store.component.table.StoreSearchResultTable;

public class StoreSearchResultPanel extends JPanel {
	
	List<StoreVO> list;
	
	static AbstractTableModel model;
	
	public StoreSearchResultPanel(List<StoreVO> list) {
		this.list = list;
		
		setDefaultConfig();
		setComponents(list);
	}
	
	private void setDefaultConfig() {
		setBackground(Color.white);
		setLayout(new CardLayout());
	}
	
	private void setComponents(List<StoreVO> list) {
		if (list == null) {
			list = new ArrayList<StoreVO>();
		}
		model = new StoreSearchResultTable(list);
		JTable table = new JTable(model);
		add(new JScrollPane(table));
		
		table.addMouseListener(new EmpTableMouseClickListener(table));
	}
	
	public static AbstractTableModel getTableModel() {
		return model;
	}
}
