package com.dao.LHU;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbcp.util.CM_JDBCUtil;
import com.model.LHU.CM_User;

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
                    rs.getString("manager")    	
                );
            }
            return User;
        } finally {
            CM_JDBCUtil.close(rs);
            CM_JDBCUtil.close(pstmt);
        }

        
    }
    
	public void insert(Connection conn, CM_User user) throws SQLException {
		try(PreparedStatement pstmt = conn.prepareStatement("insert into login_tbl values(?,?,?)")) {
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getManager());
			pstmt.executeUpdate();
			
			
		}
	}
}