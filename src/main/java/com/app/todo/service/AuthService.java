package com.app.todo.service;

import com.app.todo.dto.AuthResponse;
import com.app.todo.dto.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    public ResponseEntity<AuthResponse> auth(LoginRequest request);

}