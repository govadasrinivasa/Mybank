package com.bank.mybank.service;

import com.bank.mybank.dto.DeptRequestDTO;
import com.bank.mybank.entity.Department;

public interface DeptService {

	Department createDept(DeptRequestDTO dto);

	Department getDeptById(Long deptNo);
}
