package com.bank.mybank.service;

import com.bank.mybank.dto.EmployeeRequestDTO;
import com.bank.mybank.entity.Department;
import com.bank.mybank.entity.Employee;

public interface EmployeeService {

	Employee createEmployee(EmployeeRequestDTO dto);

    Employee getEmployeeById(Long empId);

    Department getDepartmentByEmployeeId(Long empId);
}
