package com.app.todo.repo;

import com.app.todo.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepo extends JpaRepository<Like, Long> {
}
