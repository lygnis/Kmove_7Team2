package com.model.SCE;

public class CM_SocialInsur {
	
	private String empNo;//사원번호
	private int noSel; //해당없음
	private int newSub80; //신규가입자80
	private int newSub90; //신규가입자90
	
	
	public CM_SocialInsur(String empNo, int noSel, int newSub80, int newSub90) {
		super();
		this.empNo = empNo;
		this.noSel = noSel;
		this.newSub80 = newSub80;
		this.newSub90 = newSub90;
	}


	public String getEmpNo() {
		return empNo;
	}


	public int getNoSel() {
		return noSel;
	}


	public int getNewSub80() {
		return newSub80;
	}


	public int getNewSub90() {
		return newSub90;
	}
}
