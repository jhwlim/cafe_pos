package orderlist.component.panel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import common.model.OrdersDetailVO;
import orderlist.component.table.OrderListTable;
import orderlist.component.table.OrderListTableRenderer;
import orderlist.dao.OrderDao;
import orderlist.dao.OrderDaoImpl;

public class OrderListPanel extends JPanel {
	
	public OrderListPanel() {
		setDefaultConfig();
		setComponents();
	}
	
	public void setDefaultConfig() {
		setLayout(new BorderLayout());
	}
	
	public void setComponents() {
		JPanel titlePanel = new JPanel();
		titlePanel.setPreferredSize(new Dimension(0, 100));
		titlePanel.setBackground(Color.cyan);
		add(titlePanel, BorderLayout.NORTH);
		
		//////////////////////
		titlePanel.setLayout(new BorderLayout());
		
		
		
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
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderDao dao = OrderDaoImpl.getInstance();
				dao.insert(list);
			}
		});
		
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.yellow);
		add(centerPanel);
		
//		JPanel subPanel = new JPanel(new CardLayout());
//		centerPanel.add(subPanel);
//		subPanel.setBackground(Color.white);
		
		JTable table = new JTable(new OrderListTable());
		
		table.getColumn("버튼").setCellRenderer(new OrderListTableRenderer());
		table.getColumn("버튼").setCellEditor(new DefaultCellEditor(new JCheckBox()));
		
//		table.getColumn("버튼").setCellRenderer(new OrderListTableRenderer());
//		table.setSize(500, 500);
		for (int i = 0; i < table.getColumnCount()-1; i++) {
			if (i != 2) {
				TableColumn col = table.getColumnModel().getColumn(i);
				int width = 20;
				col.setPreferredWidth(width);
			}
			
		}
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(500, 400));
		centerPanel.add(scroll);
		
	}
	
	
}
