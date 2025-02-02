package com.app.todo.controller;

import com.app.todo.dto.CommentDTO;
import com.app.todo.dto.SuccessResponse;
import com.app.todo.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("addComment/{postId}")
    public ResponseEntity<SuccessResponse> addComment(@PathVariable Long postId, @Valid @RequestBody CommentDTO commentDTO) {
        return commentService.addComment(postId, commentDTO);
    }

}
