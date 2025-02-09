package com.app.todo.dto;

import java.time.Instant;

public class CommentDataDTO {

    private Long commentId;
    private String commentData;
    private Instant createdAt;

    public CommentDataDTO() {
    }

    public CommentDataDTO(Long commentId, String commentData, Instant createdAt) {
        this.commentId = commentId;
        this.commentData = commentData;
        this.createdAt = createdAt;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getCommentData() {
        return commentData;
    }

    public void setCommentData(String commentData) {
        this.commentData = commentData;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}