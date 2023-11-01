package com.model.SCE;

public class CM_Gapgun {

	private String empNo; // 사원번호
	private int wangeEar; // 근로소득자
	private int taxAmountPer; // 세액(퍼센트)
	private int smBusinPer;// 중소기업청년

	public CM_Gapgun(String empNo, int wangeEar, int taxAmountPer, int smBusinPer) {
		super();
		this.empNo = empNo;
		this.wangeEar = wangeEar;
		this.taxAmountPer = taxAmountPer;
		this.smBusinPer = smBusinPer;
	}

	public String getEmpNo() {
		return empNo;
	}

	public int getWangeEar() {
		return wangeEar;
	}

	public int getTaxAmountPer() {
		return taxAmountPer;
	}

	public int getSmBusinPer() {
		return smBusinPer;
	}
}
