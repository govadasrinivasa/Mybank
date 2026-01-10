package com.bank.mybank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "salary")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @Column(name = "basic")
    private Integer basic;

    @Column(name = "allowances")
    private Integer allowances;

    @Column(name = "pan")
    private String pan;

    @Column(name = "desg")
    private String desg;

    @Column(name = "dept")
    private Long dept;

    @Column(name = "salmonth")
    private String salmonth;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getDesg() {
		return desg;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}

	public Long getDept() {
		return dept;
	}

	public void setDept(Long dept) {
		this.dept = dept;
	}

	public String getSalmonth() {
		return salmonth;
	}

	public void setSalmonth(String salmonth) {
		this.salmonth = salmonth;
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

}
