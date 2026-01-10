package com.bank.mybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.mybank.entity.Payslip;
import com.bank.mybank.entity.PayslipId;

@Repository
public interface PayslipRepository extends JpaRepository<Payslip, PayslipId> {

    @Procedure(procedureName = "insert_payslip_for_month")
    void generatePayslip(Long p_emp_id, String p_salmonth, Integer p_workdays);
    
    
    @Procedure(procedureName = "get_full_name")
    String getFullName(@Param("p_first_name") String firstName, @Param("p_last_name") String lastName
    );
}