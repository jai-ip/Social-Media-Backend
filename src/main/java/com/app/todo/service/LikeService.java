package com.app.todo.service;

import com.app.todo.dto.SuccessResponse;
import org.springframework.http.ResponseEntity;

public interface LikeService {

    public ResponseEntity<SuccessResponse> likePost(Long postId);
}
