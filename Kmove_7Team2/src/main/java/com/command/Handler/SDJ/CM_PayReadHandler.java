package com.command.Handler.SDJ;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.CM_CommandHandler;
import com.service.SDJ.CM_PayWriteService;

public class CM_PayReadHandler implements CM_CommandHandler {
private static final String FORM_VIEW="WEB-INF/view/SDJ/payReadList.jsp";
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
		/* CM_PayWriteService.getInstance() */
		String a=req.getParameter("date");
		System.out.println(a);
		return FORM_VIEW;
		
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse resp)throws Exception {
		
		return null;
	}

}
