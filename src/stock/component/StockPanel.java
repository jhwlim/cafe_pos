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

public class StockPanel extends JPanel{
	
	static HikariConfig config;
	static HikariDataSource ds;
	
	static {
		config = new HikariConfig(Configs.getHikariConfigPath());
		ds = new HikariDataSource(config);
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
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
		
		
		//---------------- 가게 정보 페이지-------------------------
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
		
		//--------------------------- 재고 페이지 --------------------------
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
		
		
		//////////// 기본 재고 테이블
		DefaultTableModel model;
		String header[] = {"재고번호","메뉴번호","매장번호","재고 수량","입고 일자","제조사","메뉴 이름"};
		Object ob[][] = {};
		model = new DefaultTableModel(ob,header);
		JTable table = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);
		btn2Panel.add(scrollpane);
		scrollpane.setBounds(50, 200,900,400);
		
		// 테이블을 수정할 수 없도록 추가
		table.setDefaultEditor(Object.class, null);
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("select stock_id,stocks.menu_id,store_id,amount,in_date,maker,menu_name "
					+ "from stocks inner join menus on stocks.menu_id = menus.menu_id ORDER BY stock_id");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int stockId = rs.getInt("stock_id");
				int menuId = rs.getInt("menu_id");
				int storeId = rs.getInt("store_id");
				int amount = rs.getInt("amount");
				String date = rs.getString("in_date");
				String maker = rs.getString("maker");
				String menuName = rs.getString("menu_name");
				
				Object data[] = {stockId,menuId,storeId,amount,date,maker,menuName};
				model.addRow(data);
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		//여기까지
		
		////////검색 눌렀을때 해당 결과만 보여줄 테이블
		JTextField search1 = new JTextField(20);
		btn2Panel.add(search1);
		search1.setBounds(650, 100,200,40);
		
