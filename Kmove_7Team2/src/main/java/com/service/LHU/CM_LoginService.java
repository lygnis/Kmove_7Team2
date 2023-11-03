
package com.service.LHU;

import java.sql.Connection;
import java.sql.SQLException;

import com.connection.CM_ConnectionProvider;
import com.dao.LHU.CM_MainDao;
import com.model.LHU.CM_User;
import com.model.LHU.CM_UserLogin;

public class CM_LoginService {
	private static CM_LoginService instance; 
    private CM_MainDao mainDao = CM_MainDao.getInstance();

    private CM_LoginService() {
    }

    public static CM_LoginService getInstance() {
        if (instance == null) {
            instance = new CM_LoginService();
        }
        return instance;
    }
	
	public CM_UserLogin login(String emp_no, String password) {
		try (Connection conn = CM_ConnectionProvider.getConnection()) {
			CM_User User = mainDao.selectById(conn, emp_no);
			if(User == null) {
				throw new CM_LoginFailException();
			}
			if(!User.matchPassword(password)) {
				throw new CM_LoginFailException();
			}
			return new CM_UserLogin(User.getId(), User.getPassword(), User.getManager());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}

}

