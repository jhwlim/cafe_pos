package store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import common.config.Configs;
import common.model.StoreVO;
import employee.dao.EmployeeDao;
import employee.dao.EmployeeDaoImpl;

public class StoreDaoImpl implements StoreDao {

	private static StoreDao dao;
	
	static HikariConfig config;
	static HikariDataSource ds;
	
	static {
		config = new HikariConfig(Configs.getHikariConfigPath());
		ds = new HikariDataSource(config);
		dao = new StoreDaoImpl();
	}
	
	private StoreDaoImpl() {
	}
	
	public static StoreDao getInstance() {
		if (dao == null) {
			dao = new StoreDaoImpl();
		}
		return dao;
	}
	
	
	@Override
	public void insert(StoreVO store) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "INSERT INTO stores(store_id, store_name, store_addr, store_size, store_type) "
					+ "VALUES (store_seq.nextval, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, store.getStoreName());
			pstmt.setString(2, store.getStoreAddr());
			pstmt.setInt(3, store.getStoreSize());
			pstmt.setInt(4, store.getStoreType());
			
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
