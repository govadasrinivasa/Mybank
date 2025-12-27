package com.bank.mybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.mybank.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

//    Optional<User> findByEmail(String email);
}
