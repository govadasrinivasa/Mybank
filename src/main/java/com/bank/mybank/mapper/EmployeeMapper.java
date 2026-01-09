package com.bank.mybank.mapper;

import com.bank.mybank.dto.EmployeeRequestDTO;
import com.bank.mybank.entity.Department;
import com.bank.mybank.entity.EmployeeDeptFK;

public class EmployeeMapper {

    public static EmployeeDeptFK toEntity(
            EmployeeRequestDTO dto, Department dept) {

        EmployeeDeptFK emp = new EmployeeDeptFK();
        emp.setEmpId(dto.getEmpId());
        emp.setFirstName(dto.getFirstName());
        emp.setLastName(dto.getLastName());
        emp.setSalary(dto.getSalary());
        emp.setHireDate(dto.getHireDate());
        emp.setDept(dept);

        return emp;
    }
}

