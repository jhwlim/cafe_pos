package orderlist.dao;

import java.util.List;

import common.model.OrderVO;
import common.model.OrdersDetailVO;

public interface OrderListDao {
	
	public void insert(List<OrdersDetailVO> details);
	
}
