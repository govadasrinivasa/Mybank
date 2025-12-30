package com.bank.mybank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dept")
public class Department {

	 @Id
	 @Column(name = "DeptNo")
	 private Long deptNo;

	 @Column(name = "Dname")
	 private String name;
	    
	 @Column(name = "loc")
	 private String location;

	 public Long getDeptNo() {
		return deptNo;
	 }

	 public void setDeptNo(Long deptNo) {
		this.deptNo = deptNo;
	 }

	 public String getName() {
	 	return name;
	 }

	 public void setName(String name) {
		this.name = name;
	 }

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}
		

}