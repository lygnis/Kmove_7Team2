package com.service.SCE;

public class CM_EmpService {
	private static CM_EmpService instance = new CM_EmpService();
	
	private CM_EmpService () {}
	public static CM_EmpService getInstance() {
		return instance;
	}
	private int temp;
}
