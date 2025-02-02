package com.app.todo.service;

import com.app.todo.dto.PostDTO;
import com.app.todo.dto.SuccessResponse;
import com.app.todo.entity.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {

    public ResponseEntity<SuccessResponse> addPost(PostDTO postDTO);

    public List<Post> getAllPost();
}
