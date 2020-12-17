package orderlist.component.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class OrderListTitlePanel extends JPanel {

	public static final Color PANEL_COLOR = OrderListPanel.PANEL_COLOR;
	
	public static final int WIDHT = 0;
	public static final int HEIGHT = 80;
	
	public OrderListTitlePanel() {
		setDefaultConfig();
		setComponents();
	}
	
	public void setDefaultConfig() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setBackground(PANEL_COLOR);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}
	
	public void setComponents() {
		JLabel label = new JLabel();
		label.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		label.setText("대기 주문 목록");
		label.setForeground(Color.white);
		label.setVerticalAlignment(JLabel.CENTER);
		add(label);
		
		/*
		 * 테스트 코드 : 결재 버튼 구현시 참고
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(2, 2));
		inputPanel.add(new JLabel("메뉴번호"));
		JTextField menuId = new JTextField();
		inputPanel.add(menuId);
		
		inputPanel.add(new JLabel("수량"));
		JTextField menuCount = new JTextField();
		inputPanel.add(menuCount);
		titlePanel.add(inputPanel, BorderLayout.CENTER);
		
		JButton addBtn = new JButton("추가");
		titlePanel.add(addBtn, BorderLayout.WEST);
		
		List<OrdersDetailVO> list = new ArrayList<>();
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OrdersDetailVO detail = new OrdersDetailVO();
				detail.setMenuId(Integer.parseInt(menuId.getText()));
				detail.setMenuCount(Integer.parseInt(menuCount.getText()));
				list.add(detail);
			}
		});
		
		JButton btn = new JButton("결제");
		titlePanel.add(btn, BorderLayout.EAST);
		
		btn.addActionListener(new OrderBtnClickListener(list));
	
		*/
	}
}
