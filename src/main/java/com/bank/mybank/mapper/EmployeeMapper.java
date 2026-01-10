package com.bank.mybank.mapper;

import com.bank.mybank.dto.EmployeeRequestDTO;
import com.bank.mybank.entity.Department;
import com.bank.mybank.entity.Employee;

public class EmployeeMapper {

    public static Employee toEntity(
            EmployeeRequestDTO dto, Department dept) {

        Employee emp = new Employee();
        emp.setEmpId(dto.getEmpId());
        emp.setFirstName(dto.getFirstName());
        emp.setLastName(dto.getLastName());
        emp.setSalary(dto.getSalary());
        emp.setHireDate(dto.getHireDate());
        emp.setDept(dept);

        return emp;
    }
}

