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
		employee = new CM_Employee(req.getParameter("empNo"), empNo, null, null, 
				empNo, empNo, empNo, empNo, 
				empNo, empNo, empNo, empNo, 
				empNo, empNo, empNo);
	}
}
