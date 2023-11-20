package com.command.Handler.SDJ;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.CM_CommandHandler;
import com.model.PJS.CM_EmpPayData;
import com.model.SCE.CM_EmpList;
import com.service.SCE.CM_EmpService;
import com.service.SDJ.CM_PayWriteService;

public class CM_PayModify implements CM_CommandHandler {
	private static final String FORM_VIEW = "WEB-INF/view/SDJ/payReadList.jsp";

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
		return null;

	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		String dateTime=req.getParameter("dateTime");
		String empNo=req.getParameter("empNo");
		CM_PayWriteService.getInstance().updatePay(convertReqToModel(req), dateTime, empNo);
		
		CM_EmpPayData empData = CM_PayWriteService.getInstance().getEmpData(empNo, dateTime);
		CM_EmpList data = CM_EmpService.getInstance().getEmpList();

		req.setAttribute("emplist", data);
		req.setAttribute("selEmpData", empData);
		return FORM_VIEW;
	}
	private CM_EmpPayData convertReqToModel(HttpServletRequest req) {
		int inormalPay =0;
		int ifoordExp =0;
		int ihealInsur =0;
		int ichildAllow =0;
		int ielderInsur =0;
		int iposAllow =0;
		int iemployInsur =0;
		int ivehMainten =0;
		int iincTex =0;
		int iservAllow =0;
		int ilocIncTex =0;
		int icallAllow =0;
		int imutualAid =0;
		int ibonus =0;
		int iholiAllow =0;
		int inationpen=0;
			
		String normalPay=req.getParameter("normalPay");
		if(normalPay != null)
			inormalPay = Integer.parseInt(normalPay);
		
		String foordExp=req.getParameter("foordExp");
		if(foordExp != null)
			ifoordExp = Integer.parseInt(foordExp);
		
		String healInsur=req.getParameter("healInsur");
		if(healInsur != null)
			ihealInsur = Integer.parseInt(healInsur);
		
		String childAllow=req.getParameter("childAllow");
		if(childAllow != null)
			ichildAllow = Integer.parseInt(childAllow);
		
		String elderInsur=req.getParameter("elderInsur");		
		if(elderInsur != null)
			ielderInsur = Integer.parseInt(elderInsur);
		
		String posAllow=req.getParameter("posAllow");
		if(posAllow != null)
			iposAllow = Integer.parseInt(posAllow);
		
		String employInsur=req.getParameter("employInsur");
		if(employInsur != null)
			iemployInsur = Integer.parseInt(employInsur);
		
		String vehMainten=req.getParameter("vehMainten");
		if(vehMainten != null)
			ivehMainten = Integer.parseInt(vehMainten);
		
		String incTex=req.getParameter("incTex");
		if(incTex != null)
			iincTex = Integer.parseInt(incTex);
		
		String servAllow=req.getParameter("servAllow");
		if(servAllow != null)
			iservAllow = Integer.parseInt(servAllow);
		
		String locIncTex=req.getParameter("locIncTex");
		if(locIncTex != null)
			ilocIncTex = Integer.parseInt(locIncTex);
		
		String callAllow=req.getParameter("callAllow");
		if(callAllow != null)
			icallAllow = Integer.parseInt(callAllow);
		
		String mutualAid=req.getParameter("mutualAid");
		if(mutualAid != null)
			imutualAid = Integer.parseInt(mutualAid);
		
		String bonus=req.getParameter("bonus");
		if(bonus != null)
			ibonus = Integer.parseInt(bonus);
		
		String holiAllow=req.getParameter("holiAllow");
		if(holiAllow != null)
			iholiAllow = Integer.parseInt(holiAllow);
		String nationpen=req.getParameter("nationpen");
		if(nationpen != null)
			inationpen = Integer.parseInt(nationpen);
		
		
		CM_EmpPayData data=new CM_EmpPayData(null, null, inationpen, ihealInsur, 
				ielderInsur, iincTex, ilocIncTex, imutualAid, inormalPay, 
				ifoordExp, ichildAllow, iposAllow, ivehMainten, iservAllow, 
				icallAllow, ibonus, iholiAllow);
		return data;
	}
}
