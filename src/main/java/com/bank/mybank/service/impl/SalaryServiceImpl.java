package com.bank.mybank.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.mybank.dto.SalaryRequestDTO;
import com.bank.mybank.entity.Employee;
import com.bank.mybank.entity.Salary;
import com.bank.mybank.exception.ResourceNotFoundException;
import com.bank.mybank.mapper.SalaryMapper;
import com.bank.mybank.repository.EmployeeDeptFKRepository;
import com.bank.mybank.repository.SalaryRepository;
import com.bank.mybank.service.SalaryService;

@Service
@Transactional
public class SalaryServiceImpl implements SalaryService {

    private final EmployeeDeptFKRepository employeeRepo;
    private final SalaryRepository salRepo;

    public SalaryServiceImpl(EmployeeDeptFKRepository employeeRepo, SalaryRepository salRepo) {
        this.employeeRepo = employeeRepo;
        this.salRepo = salRepo;
    }

	@Override
	public Salary addEmpSalary(SalaryRequestDTO dto) {
		Employee emp = employeeRepo.findById(dto.getEmp_id())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Employee not found with empId: " + dto.getEmp_id()
                ));

        Salary sal = SalaryMapper.toEntity(dto, emp);

        return salRepo.save(sal);
	}
}
