package com.command.Handler.SCE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.CM_CommandHandler;
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
	private String processForm(HttpServletRequest req, HttpServletResponse resp)throws Exception {
		return null;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse resp)throws Exception {
		return null;
	}
}
