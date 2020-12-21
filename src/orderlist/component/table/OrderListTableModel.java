package orderlist.component.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import common.model.OrdersDetailVO;
import order.dao.OrderDao;
import order.dao.OrderDaoImpl;
import orderlist.common.config.OrderListConfig;

public class OrderListTableModel extends AbstractTableModel {

	static String[] fieldNames = {
			"주문번호", 
			"메뉴번호", 
			"메뉴이름", 
			"주문수량", 
			"주문시간"
	};

	static OrderDao dao = OrderDaoImpl.getInstance();
	
	List<OrdersDetailVO> list; 
	
	
	public OrderListTableModel(int orderId) {
		this.list = dao.selectByOrderId(orderId);
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
		return columnIndex == 5;
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
		}
		
		return null;
	}

}
