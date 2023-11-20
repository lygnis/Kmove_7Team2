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
import com.model.SCE.CM_EmpList;
import com.model.SCE.CM_Employee;

public class CM_EmpDao {
	private static CM_EmpDao instance = new CM_EmpDao();


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
				.prepareStatement("insert into EMPLOYEE values(?,?,?,?,?,?,?,?,?,?,?,?)")) {
			pstmt.setString(1, info.getEmpNo());
			pstmt.setString(2, info.getName());
			pstmt.setTimestamp(3, new Timestamp(info.getJoinDate().getTime()));
			pstmt.setTimestamp(4, new Timestamp(info.getQuitDate().getTime()));
			pstmt.setString(5, info.getDepartment());
			pstmt.setString(6, info.getSpot());
			pstmt.setString(7, info.getSecNumber());
			pstmt.setString(8, info.getAddr());
			pstmt.setString(9, info.getCellPh());
			pstmt.setString(10, info.getEmail());
			pstmt.setString(11, info.getEtc());
			pstmt.setString(12, info.getAccount());
			pstmt.executeUpdate();
			
			
		}
	}
	public CM_EmpList getEmpList (Connection conn) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CM_EmpList data = new CM_EmpList();
		try {
			pstmt = conn.prepareStatement("select * from EMPLOYEE");
			rs = pstmt.executeQuery();
			CM_Employee member = null;
			// 데이터를 찾는다 만약 사원 넘버가 존재하면
			while (rs.next()) {
				member = convertEmployee(rs);
				data.setList(member);
			}
			return data;
		} finally {
			CM_JDBCUtil.close(rs);
			CM_JDBCUtil.close(pstmt);
		}
	}
	
	// DB 데이터 컨버팅 작업 Employee
	private CM_Employee convertEmployee(ResultSet rs) throws SQLException {
		String empNo = rs.getString("emp_No"); // 사원번호
		String name = rs.getString("emp_name");// 성명
		Date joinDatestr = CM_ConvertHelper.forStamp(rs.getTimestamp("join_Date"));// 입사일
		Date quitDatestr = CM_ConvertHelper.forStamp(rs.getTimestamp("quit_Date"));// 퇴사일
		String departmen = rs.getString("emp_dep"); // 부서
		String spot =rs.getString("emp_spot"); // 직위
		String secNumber = rs.getString("emp_sec_Num"); // 주민번호
		String addr = rs.getString("emp_addr"); // 주소
		String cellPh = rs.getString("emp_cellPh");
		String email = rs.getString("emp_email");
		String etc = rs.getString("emp_etc");
		String account = rs.getString("sal_acount");
		
		return new CM_Employee(empNo, name, joinDatestr, quitDatestr, departmen, 
				spot, secNumber, addr, cellPh, email, etc, account);
	}
	
}
