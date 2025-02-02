package com.app.todo.dto;

import jakarta.validation.constraints.NotBlank;

public class CommentDTO {
    @NotBlank(message = "commentData must be entered")
    private String commentData;

    public String getCommentData() {
        return commentData;
    }

    public void setCommentData(String commentData) {
        this.commentData = commentData;
    }
}
