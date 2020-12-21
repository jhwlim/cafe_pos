package orderlist.dao;

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

public class OrderListDaoImpl implements OrderListDao {

	private static OrderListDao dao;
	
	static HikariConfig config;
	static HikariDataSource ds;
	
	static {
		config = new HikariConfig(Configs.getHikariConfigPath());
		ds = new HikariDataSource(config);
		dao = new OrderListDaoImpl();
	}
	
	private OrderListDaoImpl() {
	}
	
	public static OrderListDao getInstance() {
		if (dao == null) {
			dao = new OrderListDaoImpl();
		}
		return dao;
	}
	
	@Override
	public List<OrdersDetailVO> selectByOrderId(int orderId) {
		List<OrdersDetailVO> list = new ArrayList<OrdersDetailVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			
			Timestamp orderDate = null;
			
			String sql2 = "SELECT order_date FROM orders WHERE order_id = ?";
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, orderId);
			
			rs = pstmt2.executeQuery();
			if (rs.next()) {
				orderDate = rs.getTimestamp(1);
			}
			
			String sql = "SELECT orders_detail.*, menus.menu_name\r\n"
					+ "FROM orders_detail \r\n"
					+ "INNER JOIN menus\r\n"
					+ "ON orders_detail.menu_id = menus.menu_id "
					+ "WHERE order_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, orderId);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrdersDetailVO detail = new OrdersDetailVO();
				detail.setMenuId(rs.getInt("menu_id"));
				detail.setOrderId(rs.getInt("order_id"));
				detail.setMenuCount(rs.getInt("menu_count"));
				detail.setMenuName(rs.getString("menu_name"));
				detail.setOrderDate(orderDate);
				list.add(detail);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return list;
	}

	@Override
	public List<OrderListCategoryVO> countByOrderIdGroupByCategory(int orderId) {
		List<OrderListCategoryVO> list = new ArrayList<OrderListCategoryVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "SELECT \r\n"
					+ "    menu_category, SUM(menu_count) as count\r\n"
					+ "FROM\r\n"
					+ "    orders_detail\r\n"
					+ "    INNER JOIN menus\r\n"
					+ "    ON orders_detail.menu_id = menus.menu_id\r\n"
					+ "WHERE\r\n"
					+ "    order_id = ?\r\n"
					+ "GROUP BY\r\n"
					+ "    menu_category";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderId);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderListCategoryVO dto = new OrderListCategoryVO(
						rs.getString("menu_category"), 
						rs.getInt("count"));
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return list;
	}
	
}
