package order.controller.button.pay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import common.model.OrdersDetailVO;
import order.dao.OrderDao;
import order.dao.OrderDaoImpl;
import order.view.OrderView;
import store.common.config.StoreConfig;

public class OrderPayOkBtnClickListener implements ActionListener {

	JTable table2;
	JFrame subFr;
	
	public OrderPayOkBtnClickListener(JTable table2, JFrame subFr) {
		this.table2 = table2;
		this.subFr = subFr;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int storeId = StoreConfig.getStoreId();
			
		if (storeId == StoreConfig.DEFAULT_STORE_ID) {
			JOptionPane.showMessageDialog(null, "매장 정보가 등록되어 있지 않습니다.", "경고",
					JOptionPane.WARNING_MESSAGE);
		} else {
			List<OrdersDetailVO> list = new ArrayList<OrdersDetailVO>();
			
			for (int i = 0; i < table2.getRowCount(); i++) {
				OrdersDetailVO detail = new OrdersDetailVO();
				detail.setMenuId((int) table2.getValueAt(i, 0));
				detail.setMenuCount((int) table2.getValueAt(i, 3));
				list.add(detail);
			
			}
			
			if (list.size() == 0) {
				JOptionPane.showMessageDialog(null, "선택된 상품이 없습니다.", "경고",
						JOptionPane.WARNING_MESSAGE);
			} else {
				OrderDao dao = OrderDaoImpl.getInstance();
				dao.insert(list);
				OrderView.btn_clear.doClick();
			}
			
			subFr.dispose();
		}
	}
	
}
