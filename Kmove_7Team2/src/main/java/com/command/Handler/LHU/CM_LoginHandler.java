package com.command.Handler.LHU;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.CM_CommandHandler;
import com.model.LHU.CM_UserLogin;
import com.service.LHU.CM_LoginService;
import com.service.LHU.LoginFailException;

public class CM_LoginHandler implements CM_CommandHandler {
	private static CM_LoginHandler instance;
	private static final String FORM_VIEW = "loginIndex.jsp";

	private CM_LoginService loginService = CM_LoginService.getInstance();
	
	
	public CM_LoginHandler() {
    }

  
    public static CM_LoginHandler getInstance() {
        if (instance == null) {
            instance = new CM_LoginHandler();
        }
        return instance;
    }

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
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse resp)throws Exception {
		String emp_no = trim(req.getParameter("id"));
		String password = trim(req.getParameter("password"));
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		if(emp_no == null || emp_no.isEmpty())
			errors.put("id", Boolean.TRUE);
		if(password == null || password.isEmpty())
			errors.put("password", Boolean.TRUE);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;	
		}
		try {
			CM_UserLogin user = loginService.login(emp_no, password);
            // 'manager' 필드가 'y'이면 관리자 페이지로 리다이렉트, 그렇지 않으면 일반 페이지로 리다이렉트
            if (user.getManager().equals("y")) {
                resp.sendRedirect(req.getContextPath() + "/managerMain.jsp");
                //req.getRequestDispatcher("/WEB-INF/view/LHU/managerMain.jsp").forward(req, resp);
            } else {
                //resp.sendRedirect(req.getContextPath() + "/WEB-INF/view/LHU/employeMain.jsp");
               req.getRequestDispatcher("/WEB-INF/view/LHU/employeMain.jsp").forward(req, resp);
            }
            req.getSession().setAttribute("authUser", user);
            return null;
            
			/*
			 * CM_UserLogin user = loginService.login(emp_no, password);
			 * req.getSession().setAttribute("authUser", user);
			 * resp.sendRedirect(req.getContextPath() + "/managerMain.jsp"); return null;
			 */
			
			
		} catch (LoginFailException e) {
            errors.put("idOrPwNotMarch", Boolean.TRUE);
            return FORM_VIEW;
        }
	}
	private String trim(String str ) {
		return str == null ? null : str.trim();
	}
}
