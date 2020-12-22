package stock.component;


import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import common.config.Configs;
import common.model.StockVO;
import stock.component.StockCheck;
import stock.dao.StockDao;
import stock.dao.StockDaoImpl;
import store.common.config.StoreConfig;

public class StockPanel extends JPanel{
	
	public static JPanel btn1Panel;
		
	public StockPanel() {
		this.setLayout(new CardLayout());
		
		JPanel stockMenuPanel = new JPanel();
		stockMenuPanel.setLayout(null);
		
		JLabel label1 = new JLabel("재고관리 페이지");
	    label1.setBounds(425, 100, 200, 200); 
	    stockMenuPanel.add(label1);
		
		JButton btn1 = new JButton("재고 확인");
		btn1.setBounds(300, 400, 100, 100);
		stockMenuPanel.add(btn1);
		
		JButton btn2 = new JButton("발주");
		btn2.setBounds(550, 400, 100, 100);
		stockMenuPanel.add(btn2);
		
		this.add("stockMenu", stockMenuPanel);
		
		JPanel thisPanel = this;	
		
		//--------------------------- 재고 페이지 --------------------------
		btn1Panel = new StockCheck();
		this.add("1", btn1Panel);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "1");
			}
		});
	
		//------------------- 발주 페이지 --------------------------------
		JPanel btn2Panel = new JPanel();
		this.add("2", btn2Panel);
		btn2Panel.setLayout(null);
		
		JLabel storeOrder = new JLabel("발주 페이지");
		btn2Panel.add(storeOrder);
		storeOrder.setBounds(450, 0, 100, 100);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "2");
			}
		});
		
		//윗쪽에 띄울 기본 재고 테이블
		DefaultTableModel model2;
		String header2[] = {"재고번호","메뉴번호","매장번호","재고 수량","입고 일자","제조사","메뉴 이름"};
		Object ob2[][] = {};
		model2 = new DefaultTableModel(ob2,header2);
		JTable table2 = new JTable(model2);
		JScrollPane scrollpane2 = new JScrollPane(table2);
		btn2Panel.add(scrollpane2);
		scrollpane2.setBounds(50, 200,900,200);
		
		// 테이블을 수정할 수 없도록 추가
		table2.setDefaultEditor(Object.class, null);
		
		StockDao dao = StockDaoImpl.getInstance();
		
		List<StockVO> list = dao.selectAll("");
		
		for (int i = 0; i < list.size(); i++) {
			StockVO stock = list.get(i);
			Object data[] = {stock.getStockId(),
						     stock.getMenuId(),
						     stock.getStoreId(),
						     stock.getAmount(),
						     stock.getDate(),
						     stock.getMaker(),
						     stock.getMenuName()};
			model2.addRow(data);
		}
		
		
		//여기까지
    	
		// 윗쪽 재고테이블 검색시 해당 내용만 나오는 테이블
		JTextField search2 = new JTextField(20);
		btn2Panel.add(search2);
		search2.setBounds(650, 100,200,40);
		
		JButton searchBtn2 = new JButton("검색");
		btn2Panel.add(searchBtn2);
		searchBtn2.setBounds(850, 100, 60, 40);
		
		
		
		searchBtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model2.setRowCount(0); // 기존 테이블의 행을 모두 삭제
				
				String name = search2.getText();

				List<StockVO> list = dao.selectAll(name);
				
				for (int i = 0; i < list.size(); i++) {
					StockVO stock = list.get(i);
					Object data[] = {stock.getStockId(),
								     stock.getMenuId(),
								     stock.getStoreId(),
								     stock.getAmount(),
								     stock.getDate(),
								     stock.getMaker(),
								     stock.getMenuName()};
					model2.addRow(data);
				}
			}
		});
		// 여기까지
		
		/////////발주 테이블
		DefaultTableModel model3;
		String header3[] = {"메뉴 번호","매장 번호","제조사", "발주 수량"};
		Object ob3[][] = {};
		
		// 추가
		model3 = new DefaultTableModel(ob3,header3) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 3; // true라면 수정이됨.
			}
		};
		
		JTable table3 = new JTable(model3);
		JScrollPane scrollpane3 = new JScrollPane(table3);
		btn2Panel.add(scrollpane3);
		scrollpane3.setBounds(50, 500,900,200);
		
		// 재고 페이지 - 상단 뷰
		table2.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1 && e.getClickCount() >= 2) {
					
					int row = (int) table2.getSelectedRow();
					
					int col1 = 1;
					Object menuId = table2.getValueAt(row, col1);
					
					int col2 = 2;
					Object storeId = table2.getValueAt(row, col2);
					
					int col3 = 5;
					Object maker = table2.getValueAt(row, col3);
					// 상단 테이블의 값을 가져오는 코드 ↑
					
					// 하단 테이블에 row 추가할 때 중복되면 추가가 안되도록 하는 코드 ↓
					boolean flag = true;
					
					for (int i = 0; i < table3.getRowCount(); i++) {
						Object menuId2 = table3.getValueAt(i, 0);
						Object storeId2 = table3.getValueAt(i, 1);
						Object maker2 = table3.getValueAt(i, 2);
						// 만약에 하단 테이블에 이미 메뉴번호와 제조사가 같은게 존재한다면 플래그를 false
						if (menuId.equals(menuId2)
								&& storeId.equals(storeId2) && maker.equals(maker2)) {
							flag = false;
							break;
						}
					}
					
					// 플래그가 false = 하단 테이블에 이미 메뉴번호와 제조사가 있다면 -> 실행이 안됨.
					if (flag) {
						((DefaultTableModel) table3.getModel()).addRow(new Object[] {menuId,storeId,maker, ""});						
					}
				}
			}
		});
		
		table3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1 && e.getClickCount() >= 2) {
					int row = (int) table3.getSelectedRow();
					
					((DefaultTableModel) table3.getModel()).removeRow(row);
				}
			}
		});
			
		// 발주 시 해당 재고 업데이트 기능 
		JButton orderBtn = new JButton("발주 넣기");
		btn2Panel.add(orderBtn);
		orderBtn.setBounds(200, 800, 100, 100);
		orderBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Object orderMenuId = table3.getModel().getValueAt(0, 0);
				Object orderStoreId = table3.getModel().getValueAt(0, 1);
				Object orderMaker = table3.getModel().getValueAt(0, 2);
				Object orderNum = table3.getModel().getValueAt(0, 3);
				
				StockVO stock = new StockVO();
				stock.setMenuId(Integer.parseInt(orderMenuId.toString()));
				stock.setStoreId(Integer.parseInt(orderStoreId.toString()));
				stock.setMaker(orderMaker.toString());
				stock.setAmount(Integer.parseInt(orderNum.toString()));
				
				StockDao dao = StockDaoImpl.getInstance();
				
				dao.insert(stock);
				
				JOptionPane.showMessageDialog(orderBtn, "발주 완료!");
				//searchBtn1.doClick();
				searchBtn2.doClick();
			}
		});
		//여기까지
		
		JButton backBtn2 = new JButton("뒤로가기");
		btn2Panel.add(backBtn2);
		backBtn2.setBounds(700, 800, 100, 100);
		backBtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "stockMenu");
			}
		});
		
	}
	
	

}
