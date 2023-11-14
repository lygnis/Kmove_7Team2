package com.command.Handler.PJS;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.CM_CommandHandler;
import com.model.PJS.CM_AllMonthPay;
import com.service.PJS.CM_AllPayService;

public class CM_MonthPay implements CM_CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/PJS/MonthSalary.jsp";
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
	public String processForm(HttpServletRequest req, HttpServletResponse resp) {
		String mData = req.getParameter("month");
		int iData =0;
		if(mData!= null)
			iData = Integer.parseInt(mData);
		CM_AllMonthPay monthData = CM_AllPayService.getInstance().getMonthPayData(iData);
		req.setAttribute("monthData", monthData);
		return FORM_VIEW;
	}

	public String processSubmit(HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}
}
