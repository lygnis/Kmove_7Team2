package com.model.SCE;

public class CM_Gapgun {
	
	private String empNo; //사원번호
	private int wangeEar; //근로소득자
	private int taxAmountPer; //세액(퍼센트)
	private int smBusinPer; //중소기업청년
	private int dayLabor; //사업소득자
	private int etcEar; //일용직
	private int earnerInc; //근로/사업소득
	private int exemp; //면제
	
	
	public CM_Gapgun(String empNo, int wangeEar, int taxAmountPer, int smBusinPer, int dayLabor, int etcEar,
			int earnerInc, int exemp) {
		super();
		this.empNo = empNo;
		this.wangeEar = wangeEar;
		this.taxAmountPer = taxAmountPer;
		this.smBusinPer = smBusinPer;
		this.dayLabor = dayLabor;
		this.etcEar = etcEar;
		this.earnerInc = earnerInc;
		this.exemp = exemp;
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


	public int getDayLabor() {
		return dayLabor;
	}


	public int getEtcEar() {
		return etcEar;
	}


	public int getEarnerInc() {
		return earnerInc;
	}


	public int getExemp() {
		return exemp;
	}

}
