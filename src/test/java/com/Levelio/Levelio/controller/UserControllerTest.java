package com.Levelio.Levelio.controller;

import com.Levelio.Levelio.model.User;
import com.Levelio.Levelio.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class UserControllerTest {
    UserService userService = mock(UserService.class);

    @InjectMocks
    private UserController userController; // Automatically injects the mock

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize the mocks
    }

        @Test
    public void createUser_validParams_responds2xx() {
        User testUser = User.builder()
                .email("test@email.com")
                .username("user1")
                .password("password123")
                .build();

        when(userService.createUser(any())).thenReturn(testUser);

        ResponseEntity<String> user = userController.createUser(testUser);

        System.out.println(user);


    }


}