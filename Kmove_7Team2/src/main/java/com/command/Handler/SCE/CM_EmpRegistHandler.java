package com.command.Handler.SCE;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.CM_CommandHandler;
import com.dbcp.util.CM_ConvertHelper;
import com.model.SCE.CM_Employee;
import com.model.SCE.CM_Gapgun;
import com.model.SCE.CM_MajInsur;
import com.service.SCE.CM_EmpService;

public class CM_EmpRegistHandler implements CM_CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/SCE/WriteEmploye.jsp ";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, resp);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, resp);
		} else {
			resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		CM_Employee cm_employee = setEmployee(req);
		return null;
	}

	private CM_Employee setEmployee(HttpServletRequest req) {
		String empNo = req.getParameter("empNo"); // 사원번호
		String name = req.getParameter("name");// 성명
		String joinDatestr = req.getParameter("joinDate");// 입사일
		// String quitDatestr = req.getParameter("quitDate");// 퇴사일
		String departmen = req.getParameter("department"); // 부서
		String spot = req.getParameter("spot"); // 직위
		String secNumber = req.getParameter("secNumber"); // 주민번호
		String addr = req.getParameter("addr"); // 주소
		String cellPh = req.getParameter("cellPh");
		String email = req.getParameter("email");
		String etc = req.getParameter("etc");
		String account = req.getParameter("account");
		Date joinDate = CM_ConvertHelper.toDate(joinDatestr);
		// Date quitDate = CM_ConvertHelper.toDate(quitDatestr);
		return new CM_Employee(empNo, name, joinDate, null, departmen, spot, secNumber, addr, cellPh, email, etc,
				account);
	}

	private CM_Gapgun setGapgun(HttpServletRequest req) {
		String empNo = req.getParameter("empNo"); // 사원번호
		String wangeEar = req.getParameter("tax_amount"); // 근로소득자
		String taxAmountPer = req.getParameter("tax_amount_per"); // 세액(퍼센트)
		String smBusin = req.getParameter("sm_busin");// 중소기업청년
		String smBusinPer = req.getParameter("sm_busin_per");
		int iwangeEar = 0;
		int itaxAmountPer = 0;
		int ismBusin = 0;
		int ismBusinPer = 0;
		if (wangeEar != null) {
			iwangeEar = Integer.parseInt(wangeEar);
		}
		if (taxAmountPer != null) {
			itaxAmountPer = Integer.parseInt(taxAmountPer);
		}
		if (smBusin != null) {
			ismBusin = Integer.parseInt(smBusin);
		}
		if (smBusinPer != null) {
			ismBusinPer = Integer.parseInt(smBusinPer);
		}
		return new CM_Gapgun(empNo, iwangeEar, itaxAmountPer, ismBusin, ismBusinPer);
	}

	private CM_MajInsur setMajInsur(HttpServletRequest req) {
		String empNo = req.getParameter("empNo"); // 사원번호
		String nation_pens = req.getParameter("nation_pens"); // 국민연금
		String heal_insur = req.getParameter("heal_insur"); // 건강보험
		String elder_insur = req.getParameter("elder_insur"); // 노인장기요양보험
		String employ_insur = req.getParameter("employ_insur"); // 고용보험
		int ination_pens = 0;
		int iheal_insur = 0;
		int ielder_insur = 0;
		int iemploy_insur = 0;
		if (nation_pens != null) {
			ination_pens = Integer.parseInt(nation_pens);
		}
		if (heal_insur != null) {
			iheal_insur = Integer.parseInt(heal_insur);
		}
		if (elder_insur != null) {
			ielder_insur = Integer.parseInt(elder_insur);
		}
		if (employ_insur != null) {
			iemploy_insur = Integer.parseInt(employ_insur);
		}
		return new CM_MajInsur(empNo, ination_pens, iheal_insur, ielder_insur, iemploy_insur);
	}
}
