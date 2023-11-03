package com.command.Handler.LHU;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.command.CM_CommandHandler;

public class CM_Test_LogoutHandler implements CM_CommandHandler{
	
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception{
		HttpSession session = req.getSession(false);
		if(session != null) {
			session.invalidate();
			
		}
		res.sendRedirect(req.getContextPath() + "/index.jsp");
		return  null;
	}

}
