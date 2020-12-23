package order.controller.button.bottom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import order.component.Label.OrderLbBasic;
import order.component.button.OrderBtnClose;
import order.component.button.OrderBtnPayOk;
import order.component.frame.OrderPayFrame;
import order.component.panel.OrderPayBottomPanel;
import order.component.panel.OrderPayCenterPanel;
import order.component.panel.OrderPayTopPanel;
import order.controller.button.pay.OrderPayNoBtnClickListener;
import order.controller.button.pay.OrderPayOkBtnClickListener;

public class OrderPayBtnClickOpenFrameListener implements ActionListener {

	JTable table;
	JTable table2;
	JScrollPane jsp2;

	public OrderPayBtnClickOpenFrameListener(JTable table, JTable table2, JScrollPane jsp2) {
		this.table = table;
		this.table2 = table2;
		this.jsp2 = jsp2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame subFr = new OrderPayFrame("결제");

		JPanel top_panel = new OrderPayTopPanel("결제 페이지");
		JPanel bot_panel = new OrderPayBottomPanel();
		JPanel cen_panel = new OrderPayCenterPanel();

		JButton btn_ok = new OrderBtnPayOk("결제");
		JButton btn_no = new OrderBtnClose("취소", subFr);

		int total_price = 0;
		int total_su = 0;

		for (int j = 0; j < table.getRowCount(); j++) {

			total_price += (int) table.getValueAt(j, 2) * (int) table.getValueAt(j, 3);

			total_su += (int) table.getValueAt(j, 3);

		}

		if (total_price == 0) {
			JOptionPane.showMessageDialog(null, "선택된 상품이 없습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			subFr.dispose();
		}

		JTableHeader tableHeader2 = table2.getTableHeader();
		tableHeader2.setBackground(new Color(0x663300));
		tableHeader2.setForeground(new Color(0xffffff));

		jsp2.getViewport().setBackground(new Color(0xFFFFE9));

		jsp2.setPreferredSize(new Dimension(550, 150));

		JLabel total_pri = new OrderLbBasic("결제금액: " + String.valueOf(total_price) + "원 ");
		JLabel total_ea = new OrderLbBasic("총 개수: " + String.valueOf(total_su) + "개");

		subFr.add(top_panel, BorderLayout.NORTH);

		cen_panel.add(jsp2);

		cen_panel.add(total_pri);
		cen_panel.add(total_ea);

		subFr.add(cen_panel, FlowLayout.CENTER);
		subFr.add(bot_panel, BorderLayout.SOUTH);

		bot_panel.add(btn_ok);
		bot_panel.add(btn_no);

		btn_ok.addActionListener(new OrderPayOkBtnClickListener(table2, subFr));
		btn_no.addActionListener(new OrderPayNoBtnClickListener(subFr));
	}

}
