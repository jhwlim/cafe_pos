package test;

import java.util.ArrayList;
import java.util.List;

import common.model.OrderVO;
import common.model.OrdersDetailVO;

public class OrderDaoTest {

	public static void main(String[] args) {
		
		OrderDao dao = OrderDaoImpl.getInstance();
		
		List<OrdersDetailVO> details = new ArrayList<OrdersDetailVO>();
		
		for (int i = 0; i < 10; i++) {
			OrdersDetailVO detail = new OrdersDetailVO();
			detail.setMenuId(41 + i);
			detail.setMenuCount((int) (Math.random()*5));
			detail.setDiscountedCost(0);
			details.add(detail);
		}
		
		dao.insert(details);
		
		System.out.println("테스트 완료");
		
	}
}
