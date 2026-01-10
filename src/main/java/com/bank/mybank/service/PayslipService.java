package com.bank.mybank.service;

import org.springframework.stereotype.Service;

import com.bank.mybank.dto.PayslipRequestDTO;

@Service
public interface PayslipService {

    public void generatePayslip(Long empId, String salmonth, Integer workdays);
    public String getfullName(String firstName, String lastName);
    public void updateRecord(PayslipRequestDTO dto);
}