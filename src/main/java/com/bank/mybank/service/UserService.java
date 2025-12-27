package com.bank.mybank.service;

import org.springframework.stereotype.Service;

import com.bank.mybank.entity.User;
import com.bank.mybank.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User register(User user) {
    	if(user.getPassword() != null)
    		return repository.save(user);
    	else
    		return null;
    }

//    // Login
//    public Optional<User> login(LoginRequest request) {
//        return repository.findByEmail(request.getEmail())
//                .filter(u -> u.getPassword().equals(request.getPassword()));
//    }
//
//    // Update
//    public User updateUser(Long id, User updated) {
//        User existing = repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        existing.setName(updated.getName());
//        existing.setRole(updated.getRole());
//
//        return repository.save(existing);
//    }
//
//    // Delete
//    public void deleteUser(Long id) {
//        repository.deleteById(id);
//    }
}
