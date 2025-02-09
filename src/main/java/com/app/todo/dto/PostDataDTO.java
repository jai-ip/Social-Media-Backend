package com.app.todo.dto;

import java.time.Instant;
import java.util.List;

public class PostDataDTO {

    private Long postId;
    private String postData;
    private Instant createdAt;
    private Long userId;
    private List<CommentDataDTO> comments;
    private int likeCount;

    public PostDataDTO() {
    }

    public PostDataDTO(Long postId, String postData, Instant createdAt, Long createdBy, List<CommentDataDTO> comments, int likeCount) {
        this.postId = postId;
        this.postData = postData;
        this.createdAt = createdAt;
        this.userId = createdBy;
        this.comments = comments;
        this.likeCount = likeCount;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostData() {
        return postData;
    }

    public void setPostData(String postData) {
        this.postData = postData;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<CommentDataDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDataDTO> comments) {
        this.comments = comments;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}