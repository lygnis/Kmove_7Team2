package com.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 핸들러 인터페이스
public interface CM_CommandHandler {
	public String process(HttpServletRequest req, HttpServletResponse resp)
	throws Exception;
}


