package com.service.PJS;

import java.sql.Connection;
import java.sql.SQLException;

import com.connection.CM_ConnectionProvider;
import com.dao.PJS.CM_AllPayDao;
import com.dbcp.util.CM_JDBCUtil;
import com.model.PJS.CM_AllMonthPay;
import com.model.PJS.CM_AllYearPay;

public class CM_AllPayService {
	private static CM_AllPayService instance = new CM_AllPayService();

	private CM_AllPayService() {

	}

	public static CM_AllPayService getInstance() {
		return instance;
	}

	public CM_AllYearPay getAllreadData(int year) {
		Connection conn = null;
		try {
			// 커넥션 받아오기
			conn = CM_ConnectionProvider.getConnection();
			// 트랜잭션 off
			conn.setAutoCommit(false);
			return CM_AllPayDao.getInstance().readAllYearPay(conn, year);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			CM_JDBCUtil.close(conn);
		}
	}

	public CM_AllMonthPay getMonthPayData(int month) {
		Connection conn = null;
		try {
			// 커넥션 받아오기
			conn = CM_ConnectionProvider.getConnection();
			// 트랜잭션 off
			conn.setAutoCommit(false);
			return CM_AllPayDao.getInstance().getMonthPayData(month, conn);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			CM_JDBCUtil.close(conn);
		}
	}
}
