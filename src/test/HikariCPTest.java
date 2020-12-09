package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import common.config.Configs;

public class HikariCPTest {

	static HikariConfig config;
	static HikariDataSource ds;
	
	static {
		config = new HikariConfig(Configs.getHikariConfigPath());
		ds = new HikariDataSource(config);
	}
	
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM employees");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.printf("%-20s\t%-10s\t%-10d\t%-10d\n",
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getInt("salary"),
						rs.getInt("department_id")
						);
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
	}
}
