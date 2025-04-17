package com.busticketing.controller;

import com.busticketing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.busticketing.model.User;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    // Register a new user
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // Authenticate user (simple check for now)
    @PostMapping("/login")
    public boolean authenticateUser(@RequestBody User user) {
        return userService.validateUser(user, user.getPassword());
    }

    // Get user by username
    @GetMapping("/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

}
