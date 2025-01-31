package com.app.todo.controller;

import com.app.todo.dto.LoginRequest;
import com.app.todo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @PostMapping("/auth")
    public String auth(@RequestBody LoginRequest request) {
        System.out.println("LoginRequest: "+request);
        return authService.auth(request);
    }
}
