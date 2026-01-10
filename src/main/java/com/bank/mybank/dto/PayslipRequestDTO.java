package com.bank.mybank.dto;

public class PayslipRequestDTO {

    private String ename;
    private Long empId;
    String salmonth;

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getSalmonth() {
		return salmonth;
	}

	public void setSalmonth(String salmonth) {
		this.salmonth = salmonth;
	}

}
