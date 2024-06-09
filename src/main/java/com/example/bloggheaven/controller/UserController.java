package com.example.bloggheaven.controller;

import com.example.bloggheaven.entity.User;
import com.example.bloggheaven.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private  final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //client_ADMIN

    @GetMapping("/users") // admin role
    @PreAuthorize("hasRole('client_ADMIN')")
    public List <User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}") // admin role
    @PreAuthorize("hasRole('client_ADMIN')")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/newuser")
    @PreAuthorize("hasRole('client_ADMIN')")
    public String createUser(@RequestBody User user) {
        userService.save(user);
        return "User created successfully";
    }





}
