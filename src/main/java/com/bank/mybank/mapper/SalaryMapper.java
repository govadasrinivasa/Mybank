package com.bank.mybank.mapper;

import com.bank.mybank.dto.SalaryRequestDTO;
import com.bank.mybank.entity.Employee;
import com.bank.mybank.entity.Salary;

public class SalaryMapper {

    public static Salary toEntity(SalaryRequestDTO dto, Employee emp) {

        Salary sal = new Salary();
        sal.setAllowances(dto.getAllowances());
        sal.setBasic(dto.getBasic());
        sal.setDept(emp.getDept().getDeptNo());
        sal.setDesg(dto.getDesg());
        sal.setEmployee(emp);
        sal.setGa(dto.getGa());
        sal.setHra(dto.getHra());
        sal.setLta(dto.getLta());
        sal.setPan(dto.getPan());
        sal.setPf(dto.getPf());
        sal.setSa(dto.getSa());
        sal.setSalmonth(dto.getSalmonth());

        return sal;
    }
}

