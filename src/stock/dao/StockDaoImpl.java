package stock.dao;

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
import common.model.StockVO;
import orderlist.common.config.OrderListConfig;
import store.common.config.StoreConfig;
import store.dao.StoreDao;
import store.dao.StoreDaoImpl;

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
	public void insert(StockVO stock) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "INSERT INTO\r\n"
					+ "    stocks (stock_id, menu_id, store_id, amount, maker)\r\n"
					+ "VALUEs\r\n"
					+ "    (stock_seq.nextval, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, stock.getMenuId());
			pstmt.setInt(2, StoreConfig.getStoreId());
			pstmt.setInt(3, stock.getAmount());
			pstmt.setString(4, stock.getMaker());
			
			pstmt.executeUpdate();

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
	}
	
	
	
}
