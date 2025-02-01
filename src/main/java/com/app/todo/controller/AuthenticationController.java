package com.app.todo.controller;

import com.app.todo.dto.AuthResponse;
import com.app.todo.dto.LoginRequest;
import com.app.todo.dto.SuccessResponse;
import com.app.todo.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @PostMapping("auth")
    public ResponseEntity<AuthResponse> auth(@Valid @RequestBody LoginRequest request) {
        return authService.auth(request);
    }
}
