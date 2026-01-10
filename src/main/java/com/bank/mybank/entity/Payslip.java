package com.bank.mybank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payslip")
@IdClass(PayslipId.class)
public class Payslip {

    @Id
    @Column(name = "emp_id")
    private Long empId;

    @Id
    @Column(name = "salmonth")
    private String salmonth;

    @Column(name = "ename")
    private String ename;

    @Column(name = "description")
    private String description;

    @Column(name = "dept")
    private Integer dept;

    @Column(name = "pan")
    private String pan;

    @Column(name = "pfno")
    private String pfno;

    @Column(name = "workdays")
    private Integer workdays;

    @Column(name = "basic")
    private Integer basic;

    @Column(name = "allowances")
    private Integer allowances;

    @Column(name = "hra")
    private Integer hra;

    @Column(name = "lta")
    private Integer lta;

    @Column(name = "pf")
    private Integer pf;

    @Column(name = "ga")
    private Integer ga;

    @Column(name = "sa")
    private Integer sa;

    @Column(name = "it")
    private Integer it;

    @Column(name = "proftax")
    private Integer proftax;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id", insertable = false, updatable = false)
    private Employee employee;

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

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDept() {
		return dept;
	}

	public void setDept(Integer dept) {
		this.dept = dept;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getPfno() {
		return pfno;
	}

	public void setPfno(String pfno) {
		this.pfno = pfno;
	}

	public Integer getWorkdays() {
		return workdays;
	}

	public void setWorkdays(Integer workdays) {
		this.workdays = workdays;
	}

	public Integer getBasic() {
		return basic;
	}

	public void setBasic(Integer basic) {
		this.basic = basic;
	}

	public Integer getAllowances() {
		return allowances;
	}

	public void setAllowances(Integer allowances) {
		this.allowances = allowances;
	}

	public Integer getHra() {
		return hra;
	}

	public void setHra(Integer hra) {
		this.hra = hra;
	}

	public Integer getLta() {
		return lta;
	}

	public void setLta(Integer lta) {
		this.lta = lta;
	}

	public Integer getPf() {
		return pf;
	}

	public void setPf(Integer pf) {
		this.pf = pf;
	}

	public Integer getGa() {
		return ga;
	}

	public void setGa(Integer ga) {
		this.ga = ga;
	}

	public Integer getSa() {
		return sa;
	}

	public void setSa(Integer sa) {
		this.sa = sa;
	}

	public Integer getIt() {
		return it;
	}

	public void setIt(Integer it) {
		this.it = it;
	}

	public Integer getProftax() {
		return proftax;
	}

	public void setProftax(Integer proftax) {
		this.proftax = proftax;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
