package com.app.todo.controller;

import com.app.todo.dto.UserDTO;
import com.app.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/addUser")
    public String addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }
}
