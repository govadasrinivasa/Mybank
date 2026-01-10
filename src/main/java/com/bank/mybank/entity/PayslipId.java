package com.bank.mybank.entity;

import java.io.Serializable;
import java.util.Objects;

public class PayslipId implements Serializable {

    private Long empId;
    private String salmonth;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PayslipId)) return false;
        PayslipId that = (PayslipId) o;
        return Objects.equals(empId, that.empId)
                && Objects.equals(salmonth, that.salmonth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, salmonth);
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

