package orderlist.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.component.button.MenuBtnEnum;
import main.component.panel.ContentPanel;
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
//		panel.setLayout(new CardLayout(X_MARGIN, Y_MARGIN));
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.white);

		OrderListPanel orderListPanel1 = new OrderListPanel();
		OrderListPanel2 orderListPanel2 = new OrderListPanel2();
		OrderListPanel3 orderListPanel3 = new OrderListPanel3();
		OrderListPanel4 orderListPanel4 = new OrderListPanel4();

//		JFrame temp = new OrderListFrame();
//		temp.add(orderListPanel1);
//		panel.add(orderListPanel);

		// 날짜 시간
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA);
		Date currentTime = new Date();
		String dTime = formatter.format(currentTime);

		JLabel time = new JLabel("현재 시간 : " + String.valueOf(dTime));

		JPanel top_Panel = new OrderListTopPanel("주문대기 확인");

		top_Panel.add(time);
		// 테이블수 받아서 구현 해야함

		JPanel cen_Panel = new OrderListCenterPanel();
		JPanel left_Panel = new OrderListSidePanel();
		JPanel right_Panel = new OrderListSidePanel();

		JPanel bot_Panel = new OrderListBottomPanel();

		JButton btn_Prev = new OrderListButton("이전으로");
		JButton btn_Next = new OrderListButton("다음으로");

		panel.add(top_Panel, BorderLayout.NORTH);
		panel.add(cen_Panel, BorderLayout.CENTER);

		panel.add(left_Panel, BorderLayout.WEST);
		panel.add(right_Panel, BorderLayout.EAST);
		panel.add(bot_Panel, BorderLayout.SOUTH);

		cen_Panel.setLayout(new GridLayout(0, 2, 50, 50));
		cen_Panel.add(orderListPanel1);
		cen_Panel.add(orderListPanel2);
		cen_Panel.add(orderListPanel3);
		cen_Panel.add(orderListPanel4);
		bot_Panel.add(btn_Prev);
		bot_Panel.add(btn_Next);

	}

	public OrderListView() {

	}

	public static JPanel getContentPanel() {
		return panel;
	}
}
