package com.model.PJS;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CM_AllMonthPay {
	List<CM_EmpPayData> monthEmpData = new ArrayList<CM_EmpPayData>();

	public List<CM_EmpPayData> getMonthEmpData() {
		return monthEmpData;
	}

	public void setMonthEmpData(CM_EmpPayData monthEmpData) {
		this.monthEmpData.add(monthEmpData);
	}
	
}
