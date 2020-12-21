package order.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import common.config.Configs;
import common.model.OrderVO;
import common.model.OrdersDetailVO;
import orderlist.common.config.OrderListConfig;
import store.common.config.StoreConfig;
import store.dao.StoreDao;
import store.dao.StoreDaoImpl;

public class OrderDaoImpl implements OrderDao {

	private static OrderDao dao;
	
	static HikariConfig config;
	static HikariDataSource ds;
	
	static {
		config = new HikariConfig(Configs.getHikariConfigPath());
		ds = new HikariDataSource(config);
		dao = new OrderDaoImpl();
	}
	
	private OrderDaoImpl() {
	}
	
	public static OrderDao getInstance() {
		if (dao == null) {
			dao = new OrderDaoImpl();
		}
		return dao;
	}
	
	@Override
	public void insert(List<OrdersDetailVO> details) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;		
		ResultSet rs = null;
		
		int generatedKey = -1;
		
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO orders(order_id, store_id) "
					+ "VALUES (order_seq.nextval, ?)";
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, StoreConfig.getStoreId());
			
			pstmt.executeUpdate();

			String sql2 = "SELECT order_seq.currval from dual";
			pstmt2 = conn.prepareStatement(sql2);
			
			pstmt2.executeUpdate();

			rs = pstmt2.executeQuery();
		
			if (rs.next()) {
				generatedKey = rs.getInt(1);
			}
			OrderListConfig.getList().add(generatedKey);
			
			String sql3 = "INSERT INTO orders_detail(order_id, menu_id, menu_count, discounted_cost) "
					+ "VALUES (?, ?, ?, ?)";
			pstmt3 = conn.prepareStatement(sql3);
			
			for (int i = 0; i < details.size(); i++) {
				OrdersDetailVO detail = details.get(i);
				pstmt3.setInt(1, generatedKey);
				pstmt3.setInt(2, detail.getMenuId());
				pstmt3.setInt(3, detail.getMenuCount());
				pstmt3.setInt(4, detail.getDiscountedCost());
				pstmt3.executeUpdate();
				
			}

			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (pstmt3 != null) pstmt3.close();
				if (pstmt2 != null) pstmt2.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

	
	
}
