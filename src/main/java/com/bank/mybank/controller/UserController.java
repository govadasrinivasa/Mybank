package com.bank.mybank.controller;

import org.springframework.web.bind.annotation.*;

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

//    // 2️⃣ Login (@RequestBody)
//    @PostMapping("/login")
//    public String login(@RequestBody LoginRequest request) {
//        return service.login(request)
//                .map(u -> "Login successful for " + u.getEmail())
//                .orElse("Invalid credentials");
//    }
//
//    // 3️⃣ Get User (@PathVariable + @RequestHeader)
//    @GetMapping("/{id}")
//    public User getUser(
//            @PathVariable Long id,
//            @RequestHeader(value = "client-id", required = false) String clientId
//    ) {
//        System.out.println("Client-ID: " + clientId);
//        return service.updateUser(id, new User()); // demo retrieval
//    }
//
//    // 4️⃣ Update User (@PathVariable + @RequestParam)
//    @PutMapping("/{id}")
//    public User updateUser(
//            @PathVariable Long id,
//            @RequestParam String name,
//            @RequestParam String role
//    ) {
//        User user = new User();
//        user.setName(name);
//        user.setRole(role);
//        return service.updateUser(id, user);
//    }
//
//    // 5️⃣ Delete User (@PathVariable)
//    @DeleteMapping("/{id}")
//    public String deleteUser(@PathVariable Long id) {
//        service.deleteUser(id);
//        return "User deleted successfully";
//    }
}
