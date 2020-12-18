package orderlist.common.config;

import java.util.LinkedList;
import java.util.List;

import common.model.OrdersDetailVO;

public class OrderListConfig {
	
	private static List<OrdersDetailVO> orderDetailList;
	
	static {
		orderDetailList = new LinkedList<>();
	}
	
	public static List<OrdersDetailVO> getList() {
		return orderDetailList;
	}
	
	public static void setList(List<OrdersDetailVO> list) {
		orderDetailList = list;
	}
}
