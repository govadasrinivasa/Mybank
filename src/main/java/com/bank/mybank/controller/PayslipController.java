package com.bank.mybank.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.mybank.dto.PayslipRequestDTO;
import com.bank.mybank.entity.Employee;
import com.bank.mybank.service.EmployeeService;
import com.bank.mybank.service.PayslipService;

@RestController
@RequestMapping("/payslips")
public class PayslipController {

    private final PayslipService payslipService;
    private final EmployeeService employeeService;

    public PayslipController(PayslipService payslipService, EmployeeService employeeService) {
        this.payslipService = payslipService;
        this.employeeService = employeeService;
    }

    @PostMapping("/generate")
    public String generatePayslip(@RequestParam Long empId, @RequestParam String salmonth, @RequestParam Integer workdays) {
    	
        payslipService.generatePayslip(empId, salmonth, workdays);
        Employee emp = employeeService.getEmployeeById(empId);
        String fullName = payslipService.getfullName(emp.getFirstName(), emp.getLastName());
        PayslipRequestDTO dto = new PayslipRequestDTO();
        dto.setEname(fullName);
        dto.setEmpId(emp.getEmpId());
        dto.setSalmonth(salmonth);
        payslipService.updateRecord(dto);
        return "Payslip generated successfully";
    }
    
    
}