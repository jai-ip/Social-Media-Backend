package com.app.todo.service;

import com.app.todo.dto.SuccessResponse;
import com.app.todo.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {

    public ResponseEntity<SuccessResponse> addUser(UserDTO userDTO);
}
