package com.service.SDJ;

public class CM_PayWriteService {
	private static CM_PayWriteService instance = new CM_PayWriteService();
	
	private CM_PayWriteService() {}
	
	public static CM_PayWriteService getInstance() {
		return instance;
	}
}
