package order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import common.config.Configs;
import common.model.MenuVO;

public class MenuDaoImpl implements MenuDao {
	
	private static MenuDaoImpl dao;
	
	static HikariConfig config;
	static HikariDataSource ds;
	
	static {
		config = new HikariConfig(Configs.getHikariConfigPath());
		ds = new HikariDataSource(config);
		dao = new MenuDaoImpl();
	}
	
	private MenuDaoImpl() {
	}
	
	public static MenuDaoImpl getInstance() {
		if (dao == null) {
			dao = new MenuDaoImpl();
		}
		return dao;
	}

	@Override
	public List<MenuVO> selectAll() {
		List<MenuVO> list = new ArrayList<MenuVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "SELECT * FROM menus";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MenuVO menu = new MenuVO(rs.getInt("menu_id"), 
									     rs.getString("menu_name"),
										 rs.getInt("menu_cost"),
										 rs.getString("menu_category"),
										 rs.getString("menu_img"));
				list.add(menu);
			}
			
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
		

		return list;
	}
	

	@Override
	public List<String> selectByCategory(String category) {
		List<String> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "SELECT menu_img FROM menus WHERE menu_category = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String imgPath = rs.getString("menu_img");
				list.add(imgPath);
			}
			
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
		
		return list;
	}
	
	@Override
	public List<MenuVO> selectAllByCategory(String category) {
		List<MenuVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "SELECT * FROM menus WHERE menu_category = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MenuVO menu = new MenuVO(rs.getInt("menu_id"),
										 rs.getString("menu_name"),
										 rs.getInt("menu_cost"),
										 rs.getString("menu_category"),
										 rs.getString("menu_img"));
				list.add(menu);
			}
			
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
		
		return list;
	}
}
