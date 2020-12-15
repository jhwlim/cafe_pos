package test;

import java.util.List;

import common.model.OrderVO;
import common.model.OrdersDetailVO;

public interface OrderDao {
	
	public void insert(List<OrdersDetailVO> details);
	
}
