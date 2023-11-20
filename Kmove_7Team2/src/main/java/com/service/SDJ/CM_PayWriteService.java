package com.service.SDJ;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.connection.CM_ConnectionProvider;

import com.dao.SDJ.CM_PayDao;
import com.dbcp.util.CM_JDBCUtil;
import com.model.PJS.CM_EmpPayData;

public class CM_PayWriteService {
	private static CM_PayWriteService instance = new CM_PayWriteService();

	private CM_PayWriteService() {
	}

	public static CM_PayWriteService getInstance() {
		return instance;
	}

	public CM_EmpPayData getEmpData(String empNo, String date) {
		Connection conn = null;
		try {
			// 커넥션 받아오기
			conn = CM_ConnectionProvider.getConnection();
			// 트랜잭션 off
			conn.setAutoCommit(false);
			return CM_PayDao.getInstance().getData(conn, date, empNo);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			CM_JDBCUtil.close(conn);
		}
	}

	public void updatePay(CM_EmpPayData data, String date, String empNo) {
		Connection conn = null;
		try {
			conn = CM_ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			CM_PayDao.getInstance().update(conn, data, date, empNo);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
