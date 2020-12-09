package employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import common.config.Configs;
import common.model.EmployeeVO;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private static EmployeeDao dao;
	
	static HikariConfig config;
	static HikariDataSource ds;
	
	static {
		config = new HikariConfig(Configs.getHikariConfigPath());
		ds = new HikariDataSource(config);
		dao = new EmployeeDaoImpl();
	}
	
	private EmployeeDaoImpl() {
	}
	
	public static EmployeeDao getInstance() {
		if (dao == null) {
			dao = new EmployeeDaoImpl();
		}
		return dao;
	}
	
	@Override
	public void insert(EmployeeVO employee) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "INSERT INTO employees(emp_id, emp_name, emp_birth, emp_rank, emp_nick, certif_expire_date, store_id) "
					+ "VALUES (emp_seq.nextval, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employee.getEmpName());
			pstmt.setString(2, employee.getEmpBirth());
			pstmt.setInt(3, employee.getEmpRank());
			pstmt.setString(4, employee.getEmpNick());
			pstmt.setString(5, employee.getCertifExpireDate());
			
			if (employee.getStoreId() == -1) {
				pstmt.setString(6, null);
			} else {
				pstmt.setInt(6, employee.getStoreId());
			}
			
			pstmt.executeUpdate();
			
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
	}

	@Override
	public void searchByName(String keyword) {
		// TODO Auto-generated method stub
		
	}
	
}
