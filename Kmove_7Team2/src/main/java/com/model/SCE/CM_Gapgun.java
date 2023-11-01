package com.model.SCE;

public class CM_Gapgun {

	private String empNo; // 사원번호
	private int wangeEar; // 근로소득자
	private int taxAmountPer; // 세액(퍼센트)
	private int smBusin;// 중소기업청년
	private int smBusinPer;
	
	
	public CM_Gapgun(String empNo, int wangeEar, int taxAmountPer, int smBusin, int smBusinPer) {
		super();
		this.empNo = empNo;
		this.wangeEar = wangeEar;
		this.taxAmountPer = taxAmountPer;
		this.smBusin = smBusin;
		this.smBusinPer = smBusinPer;
	}


	public String getEmpNo() {
		return empNo;
	}


	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}


	public int getWangeEar() {
		return wangeEar;
	}


	public void setWangeEar(int wangeEar) {
		this.wangeEar = wangeEar;
	}


	public int getTaxAmountPer() {
		return taxAmountPer;
	}


	public void setTaxAmountPer(int taxAmountPer) {
		this.taxAmountPer = taxAmountPer;
	}


	public int getSmBusin() {
		return smBusin;
	}


	public void setSmBusin(int smBusin) {
		this.smBusin = smBusin;
	}


	public int getSmBusinPer() {
		return smBusinPer;
	}


	public void setSmBusinPer(int smBusinPer) {
		this.smBusinPer = smBusinPer;
	}

	
	
}