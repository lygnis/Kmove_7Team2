package com.command.Handler.SDJ;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.CM_CommandHandler;
import com.dbcp.util.CM_ConvertHelper;
import com.model.PJS.CM_EmpPayData;
import com.model.SCE.CM_EmpList;
import com.service.SCE.CM_EmpService;
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
		CM_EmpList data = CM_EmpService.getInstance().getEmpList();
		req.setAttribute("emplist", data);
		return FORM_VIEW;
		
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse resp)throws Exception {
		
		String date = req.getParameter("date");
		String empNo = req.getParameter("empNo");
		CM_EmpPayData empData = CM_PayWriteService.getInstance().getEmpData(empNo, date);
		CM_EmpList data = CM_EmpService.getInstance().getEmpList();
		
		req.setAttribute("date", date);
		req.setAttribute("emplist", data);
		req.setAttribute("selEmpData", empData);
		return FORM_VIEW;
	}

}
