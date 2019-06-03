package com.woniuxy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.management.RuntimeErrorException;


public class JdbcUtils {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql:///test";
	private static String user = "root";
	private static String pwd = "123456";
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}		
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user,  pwd);		
	}
	
	public static void free(ResultSet rs,java.sql.Statement stmt,Connection conn) {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}finally {
				try {
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}			
	}
}
