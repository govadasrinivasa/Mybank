package com.bank.mybank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.mybank.entity.User;
import com.bank.mybank.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public Optional<User> login(@RequestParam Long id,
            @RequestParam String password) {
    	Optional<User> user = service.login(id, password);
    	return user;
    }
    
    @GetMapping("/{name}")
    public List<User> getUsers(@PathVariable String name
    ) {
        return service.getUsers(name);
    }

    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam String password
    ) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        return service.updateUser(id, user);
    }
    
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "User deleted successfully";
    }
    
}
