package com.Levelio.Levelio.controller;

import com.Levelio.Levelio.model.User;
import com.Levelio.Levelio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        User createdUser = service.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Account created with account id: " + createdUser.getId() + " and username: " + createdUser.getUsername());
    }
}
