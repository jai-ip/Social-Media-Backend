package com.app.todo.service;

import com.app.todo.dto.PostDTO;
import com.app.todo.dto.PostDataDTO;
import com.app.todo.dto.SuccessResponse;
import com.app.todo.entity.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {

    ResponseEntity<SuccessResponse> addPost(PostDTO postDTO);

    List<PostDataDTO> getPostsByUserId(Long userId);

    List<PostDataDTO> getAllPostOfFollowersByUserId(Long userId);

    List<Post> getAllPost();
}
