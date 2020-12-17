package orderlist.controller.order;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import common.model.OrdersDetailVO;
import orderlist.dao.OrderListDao;
import orderlist.dao.OrderListDaoImpl;

public class OrderBtnClickListener implements ActionListener {

	List<OrdersDetailVO> list;
	
	public OrderBtnClickListener(List<OrdersDetailVO> list) {
		this.list = list;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		OrderListDao dao = OrderListDaoImpl.getInstance();
		dao.insert(list);
	}
	
	
}
