package com.service.LHU;

import java.sql.Connection;
import java.sql.SQLException;

import com.connection.CM_ConnectionProvider;
import com.dao.LHU.CM_MainDao;
import com.model.LHU.CM_User;
import com.model.LHU.CM_UserJoin;

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

    public boolean joinUser(String emp_no, String password) {
        // 사용자의 사원번호(emp_no)를 EMPLOYEE 테이블에서 확인
    	try (Connection conn = CM_ConnectionProvider.getConnection()) {
            CM_UserJoin userJoin = mainDao.selectByIdEmetbl(conn, emp_no);

            if (userJoin != null) {
                // EMPLOYEE 테이블에 해당 사원번호가 존재하면 사용자 등록
                CM_User user = new CM_User(emp_no, password, userJoin.getManager());
                mainDao.insertToLoginTbl(conn, emp_no, password, userJoin.getManager());
                return true; // 가입 성공
            } else {
                return false; // 사원번호가 존재하지 않음, 가입 실패
            }
        } catch (SQLException e) {
            // 예외 처리 로직 추가
            return false;
        }
    }

}