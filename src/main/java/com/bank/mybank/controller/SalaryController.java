package com.bank.mybank.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.mybank.dto.SalaryRequestDTO;
import com.bank.mybank.entity.Salary;
import com.bank.mybank.response.ApiResponse;
import com.bank.mybank.service.SalaryService;

@RestController
@RequestMapping("/sal")
public class SalaryController {

    private final SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @PostMapping
    public ApiResponse<Salary> createEmployee(@RequestBody SalaryRequestDTO dto) {
    	Salary sal = salaryService.addEmpSalary(dto);

        return new ApiResponse<>(true,
                "Salary created successfully",
                sal
        );
    }
 
}