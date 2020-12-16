package orderlist.component.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.table.AbstractTableModel;

import common.model.OrdersDetailVO;
import orderlist.common.config.OrderListConfig;
import store.component.panel.save.info.StoreInfoFieldEnum;

public class OrderListTable extends AbstractTableModel {

	static String[] fieldNames = {
			"주문번호", 
			"메뉴번호", 
			"메뉴이름", 
			"주문수량", 
			"주문시간", 
			"버튼"
	};

	List<OrdersDetailVO> list; 
	
	public OrderListTable() {
		list = OrderListConfig.getList();
	}
	
	@Override
	public String getColumnName(int column) {
		return fieldNames[column];
	}
	
	
	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public int getColumnCount() {
		return fieldNames.length;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		switch (fieldNames[columnIndex]) {
		case "주문번호" :
			return list.get(rowIndex).getOrderId();
		case "메뉴이름" :
			return list.get(rowIndex).getMenuName();
		case "메뉴번호" :
			return list.get(rowIndex).getMenuId();
		case "주문수량" :
			return list.get(rowIndex).getMenuCount();
		case "주문시간" :
			return list.get(rowIndex).getOrderDate();
		case "버튼" :
			JCheckBox checkbox = new JCheckBox();
			
			JButton btn = new JButton("버튼");
//			btn.doClick();
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("클릭됨");
				}
			});
			
			return checkbox;
		}
		
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 5) {
//			return "버튼".getClass();
			return JCheckBox.class;
		} else {
			return getValueAt(0, columnIndex).getClass();			
		}
	}
}
