package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// 커넥션을 제공한다.
public class CM_ConnectionProvider {
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:apache:commons:dbcp:board");
	}
}
