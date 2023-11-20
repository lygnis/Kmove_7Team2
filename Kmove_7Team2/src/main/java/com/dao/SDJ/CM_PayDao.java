package com.dao.SDJ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.dbcp.util.CM_ConvertHelper;
import com.dbcp.util.CM_JDBCUtil;
import com.model.PJS.CM_EmpPayData;

public class CM_PayDao {
	private static CM_PayDao instance = new CM_PayDao();

	private CM_PayDao() {
	}

	public static CM_PayDao getInstance() {
		return instance;
	}

	public CM_EmpPayData getData(Connection conn, String date, String empNo) throws SQLException {
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;

		CM_EmpPayData  data = null;
		try {
			String query = "SELECT " +
	                "    di.payment_date, " +
	                "    di.emp_no, " +
	                "    di.nation_pens, " +
	                "    di.heal_insur, " +
	                "    di.elder_insur, " +
	                "    di.income_tex, " +
	                "    di.local_income_tex, " +
	                "    di.mutual_aid, " +
	                "    pi.basic_pay, " +
	                "    pi.food_expenses, " +
	                "    pi.child_allow, " +
	                "    pi.pos_allow, " +
	                "    pi.veh_mainten, " +
	                "    pi.serv_allow, " +
	                "    pi.call_allow, " +
	                "    pi.bonus, " +
	                "    pi.holi_allow " +
	                "FROM " +
	                "    DEDUCITION_ITEM di " +
	                "JOIN " +
	                "    PAY_ITEM pi ON di.payment_date = pi.payment_date AND di.emp_no = pi.emp_no " +
	                "WHERE " +
	                "    di.emp_no = ? AND TO_CHAR(di.payment_date, 'YYYY-MM') = ?";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, empNo);
			pstmt.setString(2, date);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new CM_EmpPayData(CM_ConvertHelper.forStamp(rs.getTimestamp("payment_date")), 
						rs.getString("emp_no"), rs.getInt("nation_pens"), rs.getInt("heal_insur"), rs.getInt("elder_insur"), 
						rs.getInt("income_tex"), rs.getInt("local_income_tex"), rs.getInt("mutual_aid"), rs.getInt("basic_pay"), rs.getInt("food_expenses"), 
						rs.getInt("child_allow"), rs.getInt("pos_allow"), rs.getInt("veh_mainten"), rs.getInt("serv_allow"), 
						rs.getInt("call_allow"), rs.getInt("bonus"), rs.getInt("holi_allow"));
			}
			
			return data;
		} finally {
			CM_JDBCUtil.close(pstmt);
			CM_JDBCUtil.close(rs);
		}
	}
	public void update(Connection conn, CM_EmpPayData data, String date, String empNo)throws SQLException {
		PreparedStatement deductionStatement=null;
        PreparedStatement payStatement=null;
		
		try {
			 String updateDeductionQuery = "UPDATE DEDUCITION_ITEM " +
		                "SET " +
		                "    nation_pens = ?, " +
		                "    heal_insur = ?, " +
		                "    elder_insur = ?, " +
		                "    income_tex = ?, " +
		                "    local_income_tex = ?, " +
		                "    mutual_aid = ? " +
		                "WHERE " +
		                "    emp_no = ? AND TO_CHAR(payment_date, 'YYYY-MM') = ?";
			 deductionStatement = conn.prepareStatement(updateDeductionQuery);
			 deductionStatement.setInt(1, data.getNationPen());
			 deductionStatement.setInt(2, data.getHealInsur());
			 deductionStatement.setInt(3, data.getElderInsur());
			 deductionStatement.setInt(4, data.getIncomeTex());
			 deductionStatement.setInt(5, data.getLocaleIncomeTex());
			 deductionStatement.setInt(6, data.getMutualAid());
			 deductionStatement.setString(7, empNo);
			 deductionStatement.setString(8, date);
			 deductionStatement.executeUpdate();
			 
			 
			 String updatePayQuery = "UPDATE PAY_ITEM " +
		                "SET " +
		                "    basic_pay = ?, " +
		                "    food_expenses = ?, " +
		                "    child_allow = ?, " +
		                "    pos_allow = ?, " +
		                "    veh_mainten = ?, " +
		                "    serv_allow = ?, " +
		                "    call_allow = ?, " +
		                "    bonus = ?, " +
		                "    holi_allow = ? " +
		                "WHERE " +
		                "    emp_no = ? AND TO_CHAR(payment_date, 'YYYY-MM') = ?";
			 payStatement = conn.prepareStatement(updatePayQuery);
			 payStatement.setInt(1, data.getBasicPay());
			 payStatement.setInt(2, data.getFoodExp());
			 payStatement.setInt(3, data.getChildAllow());
			 payStatement.setInt(4, data.getPosAllow());
			 payStatement.setInt(5, data.getVehMainten());
			 payStatement.setInt(6, data.getServAllow());
			 payStatement.setInt(7, data.getCallAllow());
			 payStatement.setInt(8, data.getBonus());
			 payStatement.setInt(9, data.getHoliBonus());
			 payStatement.setString(10, empNo);
			 payStatement.setString(11, date);
			 payStatement.executeUpdate();
		}finally {
			CM_JDBCUtil.close(payStatement);
			CM_JDBCUtil.close(deductionStatement);
		}
	}
}