		JButton searchBtn1 = new JButton("검색");
		btn2Panel.add(searchBtn1);
		searchBtn1.setBounds(850, 100, 60, 40);
		searchBtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);// 기존 테이블의 행을 모두 삭제
				
				String name = search1.getText();
				try {
					conn = ds.getConnection();
					pstmt = conn.prepareStatement("select stock_id,stocks.menu_id,store_id,amount,in_date,maker,menu_name "
							+ "from stocks inner join menus on stocks.menu_id = menus.menu_id and menu_name LIKE '%'||?||'%' "
							+ "ORDER BY stock_id");
					pstmt.setString(1, name);
					rs = pstmt.executeQuery();
					
					while (rs.next()) {
						int stockId = rs.getInt("stock_id");
						int menuId = rs.getInt("menu_id");
						int storeId = rs.getInt("store_id");
						int amount = rs.getInt("amount");
						String date = rs.getString("in_date");
						String maker = rs.getString("maker");
						String menuName = rs.getString("menu_name");
						
						Object data[] = {stockId,menuId,storeId,amount,date,maker,menuName};
						model.addRow(data);
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				} finally {
					try {
						if (rs != null) rs.close();
						if (pstmt != null) pstmt.close();
						if (conn != null) conn.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}
				
			}
		});
		//여기까지
		
		JButton backBtn2 = new JButton("뒤로가기");
		btn2Panel.add(backBtn2);
		backBtn2.setBounds(800, 700, 100, 100);
		backBtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "storeMenu");
			}
		});
		
		
		
		//------------------- 발주 페이지 --------------------------------
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
		
		//윗쪽에 띄울 기본 재고 테이블
		DefaultTableModel model2;
		String header2[] = {"재고번호","메뉴번호","매장번호","재고 수량","입고 일자","제조사","메뉴 이름"};
		Object ob2[][] = {};
		model2 = new DefaultTableModel(ob2,header2);
		JTable table2 = new JTable(model2);
		JScrollPane scrollpane2 = new JScrollPane(table2);
		btn3Panel.add(scrollpane2);
		scrollpane2.setBounds(50, 200,900,200);
		
		// 테이블을 수정할 수 없도록 추가
		table2.setDefaultEditor(Object.class, null);
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("select stock_id,stocks.menu_id,store_id,amount,in_date,maker,menu_name "
					+ "from stocks inner join menus on stocks.menu_id = menus.menu_id ORDER BY stock_id");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int stockId = rs.getInt("stock_id");
				int menuId = rs.getInt("menu_id");
				int storeId = rs.getInt("store_id");
				int amount = rs.getInt("amount");
				String date = rs.getString("in_date");
				String maker = rs.getString("maker");
				String menuName = rs.getString("menu_name");
				
				Object data[] = {stockId,menuId,storeId,amount,date,maker,menuName};
				model2.addRow(data);
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		//여기까지
    	
		// 윗쪽 재고테이블 검색시 해당 내용만 나오는 테이블
		JTextField search2 = new JTextField(20);
		btn3Panel.add(search2);
		search2.setBounds(650, 100,200,40);
		
		JButton searchBtn2 = new JButton("검색");
		btn3Panel.add(searchBtn2);
		searchBtn2.setBounds(850, 100, 60, 40);
		
		
		
		searchBtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model2.setRowCount(0); // 기존 테이블의 행을 모두 삭제
				
				String name = search2.getText();
				try {
					conn = ds.getConnection();
					pstmt = conn.prepareStatement("select stock_id,stocks.menu_id,store_id,amount,in_date,maker,menu_name "
							+ "from stocks inner join menus on stocks.menu_id = menus.menu_id and menu_name LIKE '%'||?||'%' "
							+ "ORDER BY stock_id");
					pstmt.setString(1, name);
					rs = pstmt.executeQuery();
					
					while (rs.next()) {
						int stockId = rs.getInt("stock_id");
						int menuId = rs.getInt("menu_id");
						int storeId = rs.getInt("store_id");
						int amount = rs.getInt("amount");
						String date = rs.getString("in_date");
						String maker = rs.getString("maker");
						String menuName = rs.getString("menu_name");
						
						Object data[] = {stockId,menuId,storeId,amount,date,maker,menuName};
						model2.addRow(data);
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				} finally {
					try {
						if (rs != null) rs.close();
						if (pstmt != null) pstmt.close();
						if (conn != null) conn.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
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
		btn3Panel.add(scrollpane3);
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
		
		//여기까지
		
		
		
		
		
		// 발주 시 해당 재고 업데이트 기능 
		JButton orderBtn = new JButton("발주 넣기");
		btn3Panel.add(orderBtn);
		orderBtn.setBounds(200, 800, 100, 100);
		orderBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Object orderMenuId = table3.getModel().getValueAt(0, 0);
					Object orderStoreId = table3.getModel().getValueAt(0, 1);
					Object orderMaker = table3.getModel().getValueAt(0, 2);
					Object orderNum = table3.getModel().getValueAt(0, 3);
					
					conn = ds.getConnection();
					pstmt = conn.prepareStatement("INSERT INTO stocks(stock_id,menu_id, store_id, amount, in_date,maker) "
							+ "VALUES(STOCK_SEQ.nextval,?,?,?,sysdate,?)");
					pstmt.setObject(1, orderMenuId);
					pstmt.setObject(2, orderStoreId);
					pstmt.setObject(3, orderNum);
					pstmt.setObject(4, orderMaker);
					
					pstmt.executeUpdate();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} finally {
					try {
						if (pstmt != null) pstmt.close();
						if (conn != null) conn.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}
				JOptionPane.showMessageDialog(orderBtn, "발주 완료!");
				searchBtn1.doClick();
				searchBtn2.doClick();
			}
		});
		//여기까지
		
		JButton backBtn3 = new JButton("뒤로가기");
		btn3Panel.add(backBtn3);
		backBtn3.setBounds(700, 800, 100, 100);
		backBtn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "storeMenu");
			}
		});
		
	}
	
	

}
