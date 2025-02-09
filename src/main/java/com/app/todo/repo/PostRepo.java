package com.app.todo.repo;

import com.app.todo.entity.Post;
import com.app.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {

    Post findPostByPostId(Long postId);

    List<Post> findPostByUser(User user);
}
