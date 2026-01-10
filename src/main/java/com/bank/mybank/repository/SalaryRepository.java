package com.bank.mybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.mybank.entity.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Long> {

}

