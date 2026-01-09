package com.bank.mybank.service.impl;

import org.springframework.stereotype.Service;

import com.bank.mybank.dto.DeptRequestDTO;
import com.bank.mybank.entity.Department;
import com.bank.mybank.exception.ResourceNotFoundException;
import com.bank.mybank.mapper.DeptMapper;
import com.bank.mybank.repository.DeptRepository;
import com.bank.mybank.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

    private final DeptRepository deptRepository;

    public DeptServiceImpl(DeptRepository deptRepository) {
        this.deptRepository = deptRepository;
    }

    @Override
    public Department createDept(DeptRequestDTO dto) {
    	Department dept = DeptMapper.toEntity(dto);
        return deptRepository.save(dept);
    }

    @Override
    public Department getDeptById(Long deptNo) {
        return deptRepository.findById(deptNo)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Department not found with deptNo: " + deptNo
                ));
    }
}