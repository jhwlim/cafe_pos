package employee.dao;

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
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public List<EmployeeVO> searchByName(String keyword) {
		List<EmployeeVO> list = new ArrayList<EmployeeVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "SELECT * FROM employees WHERE emp_name LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmployeeVO employee = new EmployeeVO(rs.getInt("emp_id"), 
													 rs.getString("emp_name"), 
													 rs.getString("emp_birth"), 
													 rs.getInt("emp_rank"), 
													 rs.getString("emp_nick"), 
													 rs.getDate("join_date"), 
													 rs.getString("certif_expire_date"), 
													 rs.getInt("store_id"));
				list.add(employee);
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
	public EmployeeVO selectOne(int empId) {
		EmployeeVO employee = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "SELECT * FROM employees WHERE emp_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				employee = new EmployeeVO(rs.getInt("emp_id"), 
													 rs.getString("emp_name"), 
													 rs.getString("emp_birth"), 
													 rs.getInt("emp_rank"), 
													 rs.getString("emp_nick"), 
													 rs.getDate("join_date"), 
													 rs.getString("certif_expire_date"), 
													 rs.getInt("store_id"));
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
		
		return employee;
	}

	@Override
	public void delete(int empId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "DELETE FROM employees WHERE emp_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empId);
			
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
	public void update(EmployeeVO employee) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "UPDATE employees SET "
					+ "emp_name = ?, emp_birth = ?, emp_rank = ?, emp_nick = ?, certif_expire_date = ?, store_id = ?"
					+ "WHERE emp_id = ?";
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
			pstmt.setInt(7, employee.getEmpId());
			
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
