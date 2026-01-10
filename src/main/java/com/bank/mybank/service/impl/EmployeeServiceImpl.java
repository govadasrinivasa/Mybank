package com.bank.mybank.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.mybank.dto.EmployeeRequestDTO;
import com.bank.mybank.entity.Department;
import com.bank.mybank.entity.Employee;
import com.bank.mybank.exception.ResourceNotFoundException;
import com.bank.mybank.mapper.EmployeeMapper;
import com.bank.mybank.repository.DeptRepository;
import com.bank.mybank.repository.EmployeeDeptFKRepository;
import com.bank.mybank.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDeptFKRepository employeeRepo;
    private final DeptRepository deptRepo;

    public EmployeeServiceImpl(EmployeeDeptFKRepository employeeRepo, DeptRepository deptRepo) {
        this.employeeRepo = employeeRepo;
        this.deptRepo = deptRepo;
    }

    @Override
    public Employee createEmployee(EmployeeRequestDTO dto) {

        Department dept = deptRepo.findById(dto.getDeptNo())
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with deptNo: " 
                			+ dto.getDeptNo()));

        Employee employee = EmployeeMapper.toEntity(dto, dept);

        return employeeRepo.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long empId) {
        return employeeRepo.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Employee not found with empId: " + empId
                ));
    }

    @Override
    public Department getDepartmentByEmployeeId(Long empId) {
        return getEmployeeById(empId).getDept();
    }
}
