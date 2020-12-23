package order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import common.config.Configs;
import common.model.StockVO;
import store.common.config.StoreConfig;

public class StockDaoImpl implements StockDao {

private static StockDao dao;
	
	static HikariConfig config;
	static HikariDataSource ds;
	
	static {
		config = new HikariConfig(Configs.getHikariConfigPath());
		ds = new HikariDataSource(config);
		dao = new StockDaoImpl();
	}
	
	private StockDaoImpl() {
	}
	
	public static StockDao getInstance() {
		if (dao == null) {
			dao = new StockDaoImpl();
		}
		return dao;
	}
	
	@Override
	public int selectAmountOfMenu(int menuId) {
		int totalAmount = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("SELECT SUM(amount) FROM stocks WHERE menu_id = ? AND store_id = ?");
			pstmt.setInt(1, menuId);
			pstmt.setInt(2, StoreConfig.getStoreId());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				totalAmount = rs.getInt(1);
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
		return totalAmount;
	}

}
