package com.service.SCE;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.Jdbc41Bridge;

import com.connection.CM_ConnectionProvider;
import com.dao.SCE.CM_EmpDao;
import com.dbcp.util.CM_JDBCUtil;
import com.model.SCE.CM_Employee;
import com.model.SCE.CM_Gapgun;
import com.model.SCE.CM_MajInsur;
import com.model.SCE.CM_Military;

public class CM_EmpService {
	private static CM_EmpService instance = new CM_EmpService();
	private CM_EmpDao empDao = new CM_EmpDao();
	private CM_EmpService () {}
	public static CM_EmpService getInstance() {
		return instance;
	}
	public void insertEmp(CM_Employee emp, CM_Gapgun gap, CM_MajInsur maj, CM_Military mili) {
		Connection conn = null;
		try {
			// 커넥션 받아오기
			conn = CM_ConnectionProvider.getConnection();
			// 트랜잭션 off
			conn.setAutoCommit(false);
			CM_Employee employee = empDao.searchEmpNo(conn,emp.getEmpNo());
			if(employee != null) {
				CM_JDBCUtil.rollback(conn);
			} 
			empDao.insert(conn, new CM_Employee(emp.getEmpNo(), null, null, null, null, null, null, null, null, null, null, null));
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			CM_JDBCUtil.close(conn);
		}
		/*private */
		}
	}
