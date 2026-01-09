package com.bank.mybank.service;

import com.bank.mybank.dto.EmployeeRequestDTO;
import com.bank.mybank.entity.Department;
import com.bank.mybank.entity.EmployeeDeptFK;

public interface EmployeeService {

	EmployeeDeptFK createEmployee(EmployeeRequestDTO dto);

    EmployeeDeptFK getEmployeeById(Integer empId);

    Department getDepartmentByEmployeeId(Integer empId);
}
