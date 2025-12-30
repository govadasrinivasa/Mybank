package com.bank.mybank.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bank.mybank.entity.Department;
import com.bank.mybank.entity.User;
import com.bank.mybank.repository.DeptRepository;

import java.util.List;

	@Service
	public class DeptService {

	    private final DeptRepository deptRepository;

	    public DeptService(DeptRepository deptRepository) {
	        this.deptRepository = deptRepository;
	    }

	    public Department getDeptById(Long deptNo) {
	        return deptRepository.findById(deptNo)
	                .orElseThrow(() -> new RuntimeException("Department not found"));
	    }

	    public List<Department> getAllDepartments() {
	        return deptRepository.findAll();
	    }
	    
	    public Department addDept(@RequestBody Department dept) {
	    	if(dept.getName() != null)
	    		return deptRepository.save(dept);
	    	else
	    		return null;
	    }
	}
