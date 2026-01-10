package com.bank.mybank.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.mybank.dto.PayslipRequestDTO;
import com.bank.mybank.entity.Payslip;
import com.bank.mybank.entity.PayslipId;
import com.bank.mybank.exception.ResourceNotFoundException;
import com.bank.mybank.repository.PayslipRepository;
import com.bank.mybank.service.PayslipService;

@Service
@Transactional
public class PayslipServiceImpl implements PayslipService {

	 private final PayslipRepository payslipRepository;

	    public PayslipServiceImpl(PayslipRepository payslipRepository) {
	        this.payslipRepository = payslipRepository;
	    }

	    @Transactional
	    public void generatePayslip(Long empId, String salmonth, Integer workdays) {
	        payslipRepository.generatePayslip(empId, salmonth, workdays);
	    }

		@Override
		public String getfullName(String firstName, String lastName) {
			return payslipRepository.getFullName(firstName, lastName);
		}

		@Override
		public void updateRecord(PayslipRequestDTO dto) {
			PayslipId payslipId = new PayslipId();
			payslipId.setEmpId(dto.getEmpId());
			payslipId.setSalmonth(dto.getSalmonth());
			Payslip payslip = payslipRepository.findById(payslipId)
	                .orElseThrow(() -> new ResourceNotFoundException(
	                        "Employee not found with empId: " + dto.getEmpId()
	                ));
//			Payslip payslip = new Payslip();
			payslip.setEname(dto.getEname());
			payslipRepository.save(payslip);
		}
}
