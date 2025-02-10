package com.app.todo.controller;

import com.app.todo.dto.PostDTO;
import com.app.todo.dto.PostDataDTO;
import com.app.todo.dto.SuccessResponse;
import com.app.todo.entity.Post;
import com.app.todo.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post/")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("addPost")
    public ResponseEntity<SuccessResponse> addPost(@Valid @RequestBody PostDTO postDTO) {
        return postService.addPost(postDTO);
    }

    @GetMapping("getPostsByUserId/{userId}")
    public List<PostDataDTO> getPostsByUserId(@PathVariable Long userId) {
        return postService.getPostsByUserId(userId);
    }

    @GetMapping("getAllPostOfFollowersByUserId/{userId}")
    public List<PostDataDTO> getAllPostOfFollowersByUserId(@PathVariable Long userId) {
        return postService.getAllPostOfFollowersByUserId(userId);
    }

    @GetMapping("getAllPost")
    public List<Post> getAllPost() {
        return postService.getAllPost();
    }
}
