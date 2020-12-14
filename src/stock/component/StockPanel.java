package stock.component;


import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StockPanel extends JPanel{
	
	public StockPanel() {
		this.setLayout(new CardLayout());
		
		JPanel storeMenuPanel = new JPanel();
		storeMenuPanel.setLayout(null);
		
		JButton btn1 = new JButton("Store Info");
		btn1.setBounds(200, 400, 100, 100);
		storeMenuPanel.add(btn1);
		
		JButton btn2 = new JButton("재고 확인");
		btn2.setBounds(400, 400, 100, 100);
		storeMenuPanel.add(btn2);
		
		JButton btn3 = new JButton("발주");
		btn3.setBounds(600, 400, 100, 100);
		storeMenuPanel.add(btn3);
		
		this.add("storeMenu", storeMenuPanel);
		
		
		//////// 가게 정보
		JPanel thisPanel = this;
    	
		JPanel btn1Panel = new JPanel();
		this.add("1", btn1Panel);
		btn1Panel.setLayout(null);
		
		JLabel storeInfo = new JLabel("Store Info");
		btn1Panel.add(storeInfo);
		storeInfo.setBounds(450, 0, 100, 100);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "1");
			}
		});
		
		
		JButton backBtn1 = new JButton("뒤로가기");
		btn1Panel.add(backBtn1);
		backBtn1.setBounds(700, 700, 100, 100);
		
		backBtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "storeMenu");
			}
		});
		
		//////// 재고 확인
		JPanel btn2Panel = new JPanel();
		this.add("2", btn2Panel);
		btn2Panel.setLayout(null);
		
		JLabel stockCheck = new JLabel("재고 확인");
		btn2Panel.add(stockCheck);
		stockCheck.setBounds(450, 0, 100, 100);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "2");
			}
		});
		
		JTextField search1 = new JTextField("재고 이름 입력",20);
		btn2Panel.add(search1);
		search1.setBounds(650, 100,200,40);
		
		JButton searchBtn1 = new JButton("검색");
		btn2Panel.add(searchBtn1);
		searchBtn1.setBounds(850, 100, 60, 40);
		searchBtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "");
			}
		});
		
		
		JButton backBtn2 = new JButton("뒤로가기");
		btn2Panel.add(backBtn2);
		backBtn2.setBounds(700, 700, 100, 100);
		backBtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "storeMenu");
			}
		});
		
		///////// 발주
		JPanel btn3Panel = new JPanel();
		this.add("3", btn3Panel);
		btn3Panel.setLayout(null);
		
		JLabel storeOrder = new JLabel("발주 페이지");
		btn3Panel.add(storeOrder);
		storeOrder.setBounds(450, 0, 100, 100);
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "3");
			}
		});
    	
		JTextField search2 = new JTextField("재고 이름 입력",20);
		btn3Panel.add(search2);
		search2.setBounds(650, 100,200,40);
		
		JButton searchBtn2 = new JButton("검색");
		btn3Panel.add(searchBtn2);
		searchBtn2.setBounds(850, 100, 60, 40);
		searchBtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "");
			}
		});
		
		JButton orderBtn = new JButton("발주 넣기");
		btn3Panel.add(orderBtn);
		orderBtn.setBounds(200, 700, 100, 100);
		orderBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "");
			}
		});
		
		JButton backBtn3 = new JButton("뒤로가기");
		btn3Panel.add(backBtn3);
		backBtn3.setBounds(700, 700, 100, 100);
		backBtn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "storeMenu");
			}
		});
		
	}
	
	

}
