package stock;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.component.btn.MenuBtnEnum;
import main.component.panel.ContentPanel;
import stock.component.StockPanel;

public class Stockview {

	public static JPanel panel;
	static JButton[] store_1 = new JButton[3];
	static JButton[] store_2 = new JButton[3];
	static JButton[] store_3 = new JButton[3];
	static JButton[] store_btns = new JButton[3];
	
	static {
		panel = ContentPanel.getPanel(MenuBtnEnum.STOCK);// 카드 레이아웃
		
		// panel에 작업하는게 왼쪽 영역에 표시됨.
		panel.setLayout(new CardLayout());
	
		JPanel stackbtnView = new JPanel();
		panel.add("stack page", stackbtnView);
		
		stackbtnView.setLayout(null);
		JLabel label1 = new JLabel("재고관리 페이지");
	    label1.setBounds(400, 100, 200, 200);
	    stackbtnView.add(label1);
	    
	  
	    for (int i = 0; i < 3; i++) {store_btns[i] = new JButton("store"+(i+1));}
	    	
    	store_btns[0].setBounds(400, 300, 100, 100);
    	store_btns[1].setBounds(400, 450, 100, 100);
    	store_btns[2].setBounds(400, 600, 100, 100);
	    
    	
	    for (int j = 0; j < store_btns.length; j++) {stackbtnView.add(store_btns[j]);}
			
	    
	    //----------------store1의 버튼들---------------------
	    for (int i = 0; i < 3; i++) {
	    	
	    }
	    
	    
	    JPanel store1 = new StockPanel();
	    
	    panel.add("store1", store1);
		
		if(store_btns[0] != null) {
			store_btns[0].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					((CardLayout) panel.getLayout()).show(panel, "store1");
					
				}
			});
		}
		//----------------store2의 버튼들---------------------
		JPanel store2 = new StockPanel();
		panel.add("store2", store2);
		
		if(store_btns[1] != null) {
			store_btns[1].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					((CardLayout) panel.getLayout()).show(panel, "store2"); 
				}
			});
		}
		
		//----------------store3의 버튼들---------------------
		JPanel store3 = new StockPanel();
		panel.add("store3", store3);
		
		if(store_btns[2] != null) {
			store_btns[2].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					((CardLayout) panel.getLayout()).show(panel, "store3"); 
				}
			});
		}
		
		/*
		//----------------store1 info---------------------
		JPanel store_info = new JPanel();
		panel.add("store_info", store_info); 
		store_info.setLayout(null);
		
		JLabel s_info_label = new JLabel("store info 페이지");
		s_info_label.setBounds(400, 100, 200, 200);
		
		store_info.add(s_info_label);
		
		if(store_1[0] != null) {
			store_1[0].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					((CardLayout) panel.getLayout()).show(panel, "store_info"); 
				}
			});
		}
		
		JButton back = new JButton("뒤로가기");
		back.setBounds(700, 700, 100, 100);
		store_info.add(back);
		if(back != null) {
			back.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					((CardLayout) panel.getLayout()).show(panel, "store_info"); 
				}
			});
		}
		
		//----------------store1 stock---------------------
		JPanel store_stock = new JPanel();
		panel.add("store_stock", store_stock); 
		store_stock.setLayout(null);
		
		JLabel s_stock_label = new JLabel("재고확인 페이지");
		s_stock_label.setBounds(400, 100, 200, 200);
		store_stock.add(s_stock_label);
		
		if(store_1[1] != null) {
			store_1[1].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					((CardLayout) panel.getLayout()).show(panel, "store_stock"); 
				}
			});
		}
		
		JButton back2 = new JButton("뒤로가기");
		back2.setBounds(700, 700, 100, 100);
		store_stock.add(back2);
		if(back2 != null) {
			back2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					((CardLayout) panel.getLayout()).show(panel, "store_stock"); 
				}
			});
		}
		
		//----------------store1 발주---------------------
		JPanel store_order = new JPanel();
		panel.add("store_order", store_order); 
		store_order.setLayout(null);
		
		JLabel s_order_label = new JLabel("발주 페이지");
		s_order_label.setBounds(400, 100, 200, 200);
		store_order.add(s_order_label);
		
		if(store_1[2] != null) {
			store_1[2].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					((CardLayout) panel.getLayout()).show(panel, "store_order"); 
				}
			});
		}
		
		JButton back3 = new JButton("뒤로가기");
		back3.setBounds(700, 700, 100, 100);
		store_order.add(back3);
		if(back3 != null) {
			back3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					((CardLayout) panel.getLayout()).show(panel, "store1");  /////////// 수정
				}
			});
		}
		
		
		
		JButton order = new JButton("발주 하기");
		back3.setBounds(350, 700, 100, 100);
		store_order.add(order);
		
		
	    	*/
	}
	
	public Stockview() {
		((CardLayout) panel.getLayout()).show(panel, "stack page"); 
	}
	
}
