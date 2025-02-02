package com.app.todo.repo;

import com.app.todo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {

    public Post findPostByPostId(Long postId);
}
