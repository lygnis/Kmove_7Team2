package com.service.LHU;

import java.sql.Connection;
import java.sql.SQLException;

import com.connection.CM_ConnectionProvider;
import com.dao.LHU.CM_MainDao;
import com.dbcp.util.CM_JDBCUtil;
import com.model.LHU.CM_User;
import com.model.LHU.CM_UserJoin;
import com.model.LHU.CM_UserJoinRequest;



public class CM_JoinService {
	private static CM_JoinService instance = new CM_JoinService();
	private CM_MainDao mainDao = CM_MainDao.getInstance();

	private CM_JoinService() {
	}

	public static CM_JoinService getInstance() {
		if (instance == null) {
			instance = new CM_JoinService();
		}
		return instance;

	}

	public void join(CM_UserJoinRequest ujr) {
		Connection conn = null;
		try {
			conn = CM_ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			CM_UserJoin userJoin = mainDao.selectByIdEmetbl(conn, ujr.getEmp_no());
			// id에 해당되는 회원을 조회
			CM_User user = mainDao.selectById(conn, ujr.getEmp_no());
			if (user != null) {
				CM_JDBCUtil.rollback(conn);
				throw new CM_DuplicateIdException();

			}
			


			if (userJoin != null) {

				CM_User user2 = new CM_User(ujr.getEmp_no(), ujr.getPassword(), userJoin.getManager());
				mainDao.insertToLoginTbl(conn, ujr.getEmp_no(), ujr.getPassword(), userJoin.getManager());
				conn.commit(); 
			} else {
				CM_JDBCUtil.rollback(conn);
				throw new CM_UserNotFoundException();
			}
		}catch(SQLException e) {
			CM_JDBCUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			CM_JDBCUtil.close(conn);
			//커넥션을 종료한다.
		}
    }
	/*
	 * public boolean joinUser(String emp_no, String password) { // 사용자의
	 * 사원번호(emp_no)를 EMPLOYEE 테이블에서 확인 try (Connection conn =
	 * CM_ConnectionProvider.getConnection()) { CM_UserJoin userJoin =
	 * mainDao.selectByIdEmetbl(conn, emp_no);
	 * 
	 * if (userJoin != null) { // EMPLOYEE 테이블에 해당 사원번호가 존재하면 사용자 등록 CM_User user =
	 * new CM_User(emp_no, password, userJoin.getManager());
	 * mainDao.insertToLoginTbl(conn, emp_no, password, userJoin.getManager());
	 * return true; // 가입 성공 } else { return false; // 사원번호가 존재하지 않음, 가입 실패 } }
	 * catch (SQLException e) { // 예외 처리 로직 추가 return false; } }
	 */

}