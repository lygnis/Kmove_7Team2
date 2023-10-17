package com.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.CM_CommandHandler;
import com.command.Handler.CM_NullHandler;


public class CM_ControllerUsingURI extends HttpServlet {
	// <커맨드 , 핸들러 인스턴스> 매핑정보 저장
	private Map<String, CM_CommandHandler> commandHandlerMap = new HashMap<>();
	// 서블렛 초기화 시
	public void init() throws ServletException {
		String configFile = getInitParameter("configFile");
		Properties prop = new Properties();
		String configFilePath = getServletContext().getRealPath(configFile);
		try (FileReader fis = new FileReader(configFilePath)) {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException();
		}
		// 프로퍼티 파일을 읽고 키 값을 prop 에 할당  String String
		// 클래스 정보를 프로퍼티에서 읽고 그 해당하는 객체를 생성한다.
		// 생성한 객체를 맵에 저장
		Iterator keyIter = prop.keySet().iterator();
		while(keyIter.hasNext()) {
			String command = (String)keyIter.next();
			String handlerClassName = prop.getProperty(command);
			try {
				Class<?> handlerClass = Class.forName(handlerClassName);
				CM_CommandHandler handlerInstance = (CM_CommandHandler)handlerClass.newInstance();
				commandHandlerMap.put(command, handlerInstance);
			}catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}
	// 요철받은 객체를 찾아서 그 객체를 시작한다.
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String command = req.getRequestURI();
		if(command.indexOf(req.getContextPath())==0) {
			command = command.substring(req.getContextPath().length());
		}
		CM_CommandHandler handler = commandHandlerMap.get(command);
		// 만약 프로퍼티에 등록된 클래스 객체를 못찾으면 null핸들러 반환
		if(handler == null) {
			handler = new CM_NullHandler();
		}
		String viewPage = null;
		try {
			viewPage = handler.process(req, resp);
		}catch(Exception e) {
			throw new ServletException(e);
		}
		// 요청받은 객체를 포워딩 해준다.
		if(viewPage!= null) {
			RequestDispatcher disp = req.getRequestDispatcher(viewPage);
			disp.forward(req, resp);
		}
	}
}
