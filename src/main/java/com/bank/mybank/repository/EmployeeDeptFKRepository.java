package com.bank.mybank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.mybank.entity.Employee;

public interface EmployeeDeptFKRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDept_DeptNo(Integer deptNo);

    List<Employee> findByDept_Name(String deptName);

    List<Employee> findBySalaryBetween(Double minSalary, Double maxSalary);
}

