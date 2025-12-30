package com.bank.mybank.controller;

import org.springframework.web.bind.annotation.*;

import com.bank.mybank.entity.Department;
import com.bank.mybank.entity.EmployeeDeptFK;
import com.bank.mybank.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public EmployeeDeptFK addDept(@RequestBody EmployeeDeptFK emp) {
        return employeeService.addEmployee(emp);
    }
    
    @GetMapping("/{id}")
    public EmployeeDeptFK getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/by-dept-no/{deptNo}")
    public List<EmployeeDeptFK> getEmployeesByDeptNo(
            @PathVariable Integer deptNo) {
        return employeeService.getEmployeesByDeptNo(deptNo);
    }

    // Get employees by department name
    @GetMapping("/by-dept-name/{deptName}")
    public List<EmployeeDeptFK> getEmployeesByDeptName(
            @PathVariable String deptName) {
        return employeeService.getEmployeesByDeptName(deptName);
    }

    // Get department details of an employee
    @GetMapping("/{id}/department")
    public Department getDepartmentOfEmployee(@PathVariable Integer id) {
        return employeeService.getDepartmentByEmployeeId(id);
    }
}