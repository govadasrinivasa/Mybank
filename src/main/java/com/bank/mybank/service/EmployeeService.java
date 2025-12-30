package com.bank.mybank.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.bank.mybank.entity.Department;
import com.bank.mybank.entity.EmployeeDeptFK;
import com.bank.mybank.repository.EmployeeDeptFKRepository;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeDeptFKRepository employeeRepo;

    public EmployeeService(EmployeeDeptFKRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    
    public EmployeeDeptFK addEmployee(@RequestBody EmployeeDeptFK emp) {
        return employeeRepo.save(emp);
    }

    public EmployeeDeptFK getEmployeeById(Integer empId) {
        return employeeRepo.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public List<EmployeeDeptFK> getEmployeesByDeptNo(Integer deptNo) {
        return employeeRepo.findByDept_DeptNo(deptNo);
    }

    public List<EmployeeDeptFK> getEmployeesByDeptName(String deptName) {
        return employeeRepo.findByDept_Name(deptName);
    }

    public Department getDepartmentByEmployeeId(Integer empId) {
        return getEmployeeById(empId).getDept();
    }
}
