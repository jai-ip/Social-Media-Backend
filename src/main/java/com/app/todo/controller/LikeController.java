package com.app.todo.controller;

import com.app.todo.dto.SuccessResponse;
import com.app.todo.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/like/")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("addLike/{postId}")
    private ResponseEntity<SuccessResponse> likePost(@PathVariable Long postId) {
        return likeService.likePost(postId);
    }
}
