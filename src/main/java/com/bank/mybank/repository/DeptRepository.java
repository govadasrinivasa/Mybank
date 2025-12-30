package com.bank.mybank.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.mybank.entity.Department;

public interface DeptRepository extends JpaRepository<Department, Long> {

    List<Department> findByName(String name);
    
    Optional<Department> findById(Long id);
}
