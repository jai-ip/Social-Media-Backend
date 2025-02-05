package com.app.todo.service;

import com.app.todo.dto.SuccessResponse;
import com.app.todo.dto.UserDTO;
import com.app.todo.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    public ResponseEntity<SuccessResponse> addUser(UserDTO userDTO);

    public List<User> getAllUsers();

    public ResponseEntity<SuccessResponse> followUser(Long followerUserId, Long followingUserId);
}
