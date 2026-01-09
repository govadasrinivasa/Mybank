package com.bank.mybank.mapper;

import com.bank.mybank.dto.DeptRequestDTO;
import com.bank.mybank.entity.Department;

public class DeptMapper {

	public static Department toEntity(DeptRequestDTO dto) {
		Department dept = new Department();
        dept.setDeptNo(dto.getDeptNo());
        dept.setName(dto.getDeptName());
        return dept;
    }
}
