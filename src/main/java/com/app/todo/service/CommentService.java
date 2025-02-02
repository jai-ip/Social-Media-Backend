package com.app.todo.service;

import com.app.todo.dto.CommentDTO;
import com.app.todo.dto.SuccessResponse;
import org.springframework.http.ResponseEntity;

public interface CommentService {

    public ResponseEntity<SuccessResponse> addComment(Long postId, CommentDTO commentDTO);
}
