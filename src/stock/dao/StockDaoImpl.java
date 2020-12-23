package stock.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

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
	public List<StockVO> selectAll(String name) {
		List<StockVO> list = new ArrayList<StockVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("select stock_id,stocks.menu_id,store_id,amount,in_date,maker,menu_name "
					+ "from stocks inner join menus on stocks.menu_id = menus.menu_id and menu_name LIKE '%'||?||'%' "
					+ "WHERE store_id = ? "
					+ "ORDER BY stock_id");
			pstmt.setString(1, name);
			pstmt.setInt(2, StoreConfig.getStoreId());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				StockVO stock = new StockVO(rs.getInt("stock_id"),
											rs.getInt("menu_id"),
											rs.getInt("store_id"),
											rs.getInt("amount"),
											rs.getString("in_date"),
											rs.getString("maker"),
											rs.getString("menu_name"));
				list.add(stock);
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

	@Override
	public void insert(StockVO stock) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO stocks(stock_id,menu_id, store_id, amount, maker) "
					+ "VALUES(STOCK_SEQ.nextval,?,?,?,?)");
			pstmt.setObject(1, stock.getMenuId());
			pstmt.setObject(2, stock.getStoreId());
			pstmt.setObject(3, stock.getAmount());
			pstmt.setObject(4, stock.getMaker());
			
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
