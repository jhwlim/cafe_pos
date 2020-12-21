package orderlist.dao;

import java.util.List;

import common.model.OrderVO;
import common.model.OrdersDetailVO;

public interface OrderListDao {
	
	public List<OrdersDetailVO> selectByOrderId(int orderId);
	
	public List<OrderListCategoryDto> countByOrderIdGroupByCategory(int orderId);
}
