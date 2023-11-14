package com.dao.PJS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dbcp.util.CM_ConvertHelper;
import com.dbcp.util.CM_JDBCUtil;

import com.model.PJS.CM_AllMonthPay;
import com.model.PJS.CM_AllYearPay;
import com.model.PJS.CM_EmpPayData;
import com.service.PJS.CM_AllPayService;

public class CM_AllPayDao {
	private static CM_AllPayDao instance = new CM_AllPayDao();

	private CM_AllPayDao() {

	}

	public static CM_AllPayDao getInstance() {
		return instance;
	}

	public CM_AllYearPay readAllYearPay(Connection conn, int year) throws SQLException {
		PreparedStatement dpstmt = null;
		PreparedStatement ppstmt = null;
		PreparedStatement emppstmt = null;
		ResultSet drs = null;
		ResultSet prs = null;
		ResultSet emprs = null;
		CM_AllYearPay dataPay = new CM_AllYearPay();
		try {
			// 공제항목
			String deductionQuery = "SELECT 'DEDUCITION_ITEM' AS table_name, "
					+ "EXTRACT(MONTH FROM payment_date) AS month, "
					+ "SUM(nation_pens + heal_insur + elder_insur + income_tex + local_income_tex + mutual_aid) AS total_value "
					+ "FROM DEDUCITION_ITEM " + "WHERE EXTRACT(YEAR FROM payment_date) = ? "
					+ "GROUP BY EXTRACT(MONTH FROM payment_date) "
					+ "ORDER BY TO_NUMBER(EXTRACT(MONTH FROM payment_date)) ";
			dpstmt = conn.prepareStatement(deductionQuery);
			dpstmt.setInt(1, year);
			drs = dpstmt.executeQuery();

			// 실지급
			String payQuery = "SELECT 'PAY_ITEM' AS table_name, " + "EXTRACT(MONTH FROM payment_date) AS month, "
					+ "SUM(food_expenses + child_allow + pos_allow + veh_mainten + serv_allow + call_allow + bonus + holi_allow) AS total_value "
					+ "FROM PAY_ITEM " + "WHERE EXTRACT(YEAR FROM payment_date) = ? "
					+ "GROUP BY EXTRACT(MONTH FROM payment_date) "
					+ "ORDER BY TO_NUMBER(EXTRACT(MONTH FROM payment_date)) ";

			ppstmt = conn.prepareStatement(payQuery);
			ppstmt.setInt(1, year);
			prs = ppstmt.executeQuery();

			// 달 마다 사원수
			String empCountQuery = "SELECT COUNT(DISTINCT emp_no) AS employee_count " + "FROM PAY_ITEM "
					+ "WHERE EXTRACT(MONTH FROM payment_date) = ?";
			emppstmt = conn.prepareStatement(empCountQuery);
			for (int i = 1; i <= 12; i++) {
				emppstmt.setInt(1, i);
				emprs = emppstmt.executeQuery();
				if (emprs.next())
					dataPay.setEmpCount(i, emprs.getString("employee_count"));
			}
			while (drs.next()) {
				dataPay.setDedPayRs(drs.getString("month"), drs.getString("total_value"));
			}
			while (prs.next()) {
				String tMonth = prs.getString("month");
				String tTotal = prs.getString("total_value");
				dataPay.setItemPayrs(tMonth, tTotal);
			}
			return dataPay;
		} finally {
			CM_JDBCUtil.close(dpstmt);
			CM_JDBCUtil.close(ppstmt);
			CM_JDBCUtil.close(drs);
			CM_JDBCUtil.close(prs);
			CM_JDBCUtil.close(emppstmt);
			CM_JDBCUtil.close(emprs);
		}
	}
	public CM_AllMonthPay getMonthPayData(int month, Connection conn)throws SQLException {
		PreparedStatement pstmp = null;
		ResultSet rs = null;
		CM_AllMonthPay monthData = new CM_AllMonthPay();
		try {
			String mPayQueary = "SELECT di.payment_date, di.emp_no, di.nation_pens, di.heal_insur, di.elder_insur, di.income_tex, di.local_income_tex, di.mutual_aid, "
					+ "       pi.basic_pay, pi.food_expenses, pi.child_allow, pi.pos_allow, pi.veh_mainten, pi.serv_allow, pi.call_allow, pi.bonus, pi.holi_allow "
					+ "FROM DEDUCITION_ITEM di "
					+ "JOIN PAY_ITEM pi ON di.emp_no = pi.emp_no "
					+ "WHERE EXTRACT(MONTH FROM di.payment_date) = ? "
					+ "AND EXTRACT(MONTH FROM pi.payment_date) = ?";
			pstmp = conn.prepareStatement(mPayQueary);
			pstmp.setInt(1, month);
			pstmp.setInt(2, month);
			rs = pstmp.executeQuery();
			while(rs.next()) {
				CM_EmpPayData data = new CM_EmpPayData(CM_ConvertHelper.forStamp(rs.getTimestamp("payment_date")), 
						rs.getString("emp_no"), rs.getInt("nation_pens"), rs.getInt("heal_insur"), rs.getInt("elder_insur"), 
						rs.getInt("income_tex"), rs.getInt("local_income_tex"), rs.getInt("mutual_aid"), rs.getInt("basic_pay"), rs.getInt("food_expenses"), 
						rs.getInt("child_allow"), rs.getInt("pos_allow"), rs.getInt("veh_mainten"), rs.getInt("serv_allow"), 
						rs.getInt("call_allow"), rs.getInt("bonus"), rs.getInt("holi_allow"));
				monthData.setMonthEmpData(data);
			}
			return monthData;
		}finally {
			CM_JDBCUtil.close(pstmp);
			CM_JDBCUtil.close(rs);
		}
	}
}
