package com.dbcp.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// 커넥션을 위한 보조 기능이다
public class CM_JDBCUtil {
	
	public static void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static void close(Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	public static void rollback(Connection conn) {
		if(conn!=null) {
			try {
				conn.rollback();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
