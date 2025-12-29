package com.bank.mybank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bank.mybank.entity.User;
import com.bank.mybank.repository.UserRepository;

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

    public Optional<User> login(Long id, String password) {
    	Optional<User> user = repository.findByIdAndPassword(id, password);
        return user;
    }
    
    public List<User> getUsers(String name) {
    	List<User> users = repository.findByName(name);
        return users;
    }
    
    public User updateUser(Long id, User updated) {
        User existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existing.setName(updated.getName());
        existing.setPassword(updated.getPassword());

        return repository.save(existing);
    }
    
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
    
}
