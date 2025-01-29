package com.app.todo.serviceImpl;

import com.app.todo.dto.UserDTO;
import com.app.todo.entity.Role;
import com.app.todo.entity.User;
import com.app.todo.repo.RoleRepo;
import com.app.todo.repo.UserRepo;
import com.app.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role role = roleRepo.findByRoleName(userDTO.getRole());
        roles.add(role);

        user.setRoles(roles);

        userRepo.save(user);

        return "USER SAVED!!!";
    }
}
