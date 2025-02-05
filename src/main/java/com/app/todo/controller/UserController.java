package com.app.todo.controller;

import com.app.todo.dto.SuccessResponse;
import com.app.todo.dto.UserDTO;
import com.app.todo.entity.User;
import com.app.todo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("addUser")
    public ResponseEntity<SuccessResponse> addUser(@Valid @RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @GetMapping("getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("followUser/{followerUserId}/{followingUserId}")
    public ResponseEntity<SuccessResponse> addUser(@PathVariable Long followerUserId, @PathVariable Long followingUserId) {
        return userService.followUser(followerUserId, followingUserId);
    }
}