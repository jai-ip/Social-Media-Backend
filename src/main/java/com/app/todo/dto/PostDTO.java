package com.app.todo.dto;

import jakarta.validation.constraints.NotBlank;

public class PostDTO {
    @NotBlank(message = "postData must be entered")
    String postData;

    public String getPostData() {
        return postData;
    }

    public void setPostData(String postData) {
        this.postData = postData;
    }
}
