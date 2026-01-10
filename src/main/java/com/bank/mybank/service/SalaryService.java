package com.bank.mybank.service;

import com.bank.mybank.dto.SalaryRequestDTO;
import com.bank.mybank.entity.Salary;

public interface SalaryService {

	Salary addEmpSalary(SalaryRequestDTO dto);

}
