package com.app.todo.controller;

import com.app.todo.dto.SuccessResponse;
import com.app.todo.dto.UserDTO;
import com.app.todo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("addUser")
    public ResponseEntity<SuccessResponse> addUser(@Valid @RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }
}