package store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import common.config.Configs;
import common.model.EmployeeVO;
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

	@Override
	public StoreVO selectOne(int storeId) {
		StoreVO store = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "SELECT * FROM stores WHERE store_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, storeId);
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				store = new StoreVO(rs.getInt("store_id"),
									   rs.getString("store_name"),
									   rs.getString("store_addr"),
									   rs.getInt("store_size"),
									   rs.getInt("store_type"));
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
		
		return store;
	}

	@Override
	public List<StoreVO> searchByAddr(String keyword) {
		List<StoreVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "SELECT * FROM stores WHERE store_addr LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				StoreVO store = new StoreVO(rs.getInt("store_id"),
											rs.getString("store_name"),
											rs.getString("store_addr"),
											rs.getInt("store_size"),
											rs.getInt("store_type"));
				
				list.add(store);
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
		
		return list;
	}
	
}
