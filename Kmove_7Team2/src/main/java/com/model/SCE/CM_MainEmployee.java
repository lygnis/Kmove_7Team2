package com.model.SCE;

import javax.servlet.http.HttpServletRequest;

public class CM_MainEmployee {
	
	private CM_Employee employee;
	private CM_Gapgun gapgun;
	private CM_MajInsur majInsur;
	private CM_Military military;
	private CM_SocialInsur socialInsur;
	
	private String empNo;

	public CM_MainEmployee(HttpServletRequest req) {
		super();
		this.empNo = req.getParameter("empNo");
		this.employee = new CM_Employee(empNo, );
	}
}
