package com.dbcp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
// 로그인 하지 않은 상태면 회원 정보 수정 URL에 접그하면 로그인 폼으로 이동하도록 유도한다.
// - 로그인 여부를 검사한다.
// - 로그인하지 않았으면 로그인 화면으로 이동시킨다.
// - 로그인했다면 요청한 기능을 실행한다.
// 필터에서 로그인 여부를 검사하면 나머지 코드를 수정할 필요 없이 로그인 여부 검사 로직을 수행할 수 있다.
public class CM_LoginCheckFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("authUser") == null) {
			HttpServletResponse response = (HttpServletResponse)arg1;
			response.sendRedirect(request.getContextPath() + "/login.do");

		}else {
			arg2.doFilter(arg0, arg1);
		}
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	

}
