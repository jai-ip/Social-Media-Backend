package com.app.todo.repo;

import com.app.todo.entity.Role;
import com.app.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByRoleName(String userName);
}
