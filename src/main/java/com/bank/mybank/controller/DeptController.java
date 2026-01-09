package com.bank.mybank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.mybank.dto.DeptRequestDTO;
import com.bank.mybank.entity.Department;
import com.bank.mybank.response.ApiResponse;
import com.bank.mybank.service.DeptService;

@RestController
@RequestMapping("/api/dept")
public class DeptController {

    private final DeptService deptService;

    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @PostMapping
    public ApiResponse<Department> createDepartment(@RequestBody DeptRequestDTO dto) {
    	
    	Department dept = deptService.createDept(dto);

        return new ApiResponse<>(
                true,
                "Department created successfully",
                dept
        );
    }
    
    @GetMapping("/{deptNo}")
    public ApiResponse<Department> getDepartment(@PathVariable Long deptNo) {

    	Department dept = deptService.getDeptById(deptNo);

        return new ApiResponse<>(
                true,
                "Department fetched successfully",
                dept
        );
    }
}