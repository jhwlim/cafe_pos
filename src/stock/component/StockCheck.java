package stock.component;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import common.config.Configs;
import stock.view.Stockview;

public class StockCheck extends JPanel{
	public static JButton searchBtn1;
	public static JTextField search1;
	
	static HikariConfig config;
	static HikariDataSource ds;
	
	static {
		config = new HikariConfig(Configs.getHikariConfigPath());
		ds = new HikariDataSource(config);
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public StockCheck() {
		this.setLayout(new CardLayout());
		this.setLayout(null);
		
		
		JLabel stockCheck = new JLabel("재고 확인");
		this.add(stockCheck);
		stockCheck.setBounds(450, 0, 100, 100);
		
		
		//기본 재고 테이블
		DefaultTableModel model;
		String header[] = {"재고번호","메뉴번호","매장번호","재고 수량","입고 일자","제조사","메뉴 이름"};
		Object ob[][] = {};
		model = new DefaultTableModel(ob,header);
		JTable table = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);
		this.add(scrollpane);
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
		
		//검색 눌렀을때 해당 결과만 보여줄 테이블
		search1 = new JTextField(20);
		this.add(search1);
		search1.setBounds(650, 100,200,40);
		
		searchBtn1 = new JButton("검색");
		this.add(searchBtn1);
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
		
		JButton backBtn1 = new JButton("뒤로가기");
		this.add(backBtn1);
		backBtn1.setBounds(800, 700, 100, 100);
		backBtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel thisPanel = Stockview.stockMain;
				((CardLayout) thisPanel.getLayout()).show(thisPanel, "stockMenu");
			}
		});
		
	}
}
