package com.model.SCE;

public class CM_Military {
	
	private String empNo; //사원번호
	private String mili_serv; //병역구분
	private String divison; //군별
	private String serv_date; //입대일
	private String serv_end; //전역일
	private String final_rank; //최종계급
	private String milt_class; //병과
	private String exemp_reason; //미필사유
	
	
	public CM_Military(String empNo, String mili_serv, String divison, String serv_date, String serv_end,
			String final_rank, String milt_class, String exemp_reason) {
		super();
		this.empNo = empNo;
		this.mili_serv = mili_serv;
		this.divison = divison;
		this.serv_date = serv_date;
		this.serv_end = serv_end;
		this.final_rank = final_rank;
		this.milt_class = milt_class;
		this.exemp_reason = exemp_reason;
	}


	public String getEmpNo() {
		return empNo;
	}


	public String getMili_serv() {
		return mili_serv;
	}


	public String getDivison() {
		return divison;
	}


	public String getServ_date() {
		return serv_date;
	}


	public String getServ_end() {
		return serv_end;
	}


	public String getFinal_rank() {
		return final_rank;
	}


	public String getMilt_class() {
		return milt_class;
	}


	public String getExemp_reason() {
		return exemp_reason;
	}


	}
