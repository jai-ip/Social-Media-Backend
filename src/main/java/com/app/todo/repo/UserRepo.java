package com.app.todo.repo;

import com.app.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);

    Optional<User> findByUserId(Long userId);

    @Query("SELECT u.following FROM User u WHERE u.userId = :userId")
    List<User> findFollowingByUserId(Long userId);

    @Query("SELECT u FROM User u JOIN u.roles r WHERE r.roleName = :roleName")
    List<User> findAllUserByRoleName(String roleName);
}
