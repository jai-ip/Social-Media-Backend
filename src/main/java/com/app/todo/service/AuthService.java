package com.app.todo.service;

import com.app.todo.dto.LoginRequest;

public interface AuthService {

    public String auth(LoginRequest request);

}
