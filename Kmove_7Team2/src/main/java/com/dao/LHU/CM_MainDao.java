package com.dao.LHU;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbcp.util.CM_JDBCUtil;
import com.model.LHU.CM_User;
import com.model.LHU.CM_UserJoin;

public class CM_MainDao {
	private static CM_MainDao instance = new CM_MainDao();
	private CM_MainDao() {}
	public static CM_MainDao getInstance() {
		return instance;
	}
	
    public CM_User selectById(Connection conn, String id) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        CM_User User = null;

        try {
            pstmt = conn.prepareStatement("SELECT * FROM login_tbl WHERE EMP_NO = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	User = new CM_User(
                    rs.getString("emp_no"),
                    rs.getString("password"),
                    rs.getString("manager"));
            }
            return User;
        } finally {
            CM_JDBCUtil.close(rs);
            CM_JDBCUtil.close(pstmt);
        }

        
    }
    public CM_UserJoin selectByIdEmetbl(Connection conn, String id) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        CM_UserJoin userJoin = null;

        try {
            pstmt = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMP_NO = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	userJoin = new CM_UserJoin(
                    rs.getString("emp_no"),

                    rs.getString("manager"));
            }
            return userJoin;
        } finally {
            CM_JDBCUtil.close(rs);
            CM_JDBCUtil.close(pstmt);
        }

        
    }

    
	public void insertToLoginTbl(Connection conn, String emp_no, String password, String manager) throws SQLException {
		try(PreparedStatement pstmt = conn.prepareStatement("insert into login_tbl values(?,?,?)")) {
			
			pstmt.setString(1, emp_no);
			pstmt.setString(2, password);
			pstmt.setString(3, manager);
			pstmt.executeUpdate();
			
			
		}
	}

	


}