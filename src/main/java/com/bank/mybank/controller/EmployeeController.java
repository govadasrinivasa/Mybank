package com.bank.mybank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.mybank.dto.EmployeeRequestDTO;
import com.bank.mybank.entity.Department;
import com.bank.mybank.entity.Employee;
import com.bank.mybank.response.ApiResponse;
import com.bank.mybank.service.EmployeeService;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ApiResponse<Employee> createEmployee(@RequestBody EmployeeRequestDTO dto) {
    	Employee employee = employeeService.createEmployee(dto);

        return new ApiResponse<>(
                true,
                "Employee created successfully",
                employee
        );
    }

    @GetMapping("/{id}/department")
    public ApiResponse<Department> getEmployeeDepartment(@PathVariable Long id) {
    	
    	Department dept = employeeService.getDepartmentByEmployeeId(id);
    	
    	return new ApiResponse<>(
                true,
                "Department fetched successfully",
                dept
        );
    }
}