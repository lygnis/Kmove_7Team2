package com.dao.SCE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import com.dbcp.util.CM_ConvertHelper;
import com.dbcp.util.CM_JDBCUtil;
import com.model.SCE.CM_Employee;

public class CM_EmpDao {
	private static CM_EmpDao instance = new CM_EmpDao();

	private CM_EmpDao() {
	}

	public static CM_EmpDao getInstance() {
		return instance;
	}

	// 등록된 사원 총 몇 명인지 확인
	public int getEmpCount(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select count(*) from EMPLOYEE");
		try {
			if (rs.next()) {
				int count = rs.getInt(1);
				return count;
			} else {
				return -1;
			}
		} finally {
			CM_JDBCUtil.close(rs);
			CM_JDBCUtil.close(stmt);
		}
	}

	public CM_Employee searchEmpNo(Connection conn, String empNo) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from EMPLOYEE where emp_no = ?");
			pstmt.setString(1, empNo);
			rs = pstmt.executeQuery();
			CM_Employee member = null;
			// 데이터를 찾는다 만약 사원 넘버가 존재하면
			if (rs.next()) {
				member = convertEmployee(rs);
			}
			return member;
		} finally {
			CM_JDBCUtil.close(rs);
			CM_JDBCUtil.close(pstmt);
		}
	}
	public void insert(Connection conn, CM_Employee info) throws SQLException {
		try (PreparedStatement pstmt = conn
				.prepareStatement("insert into ticket_tbl_01 values (?,?,?,?,?,?,?,?,?,?)")) {
			pstmt.setString(1, info.getEmpNo());
			pstmt.setTimestamp(2, new Timestamp(info.getJoinDate().getTime()));
			pstmt.setTimestamp(3, new Timestamp(info.getQuitDate().getTime()));
			pstmt.setString(4, info.getDepartment());
			pstmt.setString(5, info.getSpot());
			pstmt.setString(6, info.getSecNumber());
			pstmt.setString(7, info.getAddr());
			pstmt.setString(8, info.getCellPh());
			pstmt.setString(9, info.getEmail());
			pstmt.setString(10, info.getEtc());
			pstmt.executeUpdate();
			
			
		}
	}
	
	// DB 데이터 컨버팅 작업 Employee
	private CM_Employee convertEmployee(ResultSet rs) throws SQLException {
		String empNo = rs.getString("empNo"); // 사원번호
		String name = rs.getString("name");// 성명
		Date joinDatestr = CM_ConvertHelper.forStamp(rs.getTimestamp("joinDate"));// 입사일
		Date quitDatestr = CM_ConvertHelper.forStamp(rs.getTimestamp("quitDate"));// 퇴사일
		String departmen = rs.getString("department"); // 부서
		String spot =rs.getString("spot"); // 직위
		String secNumber = rs.getString("secNumber"); // 주민번호
		String addr = rs.getString("addr"); // 주소
		String cellPh = rs.getString("cellPh");
		String email = rs.getString("email");
		String etc = rs.getString("etc");
		String account = rs.getString("account");
		
		return new CM_Employee(empNo, name, joinDatestr, quitDatestr, departmen, 
				spot, secNumber, addr, cellPh, email, etc, account);
	}
}
