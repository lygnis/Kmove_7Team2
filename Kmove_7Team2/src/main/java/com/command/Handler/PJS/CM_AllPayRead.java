package com.command.Handler.PJS;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.CM_CommandHandler;
import com.model.PJS.CM_AllYearPay;
import com.service.PJS.CM_AllPayService;

public class CM_AllPayRead implements CM_CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/PJS/AllSalary.jsp";
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
		LocalDate currentDate = LocalDate.now();
		Date date = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		return FORM_VIEW;
	}

	public String processSubmit(HttpServletRequest req, HttpServletResponse resp) {
		String year = req.getParameter("year");
		int iData =0;
		if(year!= null)
			iData = Integer.parseInt(year);
		CM_AllYearPay data = CM_AllPayService.getInstance().getAllreadData(iData);
		List<Integer> lData = data.getallPayList();
		List<Float> fList = data.getcalPerList();
		Map<Integer, Integer> empMap =  data.getEmpCount();
		Map<String, Map<Integer, Integer>> combinedMap = new HashMap<>();
		combinedMap.put("mapPay", data.getItemPayrs());
		combinedMap.put("mapDed", data.getDedPayRs());
		
		req.setAttribute("empCount", empMap);
		req.setAttribute("allPayList", lData);
		req.setAttribute("allPay", combinedMap);
		req.setAttribute("per", fList);
		
		return FORM_VIEW;
	}
}
