package orderlist.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.component.button.MenuBtnEnum;
import main.component.panel.content.ContentPanel;
import orderlist.common.config.OrderListConfig;
import orderlist.component.button.OrderListButton;
import orderlist.component.panel.OrderListBottomPanel;
import orderlist.component.panel.OrderListCenterPanel;
import orderlist.component.panel.OrderListPanel;
import orderlist.component.panel.OrderListSidePanel;
import orderlist.component.panel.OrderListTopPanel;

public class OrderListView {

	public static JPanel panel;

	static final int X_MARGIN = 200;
	static final int Y_MARGIN = 200;

	static {
		panel = ContentPanel.getPanel(MenuBtnEnum.ORDERLIST);
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.white);	
	}

	public OrderListView() {
		panel.removeAll();

		// 날짜 시간
		JPanel top_Panel = new OrderListTopPanel("주문대기 확인");

		JLabel time2 = new OrderListTime();
		
		top_Panel.add(time2);
		
		JPanel cardPanel = new JPanel(new CardLayout());
		
		JPanel cen_Panel = new OrderListCenterPanel();
		cardPanel.add("0", cen_Panel);
		
		JPanel left_Panel = new OrderListSidePanel();
		JPanel right_Panel = new OrderListSidePanel();

		JPanel bot_Panel = new OrderListBottomPanel();
		JButton btn_Prev = new OrderListButton("이전으로");
		JButton btn_Next = new OrderListButton("다음으로");

		panel.add(top_Panel, BorderLayout.NORTH);
		panel.add(cardPanel, BorderLayout.CENTER);

		panel.add(left_Panel, BorderLayout.WEST);
		panel.add(right_Panel, BorderLayout.EAST);
		panel.add(bot_Panel, BorderLayout.SOUTH);
	
		List<Integer> list = OrderListConfig.getList();
		JLabel waiting_bill = new JLabel("대기 목록 총 개수 : " + list.size());
		waiting_bill.setForeground(Color.white);
		waiting_bill.setFont(new Font("야놀자야체", Font.BOLD, 25));
		
		top_Panel.add(waiting_bill);
		
		int cardPageLastNum = 1;
		if (list.size() > 0) {			
			cardPageLastNum = list.size() % 4 == 0 ? (int) Math.ceil(list.size() / 4) : (int) Math.ceil(list.size() / 4) + 1;
		}
		
		JPanel nowCardPanel = cen_Panel;
		for (int i = 0; i < cardPageLastNum * 4; i++) {
			if (i > 0 && i % 4 == 0) {
				nowCardPanel = new OrderListCenterPanel();
				cardPanel.add(String.valueOf(i/4), nowCardPanel);
			}
			
			JPanel orderListPanel;
			if (i < list.size()) {
				orderListPanel = new OrderListPanel(list.get(i), i);;				
			} else {
				orderListPanel = new JPanel();
			}
			nowCardPanel.add(orderListPanel);
			
		}

		bot_Panel.add(btn_Prev);
		bot_Panel.add(btn_Next);
		
		btn_Prev.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) cardPanel.getLayout()).previous(cardPanel);
			}
		});
		
		btn_Next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) cardPanel.getLayout()).next(cardPanel);
			}
		});
		
		panel.revalidate();
		panel.repaint();
	}

	public static JPanel getContentPanel() {
		return panel;
	}
}
