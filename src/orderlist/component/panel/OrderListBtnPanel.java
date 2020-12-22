package orderlist.component.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import orderlist.common.config.OrderListConfig;
import orderlist.dao.OrderListCategoryVO;
import orderlist.dao.OrderListDao;
import orderlist.dao.OrderListDaoImpl;
import orderlist.view.OrderListView;

public class OrderListBtnPanel extends JPanel {
	
	static OrderListDao dao = OrderListDaoImpl.getInstance();
	
	public OrderListBtnPanel(int index) {
		setLayout(new BorderLayout());
		
		int orderId = OrderListConfig.getList().get(index);
		
		List<OrderListCategoryVO> list = dao.countByOrderIdGroupByCategory(orderId);
		
		int drinkCnt = 0;
		int foodCnt = 0;
		int mdCnt = 0;
		
		for (int i = 0; i < list.size(); i++) {
			String category = list.get(i).getMenuCategory();
			switch (category) {
			case "drink":
				drinkCnt = list.get(i).getCount();
				break;
			case "food":
				foodCnt = list.get(i).getCount();
				break;
			case "md":
				mdCnt = list.get(i).getCount();
				break;
			default:
				break;
			}
		}
		
		StringBuilder text = new StringBuilder();
		text.append("    음료 " + drinkCnt
					+ "    푸드 " + foodCnt
					+ "    MD " + mdCnt);
		
		JLabel menuCntLabel = new JLabel(text.toString());
		menuCntLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		add(menuCntLabel, BorderLayout.CENTER);
		
		JButton btn = new JButton("완료");
		btn.setPreferredSize(new Dimension(80, 50));
		btn.setBackground(new Color(0x663300));
		btn.setForeground(new Color(0xffffff));
		btn.setFont(new Font("야놀자야체", Font.BOLD, 20));
		add(btn, BorderLayout.EAST);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderListConfig.getList().remove(index);
				new OrderListView();
			}
		});
	}
}
