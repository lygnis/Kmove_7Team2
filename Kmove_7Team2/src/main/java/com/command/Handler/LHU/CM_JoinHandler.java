package com.command.Handler.LHU;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.CM_CommandHandler;
import com.model.LHU.CM_UserJoinRequest;
import com.service.LHU.CM_DuplicateIdException;
import com.service.LHU.CM_JoinService;
import com.service.LHU.CM_UserNotFoundException;

public class CM_JoinHandler implements CM_CommandHandler {
	private static final String FORM_VIEW = "joinUser.jsp";
	private static CM_JoinHandler instance;
	private CM_JoinService joinService = CM_JoinService.getInstance();

    public CM_JoinHandler() {
    }

    public static CM_JoinHandler getInstance() {
        if (instance == null) {
            instance = new CM_JoinHandler();
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
		return null;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //String emp_no = trim(req.getParameter("emp_no"));
        //String password = trim(req.getParameter("password"));
        
        CM_UserJoinRequest ujr = new CM_UserJoinRequest();
        ujr.setEmp_no(req.getParameter("emp_no"));
		ujr.setPassword(req.getParameter("password"));
		ujr.setConfirmPassword(req.getParameter("confirmPassword"));
        
        Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		ujr.validate(errors);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}

        try  {
        	joinService.join(ujr);
            // 가입 성공 시 로그인 페이지로 리다이렉트 또는 포워드
            resp.sendRedirect(req.getContextPath() + "/login.do");
        } catch(CM_DuplicateIdException e) {
            // 가입 실패 시 오류 메시지를 설정하고 다시 가입 폼 페이지로 돌아감
        	errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
        } catch (CM_UserNotFoundException e) {
        	errors.put("IdNotExist", Boolean.TRUE);
			return FORM_VIEW;
        	
			// TODO: handle exception
		}
        return null;
    }
	/*
	 * private String trim(String str) { return str == null ? null : str.trim(); }
	 */
}
