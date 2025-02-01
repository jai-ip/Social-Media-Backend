package com.app.todo.serviceImpl;

import com.app.todo.dto.AuthResponse;
import com.app.todo.dto.LoginRequest;
import com.app.todo.repo.UserRepo;
import com.app.todo.service.AuthService;
import com.app.todo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public ResponseEntity<AuthResponse> auth(LoginRequest request) {

        var authToken = new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword());
        authenticationManager.authenticate(authToken);

        String token = jwtUtils.generateToken(request.getUserName());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
