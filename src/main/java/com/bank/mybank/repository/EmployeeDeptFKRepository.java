package com.bank.mybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.mybank.entity.EmployeeDeptFK;

import java.util.List;

public interface EmployeeDeptFKRepository extends JpaRepository<EmployeeDeptFK, Integer> {

    List<EmployeeDeptFK> findByDept_DeptNo(Integer deptNo);

    List<EmployeeDeptFK> findByDept_Name(String deptName);

    List<EmployeeDeptFK> findBySalaryBetween(Double minSalary, Double maxSalary);
}

