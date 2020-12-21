package orderlist.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.component.button.MenuBtnEnum;
import main.component.panel.ContentPanel;
import orderlist.common.config.OrderListConfig;
import orderlist.component.button.OrderListButton;
import orderlist.component.frame.OrderListFrame;
import orderlist.component.panel.OrderListBottomPanel;
import orderlist.component.panel.OrderListCenterPanel;
import orderlist.component.panel.OrderListPanel;
import orderlist.component.panel.OrderListPanel2;
import orderlist.component.panel.OrderListPanel3;
import orderlist.component.panel.OrderListPanel4;
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
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA);
		Date currentTime = new Date();
		String dTime = formatter.format(currentTime);
		System.out.println(dTime);
		JLabel time = new JLabel("현재 시간 : " + String.valueOf(dTime));
		System.out.println(time.getText());
		System.out.println(time.getComponentCount());
		
		JPanel top_Panel = new OrderListTopPanel("주문대기 확인");

		top_Panel.add(time);
	
		// 테이블수 받아서 구현 해야함
		JPanel cardPanel = new JPanel(new CardLayout());
		
		JPanel cen_Panel = new OrderListCenterPanel();
//		cen_Panel.setLayout(new GridLayout(0, 2, 50, 50));
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
		
		int cardPageLastNum = (int) Math.ceil(list.size() / 4) + 1;
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
