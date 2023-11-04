package com.command.Handler.LHU;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.CM_CommandHandler;
import com.service.LHU.CM_JoinService;

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
        String emp_no = trim(req.getParameter("emp_no"));
        String password = trim(req.getParameter("password"));

        if (joinService.joinUser(emp_no, password)) {
            // 가입 성공 시 로그인 페이지로 리다이렉트 또는 포워드
            resp.sendRedirect(req.getContextPath() + "/login.do");
        } else {
            // 가입 실패 시 오류 메시지를 설정하고 다시 가입 폼 페이지로 돌아감
            req.setAttribute("joinError", "가입에 실패했습니다. 올바른 사원번호를 입력하세요.");
            return FORM_VIEW;
        }
        return null;
    }
	 private String trim(String str) {
		    return str == null ? null : str.trim();
		}
}
