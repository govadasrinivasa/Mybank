package com.bank.mybank.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.mybank.entity.Department;
import com.bank.mybank.service.DeptService;

@RestController
@RequestMapping("/api/dept")
public class DeptController {

    private final DeptService deptService;

    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @GetMapping("/{deptNo}")
    public Department getDeptById(@PathVariable Long deptNo) {
        return deptService.getDeptById(deptNo);
    }

    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return deptService.getAllDepartments();
    }
    
    @PostMapping("/add")
    public Department addDept(@RequestBody Department dept) {
        return deptService.addDept(dept);
    }
}