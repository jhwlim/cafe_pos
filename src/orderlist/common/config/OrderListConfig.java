package orderlist.common.config;

import java.util.LinkedList;
import java.util.List;

import common.model.OrdersDetailVO;

public class OrderListConfig {
	
	
	private static List<Integer> orderIdList;
	
	static {
		orderIdList = new LinkedList<>();
	}
	
	public static List<Integer> getList() {
		return orderIdList;
	}
	
	public static void setList(List<Integer> list) {
		orderIdList = list;
	}
}
