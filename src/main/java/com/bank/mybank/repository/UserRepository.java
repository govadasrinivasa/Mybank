package com.bank.mybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.mybank.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);
    
    Optional<User> findByIdAndPassword(Long id, String password);
}
